package junit;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import mainGame.Problem;
import mainGame.SpaceTarget;

public class TargetsTest {
	/* ABOUT: For generateTarget(), we will need to create a problem and then verify that the target contains the 
	 * correct answer to the problem. A collection of targets will be stored in an ArrayList<SpaceTarget>. All the other 
	 * targets except for one will have the wrong answer. A variety of different fractions will be tested here.
	 * */
	
	/* Constants will be initialized here. */
	final int numOfTargets = 20;
	ArrayList<SpaceTarget> listOfTargets;
	Problem sampleProblemOneDigit;
	Problem sampleProblemWholeNumbers;
	Problem sampleProblemTwoDigits;
	Problem sampleProblemOneAndTwoDigits;
	
	@Before
	public void setup()
	{
		listOfTargets = new ArrayList<SpaceTarget>();
		/* The targets generated is dependent on a problem that will be instantiated here. The answer to sampleProblem
		 * is 4. */
		sampleProblemOneDigit = new Problem(3, 6, 4);
		sampleProblemTwoDigits = new Problem(4, 5, 15);
		sampleProblemWholeNumbers = new Problem(1, 1, 2);
		sampleProblemOneAndTwoDigits = new Problem(4, 6, 12);
		for (int i = 0; i < numOfTargets; i++)
		{
			SpaceTarget target = new SpaceTarget();
			listOfTargets.add(target);
			listOfTargets.get(i).setTargetNumber(i);
		}
		System.out.println(listOfTargets.size());
	}
	
	@Test
	public void testGenerateTargetsOneDigit()
	{
		for (int i = 0; i < numOfTargets; i++)
		{
			if (i == 2)
			{
				/* The fifth element of the ArrayList<SpaceTarget> must contain the right answer because 
				 * 2/4 is the same as 3/6.*/
				assertEquals(true, sampleProblemOneDigit.checkAnswer(listOfTargets.get(i).getTargetNumber()));
			}
			else
			{	/* The other elements of the ArrayList<SpaceTarget> should not contain the right answer! */
				assertEquals(false, sampleProblemOneDigit.checkAnswer(listOfTargets.get(i).getTargetNumber()));
			}
		}
	}
	
	@Test
	public void testGenerateTargetsTwoDigit()
	{
		for (int i = 0; i < numOfTargets; i++)
		{
			if (i == 12)
			{
				/* The fifth element of the ArrayList<SpaceTarget> must contain the right answer because 
				 * 12/15 is the same as 4/5.*/
				assertEquals(true, sampleProblemOneDigit.checkAnswer(listOfTargets.get(i).getTargetNumber()));
			}
			else
			{	/* The other elements of the ArrayList<SpaceTarget> should not contain the right answer! */
				assertEquals(false, sampleProblemOneDigit.checkAnswer(listOfTargets.get(i).getTargetNumber()));
			}
		}
	}
	
	@Test
	public void testGenerateTargetsWholeNumber()
	{
		for (int i = 0; i < numOfTargets; i++)
		{
			if (i == 2)
			{
				/* The fifth element of the ArrayList<SpaceTarget> must contain the right answer because 
				 * 2/2 is the same as 1/1.*/
				assertEquals(true, sampleProblemOneDigit.checkAnswer(listOfTargets.get(i).getTargetNumber()));
			}
			else
			{	/* The other elements of the ArrayList<SpaceTarget> should not contain the right answer! */
				assertEquals(false, sampleProblemOneDigit.checkAnswer(listOfTargets.get(i).getTargetNumber()));
			}
		}
	}

	@Test
	public void testGenerateTargetsOneAndTwoDigits()
	{
		for (int i = 0; i < numOfTargets; i++)
		{
			if (i == 8)
			{
				/* The fifth element of the ArrayList<SpaceTarget> must contain the right answer because 
				 * 8/12 is the same as 4/6.*/
				assertEquals(true, sampleProblemOneDigit.checkAnswer(listOfTargets.get(i).getTargetNumber()));
			}
			else
			{	/* The other elements of the ArrayList<SpaceTarget> should not contain the right answer! */
				assertEquals(false, sampleProblemOneDigit.checkAnswer(listOfTargets.get(i).getTargetNumber()));
			}
		}
	}

}
