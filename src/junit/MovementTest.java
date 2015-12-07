package junit;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import mainGame.MissionControl;
import mainGame.Player;
import mainGame.Problem;
import mainGame.Space;
import mainGame.StatusPanel;

public class MovementTest {
	private Player p;
	private Space s;
	private MissionControl mc = new MissionControl();
	private Problem problem = new Problem("divide", 1, 1);
	private StatusPanel status;
	
	@Before
	public void init() throws IOException
	{
		status = new StatusPanel();
		p = new Player();
		s = new Space(mc, problem, status);
	}
	
	@Test	
	public void stopMovingAtEnd()
	{
		// Make sure you stop at the end, no wrap around
		// Also checks that we won't go out of bounds
		
		// Move way too far and make sure we stay at last moveable space
		for(int i = 0; i < 1000; i++)
		{
			p.move('R', s); //assume moving right, not implemented yet
		}
		assertEquals(p.getCol()+1, s.getCols());
		
		// Move way too far other way and make sure we stay at last moveable space on that side
		for(int i = 0; i < 1000; i++)
		{
			p.move('L', s); //assume moving left, not implemented yet
		}
		assertEquals(p.getCol(), 0);
	}
	
	@Test	
	public void moveCorrectDirection()
	{
		// Direction of movement matches key pressed
		// Also checks that one call to move only moves us one space
		
		int temp = p.getCol();
		p.move('R', s); //assume we move right
		assertEquals(p.getCol(), temp + 1);
		p.move('R', s); //assume we move right
		assertEquals(p.getCol(), temp + 2);
		p.move('L', s); //assume we move left
		assertEquals(p.getCol(), temp + 1);
		p.move('L', s); //assume we move left
		assertEquals(p.getCol(), temp);
	}
}
