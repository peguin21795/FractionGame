package junit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import mainGame.Player;
import mainGame.Space;

public class MovementTest {
	private Player p;
	
	@Before
	public void init()
	{
		p = new Player();
	}
	
	@Test	
	public void stopMovingAtEnd()
	{
		// Make sure you stop at the end, no wrap around
		// Also checks that we won't go out of bounds
		
		// Move way too far and make sure we stay at last moveable space
		for(int i = 0; i < 30; i++)
		{
			p.move(); //assume moving right, not implemented yet
		}
		assertEquals(p.getCol(), Space.getWidth());
		
		// Move way too far other way and make sure we stay at last moveable space on that side
		for(int i = 0; i < 30; i++)
		{
			p.move(); //assume moving left, not implemented yet
		}
		assertEquals(p.getCol(), 0);
	}
	
	@Test	
	public void moveCorrectDirection()
	{
		// Direction of movement matches key pressed
		// Also checks that one call to move only moves us one space
		
		int temp = p.getCol();
		p.move(); //assume we move right
		assertEquals(p.getCol(), temp + 1);
		p.move(); //assume we move right
		assertEquals(p.getCol(), temp + 2);
		p.move(); //assume we move left
		assertEquals(p.getCol(), temp + 1);
		p.move(); //assume we move left
		assertEquals(p.getCol(), temp);
	}
}
