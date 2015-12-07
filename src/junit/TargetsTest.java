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
		sampleProblemAddition = new Problem("add", 1, 1);
		assertEquals(sampleProblemAddition.getSolution().getNumerator(), sampleProblemAddition.getFirst().getNumerator() + sampleProblemAddition.getSecond().getNumerator());
		assertEquals(sampleProblemAddition.getSolution().getDenominator(), sampleProblemAddition.getFirst().getDenominator());
		assertEquals(sampleProblemAddition.getSolution().getDenominator(), sampleProblemAddition.getSecond().getDenominator());
		assertEquals(sampleProblemAddition.getSolution().getDenominator(), sampleProblemAddition.getFirst().getDenominator());
		
		sampleProblemAddition = new Problem("add", 2, 1);
		int solution_numerator = sampleProblemAddition.getSolution().getNumerator() + sampleProblemAddition.getSolution().getDenominator() * sampleProblemAddition.getSolution().getWholeNumber(); 
		assertEquals(solution_numerator, sampleProblemAddition.getFirst().getNumerator() + sampleProblemAddition.getSecond().getNumerator());
		assertEquals(sampleProblemAddition.getSolution().getDenominator(), sampleProblemAddition.getFirst().getDenominator());
		assertEquals(sampleProblemAddition.getSolution().getDenominator(), sampleProblemAddition.getSecond().getDenominator());
		assertEquals(sampleProblemAddition.getSolution().getDenominator(), sampleProblemAddition.getFirst().getDenominator());
		
		sampleProblemAddition = new Problem("add", 3, 1);
		solution_numerator = sampleProblemAddition.getSolution().getNumerator() + sampleProblemAddition.getSolution().getDenominator() * sampleProblemAddition.getSolution().getWholeNumber(); 
		float solution = (float)solution_numerator/(float)sampleProblemAddition.getSolution().getDenominator();
		float term1 = (float)sampleProblemAddition.getFirst().getNumerator()/(float)sampleProblemAddition.getFirst().getDenominator();
		float term2 = (float)sampleProblemAddition.getSecond().getNumerator()/(float)sampleProblemAddition.getSecond().getDenominator();
		assertEquals(solution, term1 + term2, 0.000001);
	}
	
	@Test
	public void testGenerateSubtract()
	{
		sampleProblemSubtract = new Problem("subtract", 1, 1);
		sampleProblemSubtract = new Problem("subtract", 2, 1);
		sampleProblemSubtract = new Problem("subtract", 3, 1);
		/*Assert.assertEquals(false, sampleProblemTwoDigits.checkAnswer(listOfTargets.get(0).getTargetNumber()));
		Assert.assertEquals(true, sampleProblemTwoDigits.checkAnswer(listOfTargets.get(1).getTargetNumber()));
		Assert.assertEquals(false,sampleProblemTwoDigits.checkAnswer(listOfTargets.get(2).getTargetNumber()));
		Assert.assertEquals(false, sampleProblemTwoDigits.checkAnswer(listOfTargets.get(3).getTargetNumber()));*/
	}
	
	@Test
	public void testGenerateFactoring()
	{
		sampleProblemFactoring = new Problem("factor", 1, 1);
		float solution = (float)sampleProblemFactoring.getSolution().getNumerator()/(float)sampleProblemFactoring.getSolution().getDenominator();
		float first = (float)sampleProblemFactoring.getFirst().getNumerator()/(float)sampleProblemFactoring.getFirst().getDenominator();
		assertEquals(solution, first, 0.000001);
		assertEquals(null, sampleProblemFactoring.getSecond());
		
		sampleProblemFactoring = new Problem("factor", 2, 1);
		float solution_numerator = (float)sampleProblemFactoring.getSolution().getWholeNumber()*(float)sampleProblemFactoring.getSolution().getDenominator()+(float)sampleProblemFactoring.getSolution().getNumerator();
		solution = solution_numerator / (float)sampleProblemFactoring.getSolution().getDenominator();
		first = (float)sampleProblemFactoring.getFirst().getNumerator()/(float)sampleProblemFactoring.getFirst().getDenominator();
		assertEquals(solution, first, 0.000001);
		
		sampleProblemFactoring = new Problem("factor", 3, 1);
		solution_numerator = (float)sampleProblemFactoring.getSolution().getWholeNumber()*(float)sampleProblemFactoring.getSolution().getDenominator()+(float)sampleProblemFactoring.getSolution().getNumerator();
		solution = solution_numerator / (float)sampleProblemFactoring.getSolution().getDenominator();
		first = (float)sampleProblemFactoring.getFirst().getNumerator()/(float)sampleProblemFactoring.getFirst().getDenominator();
		assertEquals(solution, first, 0.000001);
	}

	@Test
	public void testGenerateDivision()
	{	
		sampleProblemDivision = new Problem("divide", 1, 1);
		assertEquals(sampleProblemDivision.getFirst().getNumerator()/sampleProblemDivision.getFirst().getDenominator(),
				sampleProblemDivision.getSolution().getWholeNumber());
		assertEquals(null, sampleProblemDivision.getSecond());
		
		sampleProblemDivision = new Problem("divide", 2, 1);
		assertEquals((float)sampleProblemDivision.getFirst().getNumerator()/(float)sampleProblemDivision.getFirst().getDenominator(),
				sampleProblemDivision.getSolution().getDecimal(), 0.000001);
		assertEquals(null, sampleProblemDivision.getSecond());
		
		sampleProblemDivision = new Problem("divide", 3, 1);
		assertEquals(sampleProblemDivision.getSolution().getDenominator(), sampleProblemDivision.getFirst().getDenominator());
		assertEquals(sampleProblemDivision.getSolution().getWholeNumber()*sampleProblemDivision.getSolution().getDenominator() + sampleProblemDivision.getSolution().getNumerator(),
				sampleProblemDivision.getFirst().getNumerator());
		assertEquals(null, sampleProblemDivision.getSecond());
	}

}
