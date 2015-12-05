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
	
	public void move(char m, Space s)
	{
		// should only move one space
		// move left or right depending on keyboard input
		// check that we don't move out of bounds
		if (m == 'R')
		{
			if(col < s.getWidth())
				col++;
		}
		else if(m == 'L')
		{	
			if (col > 0)
			{
				col--;
			}
		}
		else
		{
			System.out.println("Can't move there.");
		}
	}

	//Return true for a hit, false for a miss
	public boolean hitTarget(SpaceTarget target)
	{
		//Target will be "hit" if it is in the same column as the player
		return target.getCol() == this.col;
	}
	
	//Updates the gui when a shot is fired by the player
	public void shoot(SpaceTarget target)
	{
		laser = new Laser(this);
		System.out.println(laser.getCol() + ", " + laser.getRow());
		this.getDistanceToTarget(target);
		//loop until shot has hit target, using distance to target as a bound
		for(int i = 0; i < distanceToTarget; i++)
		{
			laser.updateLocation();
			System.out.println(laser.getCol() + ", " + laser.getRow());
		}
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

	public int getDistanceToTarget(SpaceTarget target) {
		if(this.hitTarget(target))
		{
			distanceToTarget = (this.row - 1) - target.getRow();
		}
		else
		{
			distanceToTarget = this.row - 1;
		}
		return distanceToTarget;
	}

	public Laser getLaser() {
		return laser;
	}

}
