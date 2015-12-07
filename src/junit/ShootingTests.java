package junit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import mainGame.Player;
import mainGame.Problem;
import mainGame.Space;
import mainGame.Laser;
import mainGame.MissionControl;
import mainGame.SpaceTarget;
import mainGame.StatusPanel;

public class ShootingTests {

	private SpaceTarget target;
	private Space space;
	private Player player;
	private Laser laser;
	private MissionControl mc;
	private StatusPanel sp;
	private Problem p;
	
	@Before
	public void setUp()
	{
		p = new Problem("add", 1, 0);
		mc = new MissionControl();
		sp = new StatusPanel();
		player = new Player();
		target = new SpaceTarget();
		space = new Space(mc, p, sp);
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
		laser = new Laser(player, space);
		assertEquals(9, laser.getRow());
		assertEquals(5, laser.getCol());
		
		//Test that the distance to target is correct
		//Distance to target is relative to laser, not player
		target.setCol(5);
		target.setRow(3);
		assertEquals(6, player.getDistanceToTarget(target));
		
		target.setRow(1);
		assertEquals(8, player.getDistanceToTarget(target));
		
		//Test that the laser stops when it hits the target
		target.setRow(3);
		assertEquals(6, player.getDistanceToTarget(target));
		
		target.setRow(2);
		assertEquals(7, player.getDistanceToTarget(target));
		
		//Test that the laser doesn't go out of bounds when player misses the target
		player.setCol(8);
		player.setRow(4);
		assertEquals(4, player.getDistanceToTarget(target));
		
		player.setCol(13);
		player.setRow(9);
		assertEquals(9, player.getDistanceToTarget(target));
		
	}

}
