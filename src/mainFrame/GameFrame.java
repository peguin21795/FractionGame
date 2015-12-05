package mainFrame;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import mainGame.Problem;
import mainGame.Space;

public class GameFrame extends JFrame{
	
	final static int WIDTH = 800;
	final static int LENGTH = 800;
	private static Space space;
	
	public GameFrame()
	{
		setTitle("Battle of the Fractions!");
		setSize(WIDTH, LENGTH);
		//We will need to add Space.java into the center of the JFrame.
		space = new Space();
		add(space, BorderLayout.CENTER);
		Problem problem = new Problem("divide", 1);
		add(problem, BorderLayout.SOUTH);
	}
	
	public static void main(String[] args) {
		GameFrame g = new GameFrame();
		g.pack();
		g.setVisible(true);
	}

}
