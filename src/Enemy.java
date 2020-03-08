/** 
 * The Enemy class consists of a rectangle of a random color and a diameter of 100.
 *	The Enemy object also moves around the frame at a random velocity, bouncing at the
 *	edges. The goal of the Enemy is to collide with the Player object.
 *
 * @author Dexter White, Eric Ye
 * Collaborators: 
 * Teacher Name: Mrs. Ishman
 * Period: 3rd
 * Due Date: 5/16/19
 */
 
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

public class Enemy implements Ship
{
	//Constants
	public static final int WIDTH = 1500;
	public static final int HEIGHT = 800;
	public static final int SPEED = 10;
	public static final int HUNDRED = 100;
	public static final int TWO_FIVE_SIX = 256;
	
	//Instance Variables
	private int x;
	private int y;
	private int velX;
	private int velY;
	private int randomVal;
	private boolean exist;
	private Color color;
	private Rectangle rect;
	
	/** Creates an Enemy object that consists of a rectangle with the given x and y coordinates,
	 *  a random color, and a diameter of 100. Also creates a random velocity in the given range
	 *  and sets the exist boolean to true.
 	 *  @param x the x coordinate of the rectangle being created
 	 *  @param y the x coordinate of the rectangle being created
 	 *  @param randomVal the size of the range of possible values for the velocity.
	 */
	public Enemy(int x, int y, int randomVal) 
	{
		this.x = x;
		this.y = y;
		color = new Color((int)(Math.random() * TWO_FIVE_SIX),
			(int)(Math.random() * TWO_FIVE_SIX),(int)(Math.random() * TWO_FIVE_SIX));
		rect = new Rectangle(x, y, HUNDRED, HUNDRED);
		exist = true;
		velX = (int)(Math.random() * randomVal) + 1;
		velY = (int)(Math.random() * randomVal) + 1;
	}
	
	/** Draws the rectangle of the Enemy object using the given Graphics2D object.
 	 *  @param gr the given Graphics2D object
	 */
	public void draw(Graphics2D gr)
	{
		gr.setColor(color);
		gr.fill(rect);
	}
	
	/** Draws the rectangle of the Enemy object using the given Graphics2D object.
 	 *  @param gr the given Graphics2D object
	 */
   public void changeHealth()
   {	
   }
   
	/** Returns the color of the Enemy object.
	 */
   public Color getColor()
   {
	   return color;
   }
   
	/** Sets the color of the Enemy object to the given color.
 	 *  @param color the given color
	 */
   public void setColor(Color color)
   {
	   this.color = color;
   }
   /** Updates the position and velocity of the Enemy object, depending on where it is
    *	 within the frame.
	 */
   public void update()
   {
	   y += velY;
	   x += velX;
	   if(x < 0)
	   {
		   x = 0;
		   velX = -velX;
	   }
	   if(y < 0)
	   {
		   y = 0; 
		   velY = -velY;
	   }
	   if(x > WIDTH - HUNDRED)
	   {
		   x = WIDTH - HUNDRED;
		   velX = -velX;
	   }
	   if(y > HEIGHT - HUNDRED)
	   {
		   y = HEIGHT - HUNDRED;
		   velY = -velY;
	   }
	   
	   rect = new Rectangle(x, y, HUNDRED, HUNDRED);
   }
   
	/** Returns the rectangle of the Enemy object.
	 */
   public Rectangle getRect()
   {
	   return rect;
   }
   
	/** Returns the x coordinate of the Enemy object.
	 */
   public int getX()
   {
   	return x;
   }
   
	/** Returns the y coordinate of the Enemy object.
	 */
   public int getY()
   {
   	return y;
   }
   
	/** Sets the x velocity of the Enemy object to the given velocity.
	 *  @param x1 the given velocity
	 */
   public void setVelX(int x1)
   {
   	velX = x1;
   }
   
	/** Sets the y velocity of the Enemy object to the given velocity.
	 *  @param y1 the given velocity
	 */
   public void setVelY(int y1)
   {
   	velY = y1;
   }
   
	/** Sets the x coordinate of the Enemy object to the given coordinate.
	 *  @param x the given coordinate
	 */
   public void setX(int x)
   {
   	this.x = x;
   }
   
	/** Sets the y coordinate of the Enemy object to the given coordinate.
	 *  @param y the given coordinate
	 */
   public void setY(int y)
   {
   	this.y = y;
   }	
   	
}
