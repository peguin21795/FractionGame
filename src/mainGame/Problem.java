package mainGame;

import java.awt.GridLayout;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Problem extends JPanel{
	
	/* The second term will be used if necessary for certain problems.*/
	private Term first, second, solution;
	private String operation;
	private int level;
	
	/* A string will be passed into the constructor to determine the type of 
	 * problem that needs to be generated. An integer will also be passed to set 
	 * the appropriate level. */
	
	public Problem(String operation, int level)
	{
//		displayProblem();
		this.operation = operation;
		this.level = level;
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
	
	public String getOperation()
	{
		return operation;
	}
	
	public int getLevel()
	{
		return level;
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

	private void callDivide(int level)
	{
		if(level == 1)
		{
			Random rn = new Random(System.nanoTime());
			int one = (rn.nextInt(10)+1);
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
	//this level is simple addition of fractions with common denominator, and the answer is left as an improper fraction.
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
		else if(level == 2)//This level is proper fractions with common denominators, BUT improper fractions must be factored.
		{
			Random rn = new Random();
			int one = (rn.nextInt(10)+1);
			int two = (rn.nextInt(10)+1);
			int three = (rn.nextInt(10)+1);
			int four = 0;
			this.first = new Term(two, one);
			this.second = new Term(three, one);
			if((two+three)< one){
				this.solution = new Term((two+three),one);
			}
			else{
				for(int i=1; i<11;++i){
					if((two+three) > (one*i) && (two+three) < (one*(i+1)))
					{
						four = (two + three) - (one*i);
						this.solution = new Term(four, one, i,0);
					}
				}
			}
		}
		else if(level == 3)
		{
			Random rn = new Random();
			int one = (rn.nextInt(20)+1);
			int two = (rn.nextInt(20)+1);
			int three = (rn.nextInt(10)+1);
			int four = rn.nextInt(5)+2;
			if((two+three)< one){
				this.solution = new Term((two+three), one);
			}
			else{
				for(int i=0; i<11; ++i){
					if((two+three)> (one*i) && (two+three) < (one*(i+1)))
						this.solution = new Term(((two+three)-one), one, 1,0);
				}
			}
			int five = four*2;
			this.first = new Term((two*four), (one*four));
			this.second = new Term((three*five), (one*five));
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
	
	public Problem(int one, int two, int three)
	{
		first = new Term(one);
		second = new Term(two);
		solution = new Term(three);
	}
}
