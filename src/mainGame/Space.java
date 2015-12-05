package mainGame;

import java.awt.Graphics;

import javax.swing.JPanel;

import mainFrame.GameFrame;

public class Space extends JPanel 
{
	// Values set arbitrarily, needed for tests
	private static final int BOARD_WIDTH = 500;
	private static final int BOARD_HEIGHT = 500;
	private int rows;
	private int cols;
	private SpaceCell[][] board;
	
	public Space()
	{
		rows = 10;
		cols = 10;
		this.setSize(BOARD_WIDTH, BOARD_HEIGHT);
		initialize();
	}
	
	public void initialize()
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
	
	public void paintComponent(Graphics g)
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
		
		//Draw the player
	}
	
	public void generateStars(){
		
	}
	
	public void selectPlayerShape(){
		
	}
	
	public int getWidth() {
		return rows;
	}

	public int getHeight() {
		return cols;
	}

	public static int getWindowWidth() {
		return BOARD_WIDTH;
	}

	public static int getWindowHeight() {
		return BOARD_HEIGHT;
	}
}
