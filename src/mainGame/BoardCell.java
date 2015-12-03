package mainGame;

public class BoardCell 
{
	int row;
	int col;
	char target;
	
	public void draw()
	{
		// draw basic boardcells
	}
	
	public void drawPlayer()
	{
		
	}
	
	public void drawTarget()
	{
		
	}
	
	public void drawLaser()
	{
		// draw as a line to the target
		// draw in individual cells if time allows to make it look like it moves
	}
	
	public char getTarget() {
		return target;
	}
	public void setTarget(char target) {
		this.target = target;
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
