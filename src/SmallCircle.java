/**
 *  SmallCircle.java is a class that constucts a
 *	 SmallCircle object(basically the bullets I'm sorry Mrs.Ishman I don't know why
 *	 I named this class this name the bullets aren't even circles) that interacts with
 *	 the player, enemy, and mouse
 *  @author Eric Ye, Dexter White
 *  Teacher Name: Mrs. Ishman
 *  Period: 3
 *  Due Date: 05-16-2019
 */
import java.awt.*;
import java.awt.event.MouseEvent;
public class SmallCircle
{
	//Constances
    public static final int WIDTH = 1500;
	 public static final int HEIGHT = 800;
    public static final int TEN = 10;

    //Instance Variables
    private int x;
    private int y;
    private int rX;
    private int rY;
    private double vX;
    private double vY;
    private boolean exist;
    private Color color;
    private Rectangle rect;

    /** 
     *	Instantiates a SmallCircle object that positions the SmallCircle object
     *	according to int x and int y(the mouse clicked coordinates)
	  *   @param int rX the x position where the mouse is clicked
	  *	@param int rY the y position where the mouse is clicked
	  */
    public SmallCircle(int rX, int rY)
    {
    	this.x = Player.x + 25;
		this.y = Player.y + 25;
		this.rX = rX;
		this.rY = rY;
		exist = true;
		color = Color.BLUE;
		rect = new Rectangle(x, y, TEN, TEN);
		calcVel();
    }

    /** Draws the square
	 *   @param Graphics2D gr the Graphics2D that is used for drawing on the
	 *	  	Jframe
	 */
    public void draw(Graphics2D gr)
	{
		gr.setColor(color);
		gr.fill(rect);
	}

	/** Updates x, y and rectangle according to velocity of x and y
	 */
    public void update()
    {
    	if (x > WIDTH || x < 0 || y > HEIGHT || y < 0)
            exist = false;
    	x += vX;
    	y += vY;
    	rect = new Rectangle(x, y, TEN, TEN);
    }

    /** Helper method that calculates the x and y velocity vectors
     *		based on where the mouse is clicked
	  */
    public void calcVel()
    {
    	double x1 = Math.pow(rX - x, 2);
    	double y1 = Math.pow(rY - y, 2);
    	double hypotenuse = Math.sqrt(x1 + y1);
    	double ratio =  10.0 / hypotenuse;
    	vX = (rX - x) * ratio;
    	vY = (rY - y) * ratio;
    }

    /** Returns the rectangle
     *	@return Rectangle rect the rectangle
	  */
    public Rectangle getRect()
    {
    	return rect;
    }

    /** Returns the color of the rectangle
     *	@return Color color the color of the rectangle
	  */
    public Color getColor()
    {
    	return color;
    }

    /** Returns whether or not the SmallCircle exists
     *	@return boolean exist whether or not the SmallCircle exists
	  */
    public boolean getExist()
    {
    	return exist;
    }

    /** Returns x coordinate of the SmallCircle
     *	@return int x the x coordinate of the SmallCircle
	  */
    public int getX()
    {
    	return x;
    }

    /** Returns y coordinate of the SmallCircle
     *	@return int y the y coordinate of the SmallCircle
	  */
    public int getY()
    {
    	return y;
    }

    /** Returns x velocity of the SmallCircle
     *	@return int vX the x velocity of the SmallCircle
	  */
    public double getVx()
    {
    	return vX;
    }

    /** Returns y velocity of the SmallCircle
     *	@return int vY the y velocity of the SmallCircle
	  */
    public double getVy()
    {
    	return vY;
    }
}
