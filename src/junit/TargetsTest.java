package junit;


import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import mainGame.Problem;
import mainGame.SpaceTarget;

public class TargetsTest {
	/*ABOUT: TargetsTest.java will test if the problem was successfully generated as well as if an ArrayList of targets contains 
	 *the correct solution to the problem. */
	ArrayList<SpaceTarget> listOfTargets;
	Problem sampleProblemAddition;
	Problem sampleProblemSubtract;
	Problem sampleProblemFactoring;
	Problem sampleProblemDivision;
	
	@Before
	public void setup()
	{
		listOfTargets = new ArrayList<SpaceTarget>();
		/*We will create problems from each of the described concepts.*/
	/*	sampleProblemOneDigit = new Problem(3, 6, 4);
		sampleProblemTwoDigits = new Problem(4, 5, 15);
		sampleProblemWholeNumbers = new Problem(1, 1, 3);
		sampleProblemOneAndTwoDigits = new Problem(4, 6, 12);
		for (int i = 0; i < answers.length; i++)
		{
			SpaceTarget target = new SpaceTarget();
			listOfTargets.add(target);
			listOfTargets.get(i).setTargetNumber(answers[i]);
		}*/
	}
	
	@Test
	public void testGenerateAddition()
	{
		sampleProblemAddition = new Problem("add", 1);
		sampleProblemAddition = new Problem("add", 2);
		sampleProblemAddition = new Problem("add", 3);
		/*System.out.println(listOfTargets.get(0).getTargetNumber());
		Assert.assertEquals(true, sampleProblemOneDigit.checkAnswer(listOfTargets.get(0).getTargetNumber()));
		Assert.assertEquals(false, sampleProblemOneDigit.checkAnswer(listOfTargets.get(1).getTargetNumber()));
		Assert.assertEquals(false, sampleProblemOneDigit.checkAnswer(listOfTargets.get(2).getTargetNumber()));
		Assert.assertEquals(false, sampleProblemOneDigit.checkAnswer(listOfTargets.get(3).getTargetNumber()));*/
	}
	
	@Test
	public void testGenerateSubtract()
	{
		sampleProblemSubtract = new Problem("subtract", 1);
		sampleProblemSubtract = new Problem("subtract", 2);
		sampleProblemSubtract = new Problem("subtract", 3);
		/*Assert.assertEquals(false, sampleProblemTwoDigits.checkAnswer(listOfTargets.get(0).getTargetNumber()));
		Assert.assertEquals(true, sampleProblemTwoDigits.checkAnswer(listOfTargets.get(1).getTargetNumber()));
		Assert.assertEquals(false,sampleProblemTwoDigits.checkAnswer(listOfTargets.get(2).getTargetNumber()));
		Assert.assertEquals(false, sampleProblemTwoDigits.checkAnswer(listOfTargets.get(3).getTargetNumber()));*/
	}
	
	@Test
	public void testGenerateFactoring()
	{
		sampleProblemFactoring = new Problem("factor", 1);
		sampleProblemFactoring = new Problem("factor", 2);
		sampleProblemFactoring = new Problem("factor", 3);
		/*Assert.assertEquals(false, sampleProblemWholeNumbers.checkAnswer(listOfTargets.get(0).getTargetNumber()));
		Assert.assertEquals(false, sampleProblemWholeNumbers.checkAnswer(listOfTargets.get(1).getTargetNumber()));
		Assert.assertEquals(true, sampleProblemWholeNumbers.checkAnswer(listOfTargets.get(2).getTargetNumber()));
		Assert.assertEquals(false, sampleProblemWholeNumbers.checkAnswer(listOfTargets.get(3).getTargetNumber()));*/
	}

	@Test
	public void testGenerateDivision()
	{	
		sampleProblemDivision = new Problem("divide", 1);
		assertEquals(sampleProblemDivision.getFirst().getNumerator()/sampleProblemDivision.getFirst().getDenominator(),
				sampleProblemDivision.getSolution().getWholeNumber());
		assertEquals(null, sampleProblemDivision.getSecond());
		
		sampleProblemDivision = new Problem("divide", 2);
		System.out.println(sampleProblemDivision.getSolution().getDecimal());
		assertEquals((float)sampleProblemDivision.getFirst().getNumerator()/(float)sampleProblemDivision.getFirst().getDenominator(),
				sampleProblemDivision.getSolution().getDecimal(), 0.000001);
		assertEquals(null, sampleProblemDivision.getSecond());
		
		sampleProblemDivision = new Problem("divide", 3);
		assertEquals(sampleProblemDivision.getSolution().getDenominator(), sampleProblemDivision.getFirst().getDenominator());
		assertEquals(sampleProblemDivision.getSolution().getWholeNumber()*sampleProblemDivision.getSolution().getDenominator() + sampleProblemDivision.getSolution().getNumerator(),
				sampleProblemDivision.getFirst().getNumerator());
		assertEquals(null, sampleProblemDivision.getSecond());
	}

}
