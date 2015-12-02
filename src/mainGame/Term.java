package mainGame;

public class Term {
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
		numerator = 0;
		denominator = 0;
		decimal = 0;
		wholeNumber = whole;
	}
	public Term(int numer, int denom){
		numerator = numer;
		denominator = denom;
		wholeNumber = 0;
		decimal = 0;
	}

}
