package mainFrame;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import mainGame.Problem;

public class GameFrame extends JFrame{
	
	final static int WIDTH = 500;
	final static int LENGTH = 500;
	
	public GameFrame()
	{
		setTitle("Battle of the Fractions!");
		setSize(WIDTH, LENGTH);
		//We will need to add Space.java into the center of the JFrame.
		
		Problem problem = new Problem("divide", 1);
		add(problem, BorderLayout.SOUTH);
	}
	
	public static void main(String[] args) {
		GameFrame g = new GameFrame();
		g.setVisible(true);
	}

}
