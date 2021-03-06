package mainGame;

public class SpaceTarget implements Movable{
	
	private int targetNumber;
	private float targetFloat;
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
	
	public SpaceTarget(int r, int c, float targetFloat)
	{
		row = r;
		col = c;
		this.targetFloat = targetFloat;
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

	public float getTargetFloat() {
		return targetFloat;
	}

	public void setTargetFloat(float targetFloat) {
		this.targetFloat = targetFloat;
	}
	
	
	

}
