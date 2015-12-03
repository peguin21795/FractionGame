package mainGame;

import java.util.Random;

public class Problem {
	
	/* The second term will be used if necessary for certain problems.*/
	private Term first, second, solution;
	//private int remainder;
	
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
	
	public Term getFirst() {
		return first;
	}

	public Term getSecond() {
		return second;
	}

	public Term getSolution() {
		return solution;
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
			int two = (rn.nextInt(10)+1);
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
			float dec = (float)one/two;
			this.solution = new Term(0, 0, 0, dec);
		}
		else if (level == 3)
		{
			Random rn = new Random(System.nanoTime());
			int one = (rn.nextInt(100)+1)/10;
			int two = (rn.nextInt(20)+1);
			int three = (rn.nextInt(100)+1)/10;
			int four = two*three;
			this.solution = new Term(one, two, three,0);
			this.first = new Term((four+one), two);
			this.second = null;
		}
		else{
			System.err.println("INVALID LEVEL!!");
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
			if(one==2 || one == 4 || one==6 || one==8 || one==10)
				one =  one-1;
			int four = one*three;
			if(two==2 || two==4 || two==6 || two==8 || two==10)
				two = two-1;
			int five = two*three;
			this.first = new Term(four, five);
			this.second = null;
			this.solution = new Term(one, two);
		}
		else if(level == 2)
		{
			Random rn = new Random();
			int one = (rn.nextInt(100)+1)/10;
			int two = (rn.nextInt(20)+1);
			if(two<10 && two > 5)
				two = two+5;
			else if(two <5)
				two = two + 7;
			int three = (rn.nextInt(10)+1);
			this.first = new Term(((three*two) + one), two);
			this.second = null;
			this.solution = new Term(one,two,three,0);
		}
		else if(level == 3)
		{
			Random rn = new Random();
			int one = (rn.nextInt(20)+1);
			int two = (rn.nextInt(30)+1);
			int three = (rn.nextInt(10)+1);
			//this.first = new Term((three*one),(three*two));
			this.first = new Term(((three*two) + one), two);
			this.second = null;
			this.solution = new Term(one,two,three,0);
		}
		else{
			System.err.println("INVALID LEVEL!!");
		}
	}
	
	private void callAddition(int level)
	//this level is simple addition of fractions with common denomonator, and the answer is left as an improper fraction.
	{
		if(level == 1)
		{
			Random rn = new Random();
			int one = (rn.nextInt(10)+1);
			int two = (rn.nextInt(10)+1);
			int three = (rn.nextInt(10)+1);
			this.first = new Term(two, one);
			this.second = new Term(three, one);
			this.solution = new Term((two+three),one);
		}
		else if(level == 2)
		{
			Random rn = new Random();
			int one = (rn.nextInt(10)+1);
			int two = (rn.nextInt(10)+1);
			int three = (rn.nextInt(10)+1);
			int four = 0;
			this.first = new Term(two, one);
			this.second = new Term(three, one);
			if((two+three) > one && (two+three) < (one*2))
			{
				four = (two + three) - one;
				this.solution = new Term(four, one, 1,0);
			}
			else if((two+three) > (one*2) && (two+three) < (one*3))
			{
				four = (two + three) - (one*2);
				this.solution = new Term(four, one, 2,0);
			}
			else if((two+three) > (one*3) && (two+three) < (one*4))
			{
				four = (two + three) - (one*3);
				this.solution = new Term(four, one, 3,0);
			}
			else if((two+three) > (one*4) && (two+three) < (one*5))
			{
				four = (two + three) - (one*4);
				this.solution = new Term(four, one, 4,0);
			}
			else if((two+three) > (one*5) && (two+three) < (one*6))
			{
				four = (two + three) - (one*5);
				this.solution = new Term(four, one, 5,0);
			}
			else if((two+three) > (one*6) && (two+three) < (one*7))
			{
				four = (two + three) - (one*6);
				this.solution = new Term(four, one, 6,0);
			}
			else if((two+three) > (one*7) && (two+three) < (one*8))
			{
				four = (two + three) - (one*7);
				this.solution = new Term(four, one, 7,0);
			}
			else if((two+three) > (one*8) && (two+three) < (one*9))
			{
				four = (two + three) - (one*8);
				this.solution = new Term(four, one, 8,0);
			}
			else if((two+three) > (one*9) && (two+three) < (one*10))
			{
				four = (two + three) - (one*9);
				this.solution = new Term(four, one, 9,0);
			}
			else if((two+three) > (one*10) && (two+three) < (one*11))
			{
				four = (two + three) - (one*10);
				this.solution = new Term(four, one, 10,0);
			}
			else{
				this.solution = new Term((two+three),one);
			}
		}
		else if(level == 3)
		{
			Random rn = new Random();
			int one = (rn.nextInt(10)+1);
			int two = (rn.nextInt(10)+1);
			int three = (rn.nextInt(10)+1);
			int four = rn.nextInt(5)+1;
			if((two+three)> one && (two+three) < (one*2))
				this.solution = new Term(((two+three)-one), one, 1,0);
			if((two+three) > (one*2) && (two+three) < (one*3))
				this.solution = new Term(((two+three)-(one*2)),one, 2,0);
			else
				this.solution = new Term((two+three), one);
			int five = four*2;
			this.first = new Term((two*four), (one*four));
			this.second = new Term((two*five), (one*five));
		}
		else{
			System.err.println("INVALID LEVEL!!");
		}
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
