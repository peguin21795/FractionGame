package mainGame;


import java.awt.BorderLayout;
import java.io.IOException;

import javax.swing.JFrame;

import mainGame.Problem;
import mainGame.Space;

public class GameFrame extends JFrame{

	final static int WIDTH = 500;
	final static int LENGTH = 500;

	public GameFrame()
	{
		setTitle("Battle of the Fractions!");
		setSize(WIDTH, LENGTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//We will need to add Space.java into the center of the JFrame.
		Problem problem = new Problem("divide", 1);
		MissionControl ms = new MissionControl(problem);
		add(ms, BorderLayout.SOUTH);

	}

	public static void main(String[] args) {
		GameFrame g = new GameFrame();
		g.pack();
		g.setVisible(true);
	}

}




