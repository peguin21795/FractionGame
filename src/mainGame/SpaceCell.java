package mainGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class SpaceCell 
{
	private int row;
	private int col;
	private Term target;
	
	public SpaceCell()
	{
		row = 0;
		col = 0;
		target = null;
			
	}
	
	public SpaceCell(int r, int c, Term t)
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
		g.fillOval(x, y, cellWidth,  cellHeight);
	}
	
	public void drawTarget(Graphics g, int cellWidth, int cellHeight, Problem problem)
	{
		int x = cellWidth * this.col;
		int y = cellHeight * this.row;
		setTarget(problem.getSolution());
		String test = Integer.toString(target.getNumerator());
		g.setColor(Color.WHITE);
		Font myFont = new Font("Serif", Font.BOLD, 24);
		g.setFont(myFont);
		g.drawString(test, x + 15, y - 20);
	}
	
	public void drawLaser()
	{
		// draw as a line to the target
		// draw in individual cells if time allows to make it look like it moves
	}
	
	public Term getTarget() {
		return target;
	}
	public void setTarget(Term target) {
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
