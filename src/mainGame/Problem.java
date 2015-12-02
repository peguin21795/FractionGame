package mainGame;

import java.util.Random;

public class Problem {
	
	/* The second term will be used if necessary for certain problems.*/
	private Term first, second, solution;
	private int remainder;
	
	/* A string will be passed into the constructor to determine the type of 
	 * problem that needs to be generated. An integer will also be passed to set 
	 * the appropriate level. */
	public Problem(String operation, int level)
	{
		if(operation == "divide")
			callDivide(level);
		if(operation == "factor")
			callFactor(level);
		if(operation == "add")
			callAddition(level);
		if(operation == "subtract")
			callSubtract(level);
		else
			callHardest(level);
	}
	
	public Problem(int one, int two, int three)
	{
		first = new Term(one);
		second = new Term(two);
		solution = new Term(three);
	}

	private void callDivide(int level)
	{
		if(level == 1)
		{
			Random rn = new Random(System.nanoTime());
			int one = (rn.nextInt(100)+1)/10;
			int two = (rn.nextInt(100)+1)/10;
			int three = one * two;
			this.first = new Term(three,two);
			this.second = null;
			this.solution = new Term(one);
		}
		else if (level == 2)
		{
			Random rn = new Random(System.nanoTime());
			int two = rn.nextInt(10) + 1;
			if (two == 3 || two == 5 || two == 7 || two == 9)
				two = two-1;
			int one = 1;
			this.first = new Term(one,two);
			this.second = null;
			this.solution = new Term(0, 0, 0, (one/two));
		}
		else
		{
			
		}
	}
	private void callFactor(int level)
	{
		if (level == 1)
		{
			Random rn = new Random();
			int one = rn.nextInt(10)+1;
			int two = rn.nextInt(10)+1;
			int three = rn.nextInt(10)+1;
			int four = one*three;
			int five = two*three;
			this.first = new Term(four, five);
			this.second = null;
			this.solution = new Term(one, two);
		}
		else
		{
			
		}
	}
	private void callAddition(int level)
	{
		
	}
	private void callSubtract(int level)
	{
		
	}
	private void callHardest(int level){
		
	}
	
	public Boolean checkAnswer(int selectedAnswer)
	{
		return null; 
	}
}
