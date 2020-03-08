/**
 *  MouseInput.java is a class that constucts a
 *	 MouseInput object to listen to the mouse pressed on left click, and
 *	 shoots a bullet from the player to the direction or the mouse from the
 *	 player object
 *  @author Eric Ye, Dexter White
 *  Teacher Name: Mrs. Ishman
 *  Period: 3
 *  Due Date: 05-16-2019
 */
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class MouseInput implements MouseListener
{
	//Instance Variables
	ArrayList<SmallCircle> ci;

	/** Instantiates a MouseInput object containing Timer and Player
	 *  @param ArrayList<SmallCircle> ci the arrayList of bullets
	 */
	public MouseInput(ArrayList<SmallCircle> ci)
	{
		this.ci = ci;
	}

	/** An empty mouseClicked method that has no use in the code
	 *  @param MouseEvent e the event to be heard whether or not the mouse
	 *	 	is released
	 */
	@Override
	public void mouseClicked(MouseEvent e)
	{
	}

	/** Returns the x coordinate of the mouseEvent, the mouse clicked
	 *  @param MouseEvent e the event to get the x coordinate from
	 *  @return int x the x value coordinate
	 */
	public int getX(MouseEvent e)
	{
		int x = e.getX();
		return x;
	}

	/** Returns the y coordinate of the mouseEvent, the mouse clicked
	 *  @param MouseEvent e the event to get the y coordinate from
	 *  @return int y the y value coordinate
	 */
	public int getY(MouseEvent e)
	{
		int y = e.getY();
		return y;
	}

	/** Adds a "SmallCircle" the bullet to the array according to the x and y
	 *	 coordinates of the mouse clicked
	 *  @param MouseEvent e the event to construct a small circle from
	 */
	@Override
	public void mousePressed(MouseEvent e)
	{
		if(GameComponent.start == true)
		{
			ci.add(new SmallCircle(e.getX(), e.getY()));
		}
	}

	/** An empty mouseReleased method that has no use in the code
	 *  @param MouseEvent e the event to be heard whether or not the mouse is
	 *	 	released
	 */
	@Override
	public void mouseReleased(MouseEvent e)
	{
	}

	/** An empty mouseEntered method that has no use in the code
	 *  @param MouseEvent e the event to be heard whether or not the mouse has
	 *	 	entered
	 */
	@Override
	public void mouseEntered(MouseEvent e)
	{
	}

	/** An empty mouseExited method that has no use in the code
	 *  @param MouseEvent e the event to be heard whether or not the mouse has
	 *	 	exited
	 */
	@Override
	public void mouseExited(MouseEvent e)
	{
	}
}
