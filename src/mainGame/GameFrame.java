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
		//Generate the first problem
		Problem problem = new Problem("divide", 1, 0);
		//Add components to frame
		MissionControl ms = new MissionControl(problem);
		StatusPanel sp = new StatusPanel();
		Space space = new Space(ms, problem, sp);
		add(ms, BorderLayout.SOUTH);
		add(space, BorderLayout.CENTER);
		add(sp, BorderLayout.EAST);
		addKeyListener(space);
		space.setFocusable(true);
		//Sound soundTest = new Sound();
		//add(soundTest, BorderLayout.NORTH);

	}

	public static void main(String[] args)  {
		GameFrame g = new GameFrame();
		g.pack();
		g.setVisible(true);
	}

}




