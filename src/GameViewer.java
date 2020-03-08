/**
 *  GameViewer.java is a class that instantiates all of the
 *	 components and objects of the game and displays it on a 
 *	 JFrame
 *  @author Eric Ye, Dexter White
 *  Teacher Name: Mrs. Ishman
 *  Period: 3
 *  Due Date: 05-16-2019
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
public class GameViewer extends JFrame implements ActionListener
{
	//Constances
	public static final int WIDTH = 1500;
	public static final int HEIGHT = 800;
	public static final String PLAY = "PLAY";
	public static final String CONTROLS = "CONTROLS";
	public static final String QUIT = "QUIT";
	
	//Instance Variables
	private JButton controlsButton;
	private JButton quitButton;
	private JButton playButton;
	private JPanel actionPanel;
	private JPanel imagePanel;
	private JTextArea outputArea;
	private JLabel label;
	
   public GameViewer()
   {
		// GUI set-up
		setupPanel();

		// set-up frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("SUPER BLASTER 2D");
		setSize(WIDTH, HEIGHT);
		setVisible(true);
	}
	
	/** 
	 *  Respond to a command of the button
	 *  @param event the event or command received
	 */
	public void actionPerformed(ActionEvent event) 
	{
		if (event.getActionCommand().equals(PLAY)) 
		{
			dispose();
			gameInitiating();
		}
		else if (event.getActionCommand().equals(CONTROLS)) 
		{
			label.setIcon(null);
			label.revalidate();
			ImageIcon imageIcon = new ImageIcon(new ImageIcon("C:/Users/charl/Desktop/JavaWorkSpace/2DJavaShoot/src/Controls.png").getImage()
				.getScaledInstance(WIDTH, HEIGHT, Image.SCALE_DEFAULT));
			label.setIcon(imageIcon);
			imagePanel.add(label);
			add(imagePanel);
		}
		else if(event.getActionCommand().equals(QUIT)) 
		{
			dispose();
		}
	}
	public void gameInitiating()
	{
		JFrame frameGame = new JFrame("SUPER BLASTER 2D");
		frameGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameGame.setSize(WIDTH, HEIGHT);
		frameGame.setVisible(true);
		frameGame.setResizable(false);
		frameGame.add(new GameComponent());
	}
	public static void main(String[] args)
	{
		GameViewer test = new GameViewer();
	}
	private void setupPanel()
	{
		setupImagePanel();
		setupActionPanel();
		setLayout(new BorderLayout());
		add(imagePanel, BorderLayout.PAGE_START);
		add(actionPanel, BorderLayout.PAGE_END);

	}

	/**
	 *  Set-up panel for JButtons
	 */
	private void setupActionPanel() 
	{
		playButton = new JButton(PLAY);
		playButton.setEnabled(true);
		playButton.addActionListener(this);
		playButton.setActionCommand(PLAY);
		
		controlsButton = new JButton(CONTROLS);
		controlsButton.setEnabled(true);
		controlsButton.addActionListener(this);
		controlsButton.setActionCommand(CONTROLS);
		
		quitButton = new JButton(QUIT);
		quitButton.setEnabled(true);
		quitButton.addActionListener(this);
		quitButton.setActionCommand(QUIT);
		
		actionPanel = new JPanel();
		actionPanel.add(playButton);
		actionPanel.add(controlsButton);
		actionPanel.add(quitButton);
	}
	
	/**
	 *  Set-up image panel and displays on the JFrame
	 */
	private void setupImagePanel() 
	{
		imagePanel = new JPanel();
		label = new JLabel();
		ImageIcon imageIcon = new ImageIcon(new ImageIcon("C:/Users/charl/Desktop/JavaWorkSpace/2DJavaShoot/src/Welcome.png")
			.getImage().getScaledInstance(WIDTH, HEIGHT, Image.SCALE_DEFAULT));
		label.setIcon(imageIcon);
		imagePanel.add(label);		
	}
}