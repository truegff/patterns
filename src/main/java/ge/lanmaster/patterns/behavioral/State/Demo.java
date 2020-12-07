package ge.lanmaster.patterns.behavioral.State;

import ge.lanmaster.patterns.behavioral.State.states.DirtyState;

import javax.swing.*;
import java.awt.*;

/**
 * This class demonstrates the basics of setting up a Java Swing GUI uisng the
 * BorderLayout. You should be able to use this program to drop in other
 * components when building a GUI
 */
public class Demo {
	// Initialize all swing objects.

	private JFrame f = new JFrame("Basic GUI"); //create Frame
	private JPanel pnlSouth = new JPanel(); // South quadrant
	private JPanel pnlCenter = new JPanel(); // Center quadrant

	// Menu
	private JMenuBar mb = new JMenuBar(); // Menubar
	private JMenu mnuFile = new JMenu("File"); // File Entry on Menu bar
	private JMenuItem mnuItemQuit = new JMenuItem("Quit"); // Quit sub item
	private JMenu mnuHelp = new JMenu("Help"); // Help Menu entry
	private JMenuItem mnuItemAbout = new JMenuItem("About"); // About Entry

	/**
	 * Constructor for the GUI
	 */
	public Demo() {

		DirtyState ds = new DirtyState();

		// Set menubar
		f.setJMenuBar(mb);

		//Build Menus
		mnuFile.add(mnuItemQuit);  // Create Quit line
		mnuHelp.add(mnuItemAbout); // Create About line
		mb.add(mnuFile);        // Add Menu items to form
		mb.add(mnuHelp);

		// Add Buttons

		// Setup Main Frame
		f.getContentPane().setLayout(new BorderLayout());
		f.getContentPane().add(pnlSouth, BorderLayout.SOUTH);
		f.getContentPane().add(pnlCenter, BorderLayout.CENTER);

		// Allows the Swing App to be closed
		f.addWindowListener(new ListenCloseWdw());

		//Add Menu listener
		mnuItemQuit.addActionListener(new ListenMenuQuit());
	}

	public void launchFrame() {
		// Display Frame
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.pack(); //Adjusts panel to components for display
		f.setVisible(true);
	}

	public static void main(String args[]) {
		Demo gui = new Demo();
		gui.launchFrame();
	}

}
