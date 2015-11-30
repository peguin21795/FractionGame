package junit;


import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import mainGame.Problem;
import mainGame.SpaceTarget;

public class TargetsTest {
	/* ABOUT: For generateTarget(), we will need to create a problem and then verify that the target contains the 
	 * correct answer to the problem. A collection of targets will be stored in an ArrayList<SpaceTarget>. All the other 
	 * targets except for one will have the wrong answer. A variety of different fractions will be tested here.
	 * */
	
	/* The answers to each problem are 2, 12, 3, 8.*/
	
	/* Constants will be initialized here. */
	ArrayList<SpaceTarget> listOfTargets;
	int[] answers = {2, 12, 3, 8};
	Problem sampleProblemOneDigit;
	Problem sampleProblemWholeNumbers;
	Problem sampleProblemTwoDigits;
	Problem sampleProblemOneAndTwoDigits;
	
	@Before
	public void setup()
	{
		listOfTargets = new ArrayList<SpaceTarget>();
		sampleProblemOneDigit = new Problem(3, 6, 4);
		sampleProblemTwoDigits = new Problem(4, 5, 15);
		sampleProblemWholeNumbers = new Problem(1, 1, 3);
		sampleProblemOneAndTwoDigits = new Problem(4, 6, 12);
		for (int i = 0; i < answers.length; i++)
		{
			SpaceTarget target = new SpaceTarget();
			listOfTargets.add(target);
			listOfTargets.get(i).setTargetNumber(answers[i]);
		}
	}
	
	@Test
	public void testGenerateTargetsOneDigit()
	{
		System.out.println(listOfTargets.get(0).getTargetNumber());
		Assert.assertEquals(true, sampleProblemOneDigit.checkAnswer(listOfTargets.get(0).getTargetNumber()));
		Assert.assertEquals(false, sampleProblemOneDigit.checkAnswer(listOfTargets.get(1).getTargetNumber()));
		Assert.assertEquals(false, sampleProblemOneDigit.checkAnswer(listOfTargets.get(2).getTargetNumber()));
		Assert.assertEquals(false, sampleProblemOneDigit.checkAnswer(listOfTargets.get(3).getTargetNumber()));
	}
	
	@Test
	public void testGenerateTargetsTwoDigit()
	{
		Assert.assertEquals(false, sampleProblemTwoDigits.checkAnswer(listOfTargets.get(0).getTargetNumber()));
		Assert.assertEquals(true, sampleProblemTwoDigits.checkAnswer(listOfTargets.get(1).getTargetNumber()));
		Assert.assertEquals(false,sampleProblemTwoDigits.checkAnswer(listOfTargets.get(2).getTargetNumber()));
		Assert.assertEquals(false, sampleProblemTwoDigits.checkAnswer(listOfTargets.get(3).getTargetNumber()));
	}
	
	@Test
	public void testGenerateTargetsWholeNumber()
	{
		Assert.assertEquals(false, sampleProblemWholeNumbers.checkAnswer(listOfTargets.get(0).getTargetNumber()));
		Assert.assertEquals(false, sampleProblemWholeNumbers.checkAnswer(listOfTargets.get(1).getTargetNumber()));
		Assert.assertEquals(true, sampleProblemWholeNumbers.checkAnswer(listOfTargets.get(2).getTargetNumber()));
		Assert.assertEquals(false, sampleProblemWholeNumbers.checkAnswer(listOfTargets.get(3).getTargetNumber()));
	}

	@Test
	public void testGenerateTargetsOneAndTwoDigits()
	{	
		Assert.assertEquals(false, sampleProblemOneAndTwoDigits.checkAnswer(listOfTargets.get(0).getTargetNumber()));
		Assert.assertEquals(false, sampleProblemOneAndTwoDigits.checkAnswer(listOfTargets.get(1).getTargetNumber()));
		Assert.assertEquals(false, sampleProblemOneAndTwoDigits.checkAnswer(listOfTargets.get(2).getTargetNumber()));
		Assert.assertEquals(true, sampleProblemOneAndTwoDigits.checkAnswer(listOfTargets.get(3).getTargetNumber()));
	}

}
