package mainGame;

public class Term {
	/* Three different types of terms can be constructed depending on what type of problem will be generated.     
	 * A terms consists of two composing instance variables: denominator and numerator. As the problems progress
	 * in difficulty, two additional instance variables, wholeNumber and decimal, will be needed.
	 */
	private int denominator;
	private int numerator;
	private int wholeNumber;
	private float decimal;
	
	public Term(int numer, int denom, int whole, float dec){
		this.numerator = numer;
		this.denominator = denom;
		this.wholeNumber = whole;
		this.decimal = dec;
	}
	public Term(int whole){
		this.numerator = 0;
		this.denominator = 0;
		this.decimal = 0;
		this.wholeNumber = whole;
	}
	public Term(int numer, int denom){
		this.numerator = numer;
		this.denominator = denom;
		this.wholeNumber = 0;
		this.decimal = 0;
	}
	
	/*The getters and setters are for testing purposes only.*/
	public int getDenominator()
	{
		return denominator;
	}
	
	public int getNumerator()
	{
		return numerator;
	}
	
	public int getWholeNumber()
	{
		return wholeNumber;
	}
	
	public float getDecimal()
	{
		return decimal;
	}
}
