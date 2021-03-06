package mainGame;

public class Laser 
{
	private int row; 
	private int col;
	@SuppressWarnings("unused")
	private Space space;
	
	public Laser()
	{
		row = 0;
		col = 0;
	}
	
	public Laser(Player p, Space s)
	{
		row = p.getRow() - 1;
		col = p.getCol();
		space = s;
	}
	
	public void updateLocation()
	{
		row--;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

}
