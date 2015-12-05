package mainGame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Space extends JPanel 
{
	private int rows;
	private int cols;
	private SpaceCell[][] board;
	private Player ship;
	private final static int BOARD_WIDTH = 500;
	private final static int BOARD_HEIGHT = 500;
	
	public Space()
	{
		rows = 10;
		cols = 12;
		ship = new Player(9, 5);
		initCells();
		Dimension d = new Dimension(BOARD_WIDTH, BOARD_HEIGHT);
		setPreferredSize(d);
		setVisible(true);
	}
	
	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		//Calculate the size of each space cell
		int cellWidth = BOARD_WIDTH/cols;
		int cellHeight = BOARD_HEIGHT/rows;
				
		//Draw all the space cells
		for(int i = 0; i < rows; i++)
		{
			for(SpaceCell b : board[i])
			{
				b.draw(g, cellWidth, cellHeight);
			}
		}
		//setBackground(Color.ORANGE);
		//g.drawRect(100, 100, 100, 100);
		
		//Draw the player
		board[ship.getRow()][ship.getCol()].drawPlayer(g, cellWidth, cellHeight);
		
		//Draw the targets
		Problem problem = new Problem("factor", 1);
		board[1][7].drawTarget(g, cellWidth, cellHeight, problem);
		
	}
	
	public void initCells()
	{
		board = new SpaceCell[rows][cols];
		for(int i = 0; i < rows; i++)
		{
			for(int j = 0; j < cols; j++ )
			{
				board[i][j] = new SpaceCell(i, j, null);
			}
		}
	}
}
