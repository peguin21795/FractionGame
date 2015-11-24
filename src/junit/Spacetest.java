package junit;

import static org.junit.Assert.*;
import java.util.ArrayList;

import org.junit.Test;

import mainGame.SpaceTarget;

public class Spacetest {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	/* ABOUT: For generateTarget(), we will need to create a problem and then verify that the target contains the 
	 * correct answer to the problem. A collection of targets will be stored in an ArrayList<Target>. All the other 
	 * targets except for one will have the wrong answer. 
	 * */
	@Test
	public void testGenerateTargets()
	{
		ArrayList<SpaceTarget> listOfTargets = new ArrayList<SpaceTarget>();
		/*The targets generated is dependent on a problem that will be instantiated here*/
		//Problem sampleProblem = new Problem();
		
	}
}
