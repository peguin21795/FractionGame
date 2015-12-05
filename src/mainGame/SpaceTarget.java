package mainGame;

public class SpaceTarget implements Movable{
	
	private int targetNumber;
	private int row;
	private int col;
	
	public SpaceTarget()
	{
		row = 0;
		col = 0;
		targetNumber = 0;
	}
	
	public SpaceTarget(int r, int c, int targetNumber)
	{
		row = r;
		col = c;
		this.targetNumber = targetNumber;
	}
	
	public void move(char m, Space s){
		
	}

	public void setTargetNumber(int storeTargetNumber) {
		this.targetNumber = storeTargetNumber;
	}
	
	public int getTargetNumber()
	{
		return targetNumber;
	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public void setCol(int col) {
		this.col = col;
	}
	

}
