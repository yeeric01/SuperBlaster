/** 
 * The GameComponent class is in charge of drawing the Player object, the Enemy objects,
 *	and the bullet objects. It is also in charge of updating the positions of each of these
 *	objects using a timer. Finally, this class also checks for collisions between objects
 *	and updates the difficulty when the score reaches certain intervals.
 *
 * @author Dexter White, Eric Ye
 * Collaborators:
 * Teacher Name: Mrs. Ishman
 * Period: 3rd
 * Due Date: 5/16/19
 */

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Area;
import java.util.ArrayList;
import javax.swing.*;

public class GameComponent extends JComponent implements ActionListener
{
	//Constants
	public static final int WIDTH = 1900;
	public static final int HEIGHT = 1000;
	public static final int FIVE = 5;
	public static final int TEN = 10;
	public static final int TWENTY_FIVE = 25;
	public static final int FIFTY = 50;
	public static final int HUNDRED = 100;
	public static final int TWO_HUNDRED = 200;
	public static final int THREE_HUNDRED = 300;
	
	//Static Variables
	public static boolean start;
	
	//Instance Variables
	private Player player1;
	private ArrayList<Enemy> en;
	private ArrayList<SmallCircle> ci;
	private Timer time;
	private MouseInput mi;
	private int enemyNum;
	private int enemyVel;;
	
	/** Creates an Enemy object that consists of an ArrayList of enemies, an ArrayList of
	 *	 small circles (bullets), a player object, and sets up the Listeners that will
	 *  allow for the shooting of the bullets.
	 */
	public GameComponent() 
	{
		
		setFocusable(true);
		en = new ArrayList<Enemy>();
		ci = new ArrayList<SmallCircle>();
    	player1 = new Player(WIDTH / 2 - TWENTY_FIVE, HEIGHT / 2 - TWENTY_FIVE);
    	addKeyListener(new KeyAdapt(player1));
    	mi = new MouseInput(ci);
    	enemyNum = FIVE;
    	enemyVel = FIVE;
    	addMouseListener(mi);
    	time = new Timer(TEN, this);
    	time.start();
    	start = true;
	}
   
	/** Paints all objects on to the frame.
	 *  @param gr the graphics object that is used to draw
	 */
   @Override
	public void paintComponent(Graphics gr)
	{
		super.paintComponent(gr);
		Graphics2D g2 = (Graphics2D) gr;
		player1.draw(g2);
		for(int i = 0; i < en.size(); i++)
		{
			gr.setColor(en.get(i).getColor());
			en.get(i).draw(g2);
		}
		for(int i = 0; i < ci.size(); i++)
		{
			ci.get(i).update();
		}
		for(int i = 0; i < ci.size(); i++)
		{
			ci.get(i).update();
			if(!ci.get(i).getExist())
				ci.remove(i);
		}
		for(int i = 0; i < ci.size(); i++)
		{
	   	Rectangle cR1 = ci.get(i).getRect();
			for(int x = 0; x < en.size(); x++)
			{
				Rectangle cR2 = en.get(x).getRect();
				Area a1 = new Area(cR1);
				Area b1 = new Area(cR2);
				a1.intersect(b1);
				if(!a1.isEmpty())
				{
					en.remove(x);
					player1.changeScore();
				}
			}
		}
		help1(g2);
		if(player1.getHealth() <= 0)
		{
			reset(g2);
		}
		
	}
	
	/** Helper method for the paintComponent(), checks and updates the frame
	 *  based on score and health of the player.
	 *  @param gr the Graphics2D object that is used to draw objects on the frame
	 */
	public void help1(Graphics2D gr)
	{
		for(int x = 0; x < en.size(); x++)
		{
			Rectangle cR2 = en.get(x).getRect();
			Rectangle cR1 = player1.getRect();
			Area a1 = new Area(cR1);
			Area b1 = new Area(cR2);
			a1.intersect(b1);
			if(!a1.isEmpty())
			{
				en.remove(x);
				player1.changeHealth();
				player1.changeScore();
			}
		}
		for(int i = 0; i < ci.size(); i++)
		{
			gr.setColor(ci.get(i).getColor());
			ci.get(i).draw(gr);
		}
		if(player1.getScore() % FIFTY == 0 && player1.getScore() != 0)
		{
			enemyNum += 1;
			enemyVel += 2;
			player1.changeScore();
			player1.inLevel();
		}
		if(en.size() < enemyNum)
		{
			en.add(new Enemy((int)(Math.random() * (WIDTH - HUNDRED)),
			 (int)(Math.random() * (HEIGHT - HUNDRED)), enemyVel));
		}
	}
	
	/** Displays the game over screen, allows the player to restart, and 
	 *	 resets the frame to the original settings in case the player chooses
	 *  to restart.
	 *  @param gr the Graphics2D object that is used to draw objects on the frame
	 */
	public void reset(Graphics2D gr)
	{
		player1.death(gr);
		repaint();
		time.stop();
		gr.setFont(new Font("default", Font.BOLD, HUNDRED));
		gr.setColor(Color.BLACK);
		gr.drawString("GAME OVER", WIDTH / 2 - THREE_HUNDRED, HEIGHT / 2 - TWENTY_FIVE);
		gr.drawString("PRESS R TO TRY AGAIN?", WIDTH / 2 - THREE_HUNDRED * 2, HEIGHT / 2 + TWO_HUNDRED);
		addKeyListener(new KeyStill(time, player1));
		enemyNum = FIVE;
		enemyVel = FIVE;
		en.clear();
		start = false;
	}
	
	/** Checks to see whether the points of two objects are overlapping.
	 *  @param l1 the first point of the upperleft corner of the first object
	 *  @param r1 the first point of the upperleft corner of the second object
	 *  @param l2 the second point of the upperleft corner of the first object
	 *  @param r2 the second point of the upperleft corner of the second object
	 *  @return whether the points are overlapping or not
	 */
   public boolean overlaps(Point l1, Point r1, Point l2, Point r2)
   {
	   if (l1.x > r2.x || l2.x > r1.x) { 
           return false; 
       } 
 
       // If one rectangle is above other  
       if (l1.y < r2.y || l2.y < r1.y) { 
           return false; 
       } 
 
       return true;
   }
   
	/** Updates the velocity and coordinates of the player object depending on where
	 *  they are on the frame and repaints the frame.
	 *  @param arg0 the event that takes place
	 */
   @Override
   public void actionPerformed(ActionEvent arg0)
   {
   	if(player1.getX() < 0)
   	{
   		player1.setVelX(0);
   		player1.setX(0);
   	}
   	else if(player1.getX() + FIFTY> WIDTH)
   	{
   		player1.setVelX(0);
   		player1.setX(WIDTH - FIFTY);
   	}
   	else if(player1.getY() < 0)
   	{
   		player1.setVelY(0);
   		player1.setY(0);
   	}
   	else if(player1.getY() + FIFTY + 40> HEIGHT)
   	{
   		player1.setVelY(0);
   		player1.setY(HEIGHT - FIFTY - 40);
   	}
   	else
   	{
   		player1.update();
   	}
   	for(int a = 0; a < en.size(); a++)
   	{
   		en.get(a).update();
   	}
		repaint();
   }
}