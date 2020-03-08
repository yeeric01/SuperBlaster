/**
 *  Ship.java is an interface for constructing a
 *	 Player object. It's a super class for Player and Enemy
 *  @author Eric Ye, Dexter White
 *  Teacher Name: Mrs. Ishman
 *  Period: 3
 *  Due Date: 05-16-2019
 */

import java.awt.*;
public interface Ship
{
	/** Change the health of the object
	 */
	public void changeHealth();
	/** Draws the shapes in the object
	 *  @param Graphics2D gr the Graphics2D that is used for drawing on the
	 *	 	Jframe
	 */
	public void draw(Graphics2D gr);
}