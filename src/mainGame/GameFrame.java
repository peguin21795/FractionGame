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

	final static int WIDTH = 1000;
	final static int LENGTH = 1000;
	//private static Space space;

	public GameFrame() 
	{
		setTitle("Battle of the Fractions!");
		setSize(WIDTH, LENGTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//We will need to add Space.java into the center of the JFrame.
		Problem problem = new Problem("factor", 1);
		MissionControl ms = new MissionControl(problem);
		Space space = new Space(ms);
		add(ms, BorderLayout.SOUTH);
		add(space, BorderLayout.CENTER);
		
		addKeyListener(space);
		//Sound soundTest = new Sound();
		//add(soundTest, BorderLayout.NORTH);

	}

	public static void main(String[] args)  {
		GameFrame g = new GameFrame();
		g.pack();
		g.setVisible(true);
	}

}




