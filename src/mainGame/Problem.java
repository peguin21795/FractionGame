package mainGame;

public class Problem {
	
	/* The Problem class will consist of three components. The numerator and denominator variables for a fraction 
	 * will be displayed on the main game board instantiated by the MissionControl class. The fraction will be
	 * set equal to a partially filled out fraction where the user must select the correct answer to complete 
	 * the problem.
	 * 
	 * Example:
	 * 
	 *  numerator     [BLANK ANSWER]
	 * ----------- = ---------------- 
	 * denominator   generateDenomin.
	 * 
	 * */
	
	private int numerator;
	private int denominator;
	private int generateDenominatorOfSolution;
	
	public Problem(int numerator, int denominator, int generateDenominatorOfSolution){
		this.numerator = numerator;
		this.denominator = denominator;
		this.generateDenominatorOfSolution = generateDenominatorOfSolution;
	}

	public Boolean checkAnswer(int selectedAnswer)
	{
		double tolerance = 0.0000000001;
		double givenAnswer = (double)numerator/denominator;
		double chosenAnswer = (double)selectedAnswer/generateDenominatorOfSolution;
		if (Math.abs(chosenAnswer - givenAnswer) <= tolerance)
		{
			return true;
		}
		return false;
	}
}
