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
	
	public Space()
	{
		rows = 10;
		cols = 10;
		ship = new Player(9, 5);
		initCells();
		Dimension d = new Dimension(500, 500);
		setPreferredSize(d);
		setVisible(true);
	}
	
	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		//Calculate the size of each space cell
		int cellWidth = 500/cols;
		int cellHeight = 500/rows;
				
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
		
	}
	
	public void initCells()
	{
		board = new SpaceCell[rows][cols];
		for(int i = 0; i < rows; i++)
		{
			for(int j = 0; j < cols; j++ )
			{
				board[i][j] = new SpaceCell(i, j, 0);
			}
		}
	}
}
