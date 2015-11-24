package mainGame;
public class Player implements Movable{
	private int row;
	private int col;
	
	public Player()
	{
		row = 0;
		col = 0;
	}
	
	public void move()
	{
		// should only move one space
		// move left or right depending on keyboard input
		// check that we don't move out of bounds
	}
	
	public void shootTarget()
	{
		
	}
	
	public int getRow()
	{
		return row;
	}
	
	public int getCol()
	{
		return col;
	}

}
