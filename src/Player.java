/**
 *  Player.java is a class that constucts a
 *	 Player object to listen to the mouse pressed on left click, and
 *	 shoots a bullet from the player to the direction or the mouse from the
 *	 player object
 *  @author Eric Ye, Dexter White
 *  Teacher Name: Mrs. Ishman
 *  Period: 3
 *  Due Date: 05-16-2019
 */
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
public class Player implements Ship
{
	//Constances
	public static final int WIDTH = 1500;
	public static final int HEIGHT = 800;
	public static final int SPEED = 10;
	public static final int HUNDRED = 100;
	public static final int TWO_FIVE_SIX = 256;
	public static final int TWENTY_FIVE = 25;
	public static final int FIVE_HUNDRED = 500;
	public static final int FIFTY = 50;

	//Public Instance Varaibles
	public static Integer x;
	public static Integer y;

	//Private Instance Varaibles
	private int velX;
	private int velY;
	private int health;
	private int score;
	private int level;
	private Color color;
	private Rectangle rect;

	/** Instantiates a Player object that positions the Player object
	 *		according to int x and int y
	 *  @param int x the x position where the square should be instantiated
	 *	 @param int y the y position where the square should be instantiated
	 */
	public Player(int x, int y)
	{
		Player.x = x;
		Player.y = y;
		score = 0;
		health = HUNDRED;
		level = 1;
		color = new Color((int)(Math.random() * TWO_FIVE_SIX),
			(int)(Math.random() * TWO_FIVE_SIX),(int)(Math.random() * TWO_FIVE_SIX));
		rect = new Rectangle(x, y, HUNDRED / 2, HUNDRED / 2);
	}

	/** Draws the player, score, level, and health on the screen
	 *  @param Graphics2D gr the Graphics2D that is used for drawing on the
	 *	 	Jframe
	 */
	public void draw(Graphics2D gr)
	{
		if(health != 0)
		{
			gr.setColor(Color.BLACK);
			gr.setFont(new Font("default", Font.BOLD, FIFTY));
			gr.drawString("level: " + level, FIVE_HUNDRED, FIFTY);
			gr.setFont(new Font("default", Font.BOLD, FIFTY));
			gr.drawString("score: " + score, FIFTY, FIFTY);
			gr.setColor(color);
			gr.fill(rect);
			gr.setFont(new Font("default", Font.BOLD, 20));
			gr.setColor(Color.WHITE);
			gr.drawString("" + health, x + 10, y + TWENTY_FIVE);
			gr.setColor(Color.BLUE);
		}
		else
		{
			gr.setColor(Color.BLACK);
			gr.setFont(new Font("default", Font.BOLD, FIFTY));
			gr.drawString("level: " + level, FIVE_HUNDRED, FIFTY);
			gr.setFont(new Font("default", Font.BOLD, FIFTY));
			gr.drawString("score: " + score, TWENTY_FIVE, FIFTY);
			death(gr);
		}
	}

	/** Helper method to draw what happens after game is stopped
	 *  @param Graphics2D gr the Graphics2D that is used for drawing on the
	 *	 	Jframe
	 */
   public void death(Graphics2D gr)
   {
   	gr.setColor(new Color(0,0,0,0));
	   gr.fill(rect);
	  	gr.setColor(color);
	  	for(int i = 0; i < 10; i++)
	  	{
	  		Rectangle recty = new Rectangle((int)(Math.random() * HUNDRED) + x, (int)(Math.random() * HUNDRED) + y, TWENTY_FIVE, TWENTY_FIVE);
	  		gr.fill(recty);
	  	}
   }
   
  	/** Increment score by one
	 */
  	public void changeScore()
  	{
  		score++;
  	}
  	
  	/** Change score to zero
	 */
   public void setScore()
   {
   	score = 0;
   }

   /** Returns the score
    *	@return int score the score of the player
	 */
  	public int getScore()
  	{
  		return score;
  	}
  	
  	/** Decrease health by 10
	 */
  	public void changeHealth()
  	{
  		health -= 10;
  	}

  	/** Returns health
  	 *	@return int health the health of the player
	 */
  	public int getHealth()
  	{
  		return health;
  	}

  	/** Set health to 100
	 */
  	public void setHealth()
  	{
	   health = HUNDRED;
  	}

  	/** Updates x, y and rectangle according to velocity of x and y
	 */
  	public void update()
  	{
	   y += velY;
	   x += velX;
	   rect = new Rectangle(x, y, HUNDRED / 2, HUNDRED / 2);
  	}

  	/** Returns X
  	 *	@return int x the x coordinate of the player
	 */
  	public int getX()
  	{
  		return x;
  	}

  	/** Returns Y
  	 *	@return int y the y coordinate of the player
	 */
  	public int getY()
  	{
  		return y;
  	}

  	/**Set velocity of x to input
  	 * @param int x1 the velocity of x to be set to
  	 */
  	public void setVelX(int x1)
  	{
  		velX = x1;
  	}

  	/**Set velocity of y to input
  	 * @param int y1 the velocity of y to be set to
  	 */
  	public void setVelY(int y1)
  	{
  		velY = y1;
  	}

   /**Set x to specified cooridnate
    * @param int x the position of x to be set to
    */
   public void setX(int x)
   {
   	this.x = x;
   }

   /**Set y to specified cooridnate
    * @param int y the position of y to be set to
    */
   public void setY(int y)
   {
   	this.y = y;
   }

	/**Return the rectangle of the player
  	 * @return Rectangle rect the rectangle of the player
  	 */
  	public Rectangle getRect()
  	{
  		return rect;
  	}

  	/**Increase level by one
  	 */
  	public void inLevel()
  	{
  		level++;
  	}

  	/**Method that changes the player object according to the user input
  	 * 		pressed on the key
  	 * @param KeyEvent e the key event that is being pressed on the key
  	 * 		board
  	 */
  	public void keyPressed(KeyEvent e)
  	{
   	int key = e.getKeyCode();
   	if(key == KeyEvent.VK_W)
	   {
		   velY = -SPEED;
	   }
	   else if(key == KeyEvent.VK_S)
	   {
		   velY = SPEED;
	   }
	   else if(key == KeyEvent.VK_A)
	   {
		   velX = -SPEED;
	   }
	   else if(key == KeyEvent.VK_D)
	   {
		   velX = SPEED;
	   }
   }

   /**Method that changes the player object according to the user input
    * 		released on the key
    * @param KeyEvent e the key event that is being released on the key
    * 		board
    */
   public void keyReleased(KeyEvent e)
   {
	   int key = e.getKeyCode();
	   if(key == KeyEvent.VK_W)
	   {
		   velY = 0;
	   }
	   else if(key == KeyEvent.VK_S)
	   {
		   velY = 0;
	   }
	   else if(key == KeyEvent.VK_A)
	   {
		   velX = 0;
		   if(x <= 0)
   		{
   			velX = 0;
   			x = 0;
   		}
	   }
	   else if(key == KeyEvent.VK_D)
	   {
		   velX = 0;
	   }
  	}
}