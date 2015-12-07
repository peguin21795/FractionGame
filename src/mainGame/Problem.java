package mainGame;

import java.awt.GridLayout;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

//This class generates problems or reads in a problem set from a file. the problems are made
//up of terms (see Term class) subtraction problems of all levels are read in from a file.
//there are four types of problems (division, factorization, addition, subtraction).  In
//addition, each type of problem has three difficulty levels.
public class Problem extends JPanel{
	
	/* The second term will be used if necessary for certain problems.*/
	private Term first, second, solution;
	private String operation;
	private int level;
	private ArrayList<Problem> subLevel1 = new ArrayList<Problem>();
	private ArrayList<Problem> subLevel2 = new ArrayList<Problem>();
	private ArrayList<Problem> subLevel3 = new ArrayList<Problem>();
	private int statusLevel;
	
	/* This boolean flag is set to true if the problem involves two parts. */
	private Boolean twoPartProblem = false;
	
	/* A string will be passed into the constructor to determine the type of 
	 * problem that needs to be generated. An integer will also be passed to set 
	 * the appropriate level. */
	
	public Problem(String operation, int level, int s)
	{
		statusLevel = s;
		this.operation = operation;
		this.level = level;
		if ((operation == "divide" && level == 3) || (operation == "factor" && (level == 2 || level == 3))
			|| (operation == "add" && (level == 2 || level == 3)) || (operation == "subtract" && (level == 2 || level == 3)))
		{
			this.twoPartProblem = true;
		}
		if(operation == "divide")
			callDivide(level);
		if(operation == "factor")
			callFactor(level);
		if(operation == "add")
			callAddition(level);
		if(operation == "subtract")
			callSubtract(level);
	}
	
	public int getStatusLevel() {
		return statusLevel;
	}

	//this second constructor is for the subtraction function to use because this method is
	//not generating problems, it is reading the problems in from a txt file.
	public Problem(Term one, Term two, Term solution){
		this.first = one;
		this.second = two;
		this.solution = solution;
	}
	
	public Boolean getTwoPartProblem()
	{
		return twoPartProblem;
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

	//this is called by the constructor to generate problem sets of the division type of all
	//levels 1 thru 3.
	private void callDivide(int level)
	{
		if(level == 1)
		{
			Random rn = new Random(System.nanoTime());
			int one = (rn.nextInt(10)+1);
			int two = (rn.nextInt(10)+1);
			int three = one * two;
			this.first = new Term(three,two);
			this.second =  new Term(0,0,0,0);;
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
			this.second = new Term(0,0,0,0);
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
			this.second = new Term(0,0,0,0);
		}
		else{
			System.err.println("INVALID LEVEL!!");
		}
	}
	
	//This is the function called by the constructor to generate problems set of the type factorization
	//of all levels.
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
			this.second =  new Term(0,0,0,0);;
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
			this.second =  new Term(0,0,0,0);;
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
			this.second =  new Term(0,0,0,0);;
			this.solution = new Term(one,two,three,0);
		}
		else{
			System.err.println("INVALID LEVEL!!");
		}
	}
	//The first level is simple addition of fractions with common denominator, 
	//and the answer is left as an improper fraction.
	private void callAddition(int level)
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
			int one = (rn.nextInt(10)+2);
			int two = (rn.nextInt(10)+1);
			int three = (rn.nextInt(10)+1);
			int four = 0;
			this.first = new Term(two, one);
			this.second = new Term(three, one);
			if((two+three)< one)
			{
				this.solution = new Term((two+three),one);
			}
			else
			{
				for(int i=1; i<100;++i)
				{
					if((two+three) >= (one*i) && (two+three) < (one*(i+1)))
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
			int one = (rn.nextInt(20)+2);
			int two = (rn.nextInt(20)+1);
			int three = (rn.nextInt(10)+1);
			int four = rn.nextInt(5)+1;
			if((two+three)< one)
			{
				this.solution = new Term((two+three), one);
			}
			else
			{
				for(int i=0; i<1000; ++i)
				{
					if((two+three) >= (one*i) && (two+three) < (one*(i+1)))
					{
						this.solution = new Term(((two+three)-one), one, 1,0);
					}	
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
	
	@Override
	public String toString() {
		return "Problem [first=" + first + ", second=" + second + ", solution=" + solution + ", operation=" + operation
				+ ", level=" + level + ", subLevel1=" + subLevel1 + ", subLevel2=" + subLevel2 + ", subLevel3="
				+ subLevel3 + ", statusLevel=" + statusLevel + ", twoPartProblem=" + twoPartProblem + "]";
	}

	//this function is called by the constructor to provide a problem set of the subtraction
	//type.  this function does NOT generate the problems, it will read them in from a text file.
	private void callSubtract(int level) 
	{
		try {
			loadSubtractionFile();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(level == 1){
			Random rn = new Random();
			int j = rn.nextInt(subLevel1.size());
			this.first = subLevel1.get(j).getFirst();
			this.second = subLevel1.get(j).getSecond();
			this.solution = subLevel1.get(j).getSolution();
		}
		else if(level == 2){
			Random rn = new Random();
			int j = rn.nextInt(subLevel2.size());
			this.first = subLevel2.get(j).getFirst();
			this.second = subLevel2.get(j).getSecond();
			this.solution = subLevel2.get(j).getSolution();
		}
		else{
			Random rn = new Random();
			int j = rn.nextInt(subLevel3.size());
			this.first = subLevel3.get(j).getFirst();
			this.second = subLevel3.get(j).getSecond();
			this.solution = subLevel3.get(j).getSolution();
		}
	}
	
	//This is called by the subtraction problem set generator function to read in the info
	//from a text file that will supply the equations needed.
	private void loadSubtractionFile() throws FileNotFoundException{
		FileReader reader = new FileReader("subtraction_problems.txt");
		ArrayList<Problem> temp = new ArrayList<Problem>();
		Scanner in = new Scanner(reader);
		while(in.hasNextLine()){
				String[] termsRead = in.nextLine().split(",");
				ArrayList<Integer> terms = new ArrayList<Integer>();
				for (int i=0; i<termsRead.length;++i){
					terms.add(Integer.parseInt(termsRead[i]));
				}
				Term termFirst = new Term(terms.get(0), terms.get(1), terms.get(2));
				Term termSecond = new Term(terms.get(3), terms.get(4), terms.get(5));
				Term termSolution = new Term(terms.get(6), terms.get(7), terms.get(8));
				temp.add(new Problem(termFirst, termSecond, termSolution));
			}
		for(int i=0; i<temp.size();++i){
			if(i<10){
				subLevel1.add(temp.get(i));
			}
			else if(i>9 && i<20){
				subLevel2.add(temp.get(i));
			}
			else{
				subLevel3.add(temp.get(i));
			}
		}
	}
	
}
