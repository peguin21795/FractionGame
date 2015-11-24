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
	
	private int denominator;
	private int numerator;
	private int generateDenominatorOfSolution;
	
	public Problem(int denominator, int numerator, int generateDenominatorOfSolution){
		this.denominator = denominator;
		this.numerator = numerator;
		this.generateDenominatorOfSolution = generateDenominatorOfSolution;
	}

	public Boolean checkAnswer(int selectedAnswer)
	{
		return null; 
	}
}
