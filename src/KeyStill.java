/**
 *  KeyStill.java is a class that constucts a
 *	 KeyStill object to listen to the key pressed, more specifically
 *	 if the user presses 'R', and starts the timer and manipulates the
 *	 player accordingly, basically reseting the game
 *  @author Eric Ye, Dexter White
 *  Teacher Name: Mrs. Ishman
 *  Period: 3
 *  Due Date: 05-16-2019
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
public class KeyStill extends KeyAdapter
{
	//Instance variables
	Timer time;
	Player player1;

	/** Instantiates a KeyStill object containing Timer and Player
	 *  @param Timer time the timer to be started
	 *	 @param Player player1 the Player to be manipulated, more specifically
	 *	   	its health would be set to 0, and score reset to 0 as well.
	 */
   public KeyStill(Timer time, Player player1)
   {
   	this.time = time;
		this.player1 = player1;
   }

   /** Listens to key board input and resets the game
    *	 by starting the timer, seting player health and score back
    *  to the original
	 *  @param KeyEvent e the event to be heard whether or not 'R'
	 *	 	is pressed or not
	 */
   public void keyPressed(KeyEvent e)
	{
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_R)
	   {
		   time.start();
			player1.setHealth();
			player1.setScore();
			GameComponent.start = true;
	   }
	}

	/** An empty KeyReleased method that has no use in the code
	 *  @param KeyEvent e the event to be heard whether or not the key
	 *	 	is released
	 */
	public void keyReleased(KeyEvent e)
	{
	}
}