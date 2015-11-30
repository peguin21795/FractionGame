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
	private int solution;
	
	public Problem(int numerator, int denominator, int generateDenominatorOfSolution){
		this.numerator = numerator;
		this.denominator = denominator;
		this.generateDenominatorOfSolution = generateDenominatorOfSolution;
		this.solution = generateDenominatorOfSolution*numerator/denominator;
	}
	
	public int getSolution()
	{
		return solution;
	}

	public Boolean checkAnswer(int selectedAnswer)
	{
		if (selectedAnswer == solution)
		{
			return true;
		}
		return false;
	}
}
