package mainGame;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import mainGame.Problem;
import mainGame.Space;

public class GameFrame extends JFrame{

	final static int WIDTH = 500;
	final static int LENGTH = 500;
	//private static Space space;

	public GameFrame() 
	{
		setTitle("Battle of the Fractions!");
		setSize(WIDTH, LENGTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//We will need to add Space.java into the center of the JFrame.
		//space = new Space();
		Space test = new Space();
		Problem problem = new Problem("add", 3);
		MissionControl ms = new MissionControl(problem);
		add(ms, BorderLayout.SOUTH);
		add(test, BorderLayout.CENTER);
		//Sound soundTest = new Sound();
		//add(soundTest, BorderLayout.NORTH);

	}

	public static void main(String[] args)  {
		GameFrame g = new GameFrame();
		g.pack();
		g.setVisible(true);
	}

}




