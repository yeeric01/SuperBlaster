/**
 *  KeyAdapt.java is a class that constucts a
 *	 KeyAdapt object to listen to the key pressed and
 *	 mutates the Player object accordingly
 *  @author Eric Ye, Dexter White
 *  Teacher Name: Mrs. Ishman
 *  Period: 3
 *  Due Date: 05-16-2019
 */
import java.awt.event.*;
public class KeyAdapt extends KeyAdapter
{
	//Instance Variables
	Player p;

	/** Instantiates a KeyAdapt object containing the KeyAdapt
	 *  @param Player player the Player to be manipulated
	 */
	public KeyAdapt(Player player)
	{
		p = player;
	}
	/** Calls the player method key pressed to make sure
	 *	 	the player responds and mutates according to the key pressed
	 *  @param KeyEvent e the KeyEvent of the key being pressed
	 */
	public void keyPressed(KeyEvent e)
	{
		p.keyPressed(e);
	}
	/** Calls the player method key released to make sure
	 *	 	the player responds and mutates according to the key released
	 *  @param KeyEvent e the KeyEvent of the key being released
	 */
	public void keyReleased(KeyEvent e)
	{
		p.keyReleased(e);
	}
}
