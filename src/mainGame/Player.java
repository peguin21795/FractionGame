package mainGame;
public class Player implements Movable{
	private int row;
	private int col;
	private int distanceToTarget;
	private Laser laser;
	
	public Player()
	{
		row = 0;
		col = 0;
	}
	
	public Player(int r, int c)
	{
		row = r;
		col = c;
	}
	
	public void move()
	{
		// should only move one space
		// move left or right depending on keyboard input
		// check that we don't move out of bounds
	}

	//Return true for a hit, false for a miss
	public boolean hitTarget(SpaceTarget target)
	{
		//Target will be "hit" if it is in the same column as the player
		return false;
	}
	
	//Updates the gui when a shot is fired by the player
	public void shoot(SpaceTarget target)
	{
		//loop until shot has hit target, using distance to target as a bound
	}
	
	public int getRow()
	{
		return row;
	}
	
	public int getCol()
	{
		return col;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public int getDistanceToTarget() {
		return distanceToTarget;
	}

	public Laser getLaser() {
		return laser;
	}

}
