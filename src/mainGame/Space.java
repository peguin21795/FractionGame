package mainGame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Space extends JPanel implements KeyListener
{
	private int rows;
	private int cols;
	private SpaceCell[][] board;
	private Player ship;
	private Laser laser;
	private final static int BOARD_WIDTH = 500;
	private final static int BOARD_HEIGHT = 500;
	private int cellWidth;
	private int cellHeight;
	private MissionControl control;
	private ArrayList<SpaceTarget> targets;
	private boolean playerShot = false;
	
	public Space(MissionControl ms)
	{
		control = ms;
		targets = control.generateTargets();
		rows = 10;
		cols = 12;
		ship = new Player(9, 5);
		initCells();
		addKeyListener(this);
		Dimension d = new Dimension(BOARD_WIDTH, BOARD_HEIGHT);
		setPreferredSize(d);
		setVisible(true);
	}
	
	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		//Calculate the size of each space cell
		cellWidth = BOARD_WIDTH/cols;
		cellHeight = BOARD_HEIGHT/rows;
				
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
		for(SpaceTarget s : targets)
		{
			board[s.getRow()][s.getCol()].drawTarget(g, cellWidth, cellHeight, s.getTargetNumber());
		}
		
		//Draw laser if necessary
		if(playerShot)
		{
			laser = new Laser(ship, this);
			SpaceTarget temp = new SpaceTarget(0, 0, 0);
			for (SpaceTarget t : targets)
			{
				if (t.getCol() == ship.getCol())
				{
					temp = t;
				}
			}
			int distance = ship.getDistanceToTarget(temp);
			//loop until shot has hit target, using distance to target as a bound
			for(int i = 0; i < distance; i++)
			{
				board[laser.getRow()][laser.getCol()].drawLaser(g, cellWidth, cellHeight);
				laser.updateLocation();
			}
		}
		
		
		
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
	
	public SpaceCell getCellAt(int r, int c)
	{
		return board[r][c];
	}

	public int getCellWidth() {
		return cellWidth;
	}

	public int getCellHeight() {
		return cellHeight;
	}

	public void setPlayerShot(boolean playerShot) {
		this.playerShot = playerShot;
	}

	public void keyPressed(KeyEvent e)
	{
		//The player should shoot if the space key is pressed
		if(e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			setPlayerShot(true);
			this.repaint();
		}
		else if(e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			setPlayerShot(false);
			ship.move('L', this);
			this.repaint();
		}
		else if(e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			setPlayerShot(false);
			ship.move('R', this);
			this.repaint();
		}
		
	}
	
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
