package junit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import mainGame.Player;
import mainGame.Laser;
import mainGame.SpaceTarget;

public class ShootingTests {

	private SpaceTarget target;
	private Player player;
	private Laser laser;
	
	@Before
	public void setUp()
	{
		player = new Player();
		target = new SpaceTarget();
	}

	//Test that shootTargets returns the proper value when a target is shot 
	@Test
	public void testHitandMiss() 
	{
		//Test some target hits
		player.setCol(5);
		target.setCol(5);
		assertTrue(player.hitTarget(target));
		
		player.setCol(3);
		target.setCol(3);
		assertTrue(player.hitTarget(target));
		
		player.setCol(11);
		target.setCol(11);
		assertTrue(player.hitTarget(target));
		
		//Test some target misses
		player.setCol(2);
		target.setCol(10);
		assertEquals(false, player.hitTarget(target));
		
		player.setCol(1);
		target.setCol(8);
		assertEquals(false, player.hitTarget(target));
		
		player.setCol(0);
		target.setCol(4);
		assertEquals(false, player.hitTarget(target));
		
	}
	
	//Tests that shoot updates the shot's position properly and that the laser doesn't go out of bounds
	@Test
	public void testShoot()
	{
		//Test that the laser appears in the correct spot
		player.setCol(5);
		player.setRow(10);
		laser = new Laser(player);
		assertEquals(9, laser.getRow());
		assertEquals(5, laser.getCol());
		
		//Test that the distance to target is correct
		//Distance to target is relative to laser, not player
		target.setCol(5);
		target.setRow(3);
		player.shoot(target);
		assertEquals(6, player.getDistanceToTarget());
		
		target.setRow(1);
		player.shoot(target);
		assertEquals(8, player.getDistanceToTarget());
		
		//Test that the laser stops when it hits the target
		target.setRow(3);
		player.shoot(target);
		assertEquals(3, player.getLaser().getRow());
		assertEquals(5, player.getLaser().getCol());
		
		target.setRow(2);
		player.shoot(target);
		assertEquals(2, player.getLaser().getRow());
		assertEquals(5, player.getLaser().getCol());
		
		//Test that the laser doesn't go out of bounds when player misses the target
		player.setCol(8);
		player.setRow(4);
		player.shoot(target);
		assertEquals(4, player.getDistanceToTarget());
		assertEquals(0, player.getLaser().getRow());
		assertEquals(8, player.getLaser().getCol());
		
		player.setCol(13);
		player.setRow(9);
		player.shoot(target);
		assertEquals(9, player.getDistanceToTarget());
		assertEquals(0, player.getLaser().getRow());
		assertEquals(13, player.getLaser().getCol());
		
	}

}
