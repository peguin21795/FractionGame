package mainGame;

import java.awt.Color;
import java.awt.Graphics;

public class SpaceCell 
{
	private int row;
	private int col;
	private int target; //may need to be double
	
	public SpaceCell()
	{
		row = 0;
		col = 0;
		target = 0;
			
	}
	
	public SpaceCell(int r, int c, int t)
	{
		row = r;
		col = c;
		target = t;
	}
	
	public void draw(Graphics g, int cellWidth, int cellHeight)
	{
		//Calculate x and y position of the cell
		int x = cellWidth * this.col;
		int y = cellHeight * this.row;
		g.setColor(Color.BLACK);
		g.fillRect(x, y, cellWidth, cellHeight);
		g.setColor(Color.WHITE);
		g.drawRect(x, y, cellWidth, cellHeight);
	}
	
	public void drawPlayer(Graphics g, int cellWidth, int cellHeight)
	{
		int x = cellWidth * this.col;
		int y = cellHeight * this.row;
		g.setColor(Color.CYAN);
		g.fillOval(x, y, cellWidth, cellHeight);
	}
	
	public void drawTarget()
	{
		
	}
	
	public void drawLaser()
	{
		// draw as a line to the target
		// draw in individual cells if time allows to make it look like it moves
	}
	
	public int getTarget() {
		return target;
	}
	public void setTarget(int target) {
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
