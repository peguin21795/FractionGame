package mainGame;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class MissionControl extends JPanel{
	private JLabel wholeNumber,numerator,denominator;
	private boolean showCorrectWholeFlag = false;
	private boolean showCorrectNumFlag = false;
	private ArrayList<Integer> usedCols;
	private JPanel firstPanel, secondPanel, solutionPanel, operatorPanel, equalsPanel;

	public MissionControl()
	{
		//	prob = ;
	}
	public MissionControl(Problem prob){
		firstPanel = new JPanel();
		secondPanel = new JPanel();
		solutionPanel = new JPanel();
		operatorPanel = new JPanel();

		if (prob.getSecond().getDenominator() == 0)
		{
			try
			{
				firstPanel = createFirstTermPanel(prob);
				add(firstPanel);
				operatorPanel = createEqualsSign();
				add(operatorPanel);
				solutionPanel = createSolutionTermPanel(prob);
				add(solutionPanel);
			}
			catch (IOException ex)
			{
				System.out.println(ex.toString());
			}
			finally
			{
				setVisible(true);
			}
		}
		else
		{
			if (prob.getOperation() == "subtract")
			{
				try
				{
					firstPanel = createFirstTermPanel(prob);
					add(firstPanel);
					operatorPanel = createSubtractionSign();
					add(operatorPanel);
					secondPanel = createSecondTermPanel(prob);
					add(secondPanel);
					equalsPanel = createEqualsSign();
					solutionPanel = createSolutionTermPanel(prob);
					add(solutionPanel);
				}
				catch (IOException ex)
				{
					System.out.println(ex.toString());
				}
				finally
				{
					setVisible(true);
				}
			}
			else
			{
				try
				{
					firstPanel =createFirstTermPanel(prob);
					add(firstPanel);
					operatorPanel = createAdditionSign();
					add(operatorPanel);
					secondPanel = createSecondTermPanel(prob);
					add(secondPanel);
					equalsPanel = createEqualsSign();
					add(equalsPanel);
					solutionPanel = createSolutionTermPanel(prob);
					add(solutionPanel);
				}
				catch (IOException ex)
				{
					System.out.println(ex.toString());
				}
				finally
				{
					setVisible(true);
				}
			}
		}
	}

	public boolean isShowCorrectWholeFlag() {
		return showCorrectWholeFlag;
	}
	public void setShowCorrectWholeFlag(boolean showCorrectWholeFlag) {
		this.showCorrectWholeFlag = showCorrectWholeFlag;
	}
	public boolean isShowCorrectNumFlag() {
		return showCorrectNumFlag;
	}
	public void setShowCorrectNumFlag(boolean showCorrectNumFlag) {
		this.showCorrectNumFlag = showCorrectNumFlag;
	}

	//This function is called by the constructor to make the first panel that contains the 
	//first term in the expression to be displayed at the bottom of the Jframe. this panel
	//remains unchanged until the problem answer has been shot.
	public JPanel createFirstTermPanel(Problem prob) throws IOException{
		JPanel temp = new JPanel();//this panel contains all componts assembled to return
		temp.setLayout(new GridLayout(1,2));
//		URL myPicture = getClass().getResource("/images/fracline.png");
		BufferedImage myPicture = ImageIO.read(new File("fracline.png"));
		JLabel fracLine = new JLabel(new ImageIcon(myPicture));
		wholeNumber = new JLabel();
		wholeNumber.setHorizontalAlignment(JTextField.CENTER);
		wholeNumber.setFont(wholeNumber.getFont().deriveFont(60.0f));
		if (prob.getFirst().getWholeNumber() == 0){
			wholeNumber.setText("");
		}
		else{
			wholeNumber.setText(Integer.toString(prob.getFirst().getWholeNumber()));
		}
		temp.add(wholeNumber);
		JPanel displayFraction = new JPanel();
		displayFraction.setLayout(new GridLayout(3, 1));
		numerator = new JLabel();
		numerator.setHorizontalAlignment(JTextField.CENTER);
		numerator.setFont(numerator.getFont().deriveFont(28.0f));
		denominator = new JLabel();
		denominator.setHorizontalAlignment(JTextField.CENTER);
		denominator.setFont(denominator.getFont().deriveFont(28.0f));
		numerator.setText(Integer.toString(prob.getFirst().getNumerator()));
		denominator.setText(Integer.toString(prob.getFirst().getDenominator()));
		displayFraction.add(numerator);
		displayFraction.add(fracLine);
		displayFraction.add(denominator);
		temp.add(displayFraction);
		return temp;
	}

	//This function is called by the constructor to make the the panel that displays the 
	//second term of the problem displayed on the bottom of the Jframe. the first couple
	//of problem sets (divide and factor) will not use this panel. NOTE this panel is the 
	//third panel displayed!!! the second panel displayed is the addition or subtraction sign
  	public JPanel createSecondTermPanel(Problem prob) throws IOException{
		JPanel temp = new JPanel();
		temp.setLayout(new GridLayout(1,2));
//		URL myPicture = getClass().getResource("/images/fracline.png");
		BufferedImage myPicture = ImageIO.read(new File("fracline.png"));
		JLabel fracLine = new JLabel(new ImageIcon(myPicture));
		wholeNumber = new JLabel();
		wholeNumber.setHorizontalAlignment(JTextField.CENTER);
		wholeNumber.setFont(wholeNumber.getFont().deriveFont(60.0f));
		if (prob.getSecond().getWholeNumber() == 0){
			wholeNumber.setText("");
		}
		else{
			wholeNumber.setText(Integer.toString(prob.getSecond().getWholeNumber()));
		}
		temp.add(wholeNumber);
		JPanel displayFraction = new JPanel();
		displayFraction.setLayout(new GridLayout(3, 1));
		numerator = new JLabel();
		numerator.setHorizontalAlignment(JTextField.CENTER);
		numerator.setFont(numerator.getFont().deriveFont(28.0f));
		denominator = new JLabel();
		denominator.setHorizontalAlignment(JTextField.CENTER);
		denominator.setFont(denominator.getFont().deriveFont(28.0f));
		numerator.setText(Integer.toString(prob.getSecond().getNumerator()));
		denominator.setText(Integer.toString(prob.getSecond().getDenominator()));
		displayFraction.add(numerator);
		displayFraction.add(fracLine);
		displayFraction.add(denominator);
		temp.add(displayFraction);
		return temp;
	}

	//this function is called by the constructor to make a panel that just contains the 
	//equals sign for the equation to be displayed on the bottom of the Jframe.
	public JPanel createEqualsSign(){
		JPanel equals = new JPanel();
		JLabel equ = new JLabel("=");
		equ.setFont(equ.getFont().deriveFont(72.0f));
		equals.add(equ);
		add(equals);
		return equals;
	}

	//This function is called by the constructor to make the panel that contains the solution
	//term.  This is the most complicated panel function because this will contain the solution
	//and will display a large question mark indicating what field of the solution to shoot at.
	//some solution terms will have two targets to answer, the whole number field of the term,
	//and then the numerator of the fraction portion of the term.
	public JPanel createSolutionTermPanel(Problem prob) throws IOException{
		JPanel temp = new JPanel();
		if (prob.getTwoPartProblem())
		{
			if (showCorrectWholeFlag == true && showCorrectNumFlag == true){
				System.out.println("1");
				temp.setLayout(new GridLayout(1,2));
		//		URL myPicture = getClass().getResource("/images/fracline.png");

				BufferedImage myPicture = ImageIO.read(new File("fracline.png"));
				JLabel fracLine = new JLabel(new ImageIcon(myPicture));
				wholeNumber = new JLabel();
				wholeNumber.setHorizontalAlignment(JTextField.CENTER);
				wholeNumber.setFont(wholeNumber.getFont().deriveFont(60.0f));
				if (prob.getSolution().getWholeNumber() == 0){
					wholeNumber.setText("");
				}
				else{
					wholeNumber.setText(Integer.toString(prob.getSolution().getWholeNumber()));
				}
				temp.add(wholeNumber);
				JPanel displayFraction = new JPanel();
				displayFraction.setLayout(new GridLayout(3, 1));
				numerator = new JLabel();
				numerator.setHorizontalAlignment(JTextField.CENTER);
				numerator.setFont(numerator.getFont().deriveFont(28.0f));
				denominator = new JLabel();
				denominator.setHorizontalAlignment(JTextField.CENTER);
				denominator.setFont(denominator.getFont().deriveFont(28.0f));
				if (prob.getSolution().getNumerator() != 0 && prob.getSolution().getDenominator() != 0){
					numerator.setText(Integer.toString(prob.getSolution().getNumerator()));
					denominator.setText(Integer.toString(prob.getSolution().getDenominator()));
					displayFraction.add(numerator);
					displayFraction.add(fracLine);
					displayFraction.add(denominator);
				}
				temp.add(displayFraction);
			}
			
			else if (showCorrectWholeFlag == true && showCorrectNumFlag == false){
				System.out.println("2");
				temp.setLayout(new GridLayout(1,2));
//				URL myPicture = getClass().getResource("/images/fracline.png");
				BufferedImage myPicture = ImageIO.read(new File("fracline.png"));
				JLabel fracLine = new JLabel(new ImageIcon(myPicture));
				wholeNumber = new JLabel();
				wholeNumber.setHorizontalAlignment(JTextField.CENTER);
				wholeNumber.setFont(wholeNumber.getFont().deriveFont(60.0f));
				if (prob.getSolution().getWholeNumber() == 0){
					wholeNumber.setText("");
				}
				else{
					wholeNumber.setText(Integer.toString(prob.getSolution().getWholeNumber()));
				}
				temp.add(wholeNumber);
				JPanel displayFraction = new JPanel();
				displayFraction.setLayout(new GridLayout(3, 1));
				numerator = new JLabel();
				numerator.setHorizontalAlignment(JTextField.CENTER);
				numerator.setFont(numerator.getFont().deriveFont(28.0f));
				denominator = new JLabel();
				denominator.setHorizontalAlignment(JTextField.CENTER);
				denominator.setFont(denominator.getFont().deriveFont(28.0f));
				if (prob.getSolution().getNumerator() != 0 && prob.getSolution().getDenominator() != 0){
					numerator.setText("?");
					denominator.setText(Integer.toString(prob.getSolution().getDenominator()));
					displayFraction.add(numerator);
					displayFraction.add(fracLine);
					displayFraction.add(denominator);
				}
				temp.add(displayFraction);
			}
			
			else if (showCorrectWholeFlag == false && showCorrectNumFlag == true){
				System.out.println("3");
				temp.setLayout(new GridLayout(1,2));
//				URL myPicture = getClass().getResource("/images/fracline.png");
				BufferedImage myPicture = ImageIO.read(new File("fracline.png"));
				JLabel fracLine = new JLabel(new ImageIcon(myPicture));
				wholeNumber = new JLabel();
				wholeNumber.setHorizontalAlignment(JTextField.CENTER);
				wholeNumber.setFont(wholeNumber.getFont().deriveFont(60.0f));
				if (prob.getSolution().getWholeNumber() == 0){
					wholeNumber.setText("");
				}
				else{
					wholeNumber.setText("?");
				}
				temp.add(wholeNumber);
				JPanel displayFraction = new JPanel();
				displayFraction.setLayout(new GridLayout(3, 1));
				numerator = new JLabel();
				numerator.setHorizontalAlignment(JTextField.CENTER);
				numerator.setFont(numerator.getFont().deriveFont(28.0f));
				denominator = new JLabel();
				denominator.setHorizontalAlignment(JTextField.CENTER);
				denominator.setFont(denominator.getFont().deriveFont(28.0f));
				if (prob.getSolution().getNumerator() != 0 && prob.getSolution().getDenominator() != 0){
					numerator.setText(Integer.toString(prob.getSolution().getNumerator()));
					denominator.setText(Integer.toString(prob.getSolution().getDenominator()));
					displayFraction.add(numerator);
					displayFraction.add(fracLine);
					displayFraction.add(denominator);
				}
				temp.add(displayFraction);
			} 
			
			else
			{
				System.out.println("4");
				temp.setLayout(new GridLayout(1,2));
//				URL myPicture = getClass().getResource("/images/fracline.png");
				BufferedImage myPicture = ImageIO.read(new File("fracline.png"));
				JLabel fracLine = new JLabel(new ImageIcon(myPicture));
				wholeNumber = new JLabel();
				wholeNumber.setHorizontalAlignment(JTextField.CENTER);
				wholeNumber.setFont(wholeNumber.getFont().deriveFont(60.0f));
				if (prob.getSolution().getWholeNumber() == 0){
					wholeNumber.setText("");
				}
				else{
					wholeNumber.setText("?");
				}
				temp.add(wholeNumber);
				JPanel displayFraction = new JPanel();
				displayFraction.setLayout(new GridLayout(3, 1));
				numerator = new JLabel();
				numerator.setHorizontalAlignment(JTextField.CENTER);
				numerator.setFont(numerator.getFont().deriveFont(28.0f));
				denominator = new JLabel();
				denominator.setHorizontalAlignment(JTextField.CENTER);
				denominator.setFont(denominator.getFont().deriveFont(28.0f));
				if (prob.getSolution().getNumerator() != 0 && prob.getSolution().getDenominator() != 0){
					numerator.setText("?");
					denominator.setText(Integer.toString(prob.getSolution().getDenominator()));
					displayFraction.add(numerator);
					displayFraction.add(fracLine);
					displayFraction.add(denominator);
				}
				temp.add(displayFraction);
			}
		}
		else
		{
			System.out.println("Bye");
			temp.setLayout(new GridLayout(1,2));
//			URL myPicture = getClass().getResource("/images/fracline.png");
			BufferedImage myPicture = ImageIO.read(new File("fracline.png"));
			JLabel fracLine = new JLabel(new ImageIcon(myPicture));
			wholeNumber = new JLabel();
			wholeNumber.setHorizontalAlignment(JTextField.CENTER);
			wholeNumber.setFont(wholeNumber.getFont().deriveFont(60.0f));
			if (prob.getSolution().getWholeNumber() == 0){
				wholeNumber.setText("");
			}
			else{
				if (prob.getTwoPartProblem() == true)
				{
					wholeNumber.setText("Find");
				}
				else
				{
					wholeNumber.setText("?");
				}
			}
			temp.add(wholeNumber);
			JPanel displayFraction = new JPanel();
			displayFraction.setLayout(new GridLayout(3, 1));
			numerator = new JLabel();
			numerator.setHorizontalAlignment(JTextField.CENTER);
			numerator.setFont(numerator.getFont().deriveFont(28.0f));
			denominator = new JLabel();
			denominator.setHorizontalAlignment(JTextField.CENTER);
			denominator.setFont(denominator.getFont().deriveFont(28.0f));
			if (prob.getSolution().getNumerator() != 0 && prob.getSolution().getDenominator() != 0){
				numerator.setText("?");
				denominator.setText(Integer.toString(prob.getSolution().getDenominator()));
				displayFraction.add(numerator);
				displayFraction.add(fracLine);
				displayFraction.add(denominator);
			}
			temp.add(displayFraction);
		}
		System.out.println("Currently: " + showCorrectNumFlag + " " + showCorrectWholeFlag);
		return temp;
	}

	//This function is the question mark that will replace the solution or target field of 
	//the solution for display.
	public JPanel createQuestionMark(){
		JPanel question = new JPanel();
		JLabel quest = new JLabel("?");
		quest.setFont(quest.getFont().deriveFont(60.0f));
		question.add(quest);
		add(question);
		return question;
	}

	//This function makes the panel that displays the "+" sign for the display of the problem
	//on the bottom of the jframe.
	public JPanel createAdditionSign()
	{
		JPanel addition = new JPanel();
		JLabel add = new JLabel("  +");
		add.setFont(add.getFont().deriveFont(60.0f));
		addition.add(add);
		add(addition);
		return addition;
	}

	//This function makes the panel that displays the "-" sign for the display of tbe problem
	//on the bottom of the jframe.
	public JPanel createSubtractionSign(){
		JPanel subtraction = new JPanel();
		JLabel sub = new JLabel("  -");
		sub.setFont(sub.getFont().deriveFont(60.0f));
		subtraction.add(sub);
		add(subtraction);
		return subtraction;
	}

	//This function is used by the game logic to refreash or repaint various components durring
	//game play.
	public void updateDisplay(Problem p)
	{
		System.out.println("Did it change? " + showCorrectNumFlag + " " + showCorrectWholeFlag);
		this.removeAll();
		this.repaint();
		if (p.getSecond().getDenominator() == 0){
			try{
				firstPanel = createFirstTermPanel(p);
				add(firstPanel);
				operatorPanel = createEqualsSign();
				add(operatorPanel);
				solutionPanel = createSolutionTermPanel(p);
				add(solutionPanel);
			}
			catch (IOException ex){
				System.out.println(ex.toString());
			}
			finally{
				setVisible(true);
			}
		}
		else{
			if (p.getOperation() == "subtract"){
				try{
					firstPanel = createFirstTermPanel(p);
					add(firstPanel);
					operatorPanel = createSubtractionSign();
					add(operatorPanel);
					secondPanel = createSecondTermPanel(p);
					add(secondPanel);
					equalsPanel = createEqualsSign();
					solutionPanel = createSolutionTermPanel(p);
					add(solutionPanel);
				}
				catch (IOException ex){
					System.out.println(ex.toString());
				}
				finally{
					setVisible(true);
				}
			}
			else{
				try{
					firstPanel =createFirstTermPanel(p);
					add(firstPanel);
					operatorPanel = createAdditionSign();
					add(operatorPanel);
					secondPanel = createSecondTermPanel(p);
					add(secondPanel);
					equalsPanel = createEqualsSign();
					add(equalsPanel);
					solutionPanel = createSolutionTermPanel(p);
					add(solutionPanel);
				}
				catch (IOException ex){
					System.out.println(ex.toString());
				}
				finally{
					setVisible(true);
				}
			}
		}
		this.revalidate();
	}

	//This function is used by the game logic during game play.
	public ArrayList<SpaceTarget> generateTargets(Problem p)
	{	
		System.out.println(p.getSolution().getNumerator() + " " + p.getSolution().getWholeNumber());
		//Initialize the used cols array list
		usedCols = new ArrayList<Integer>();

		//Initialize the array list to be returned
		ArrayList<SpaceTarget> targets = new ArrayList<SpaceTarget>();
		Random generator = new Random();

		//Generate a random position for the target
		int x = generator.nextInt(2);
		int y = generator.nextInt(12);
		usedCols.add(y);
		int solution = -1;
		int solutionTwo = -1;
		float solutionFloat = -1;
		if(p.getOperation().equals("divide") && p.getLevel() == 1){
			targets.add(new SpaceTarget(x, y, p.getSolution().getWholeNumber()));
			solution = p.getSolution().getWholeNumber();
		}
		else if((p.getOperation().equals("factor") && p.getLevel() == 1) ||
				(p.getOperation().equals("add") && p.getLevel() == 1) ||
				(p.getOperation().equals("subtract") && p.getLevel() == 1)){
			targets.add(new SpaceTarget(x, y, p.getSolution().getNumerator()));
			solution = p.getSolution().getNumerator();	
		}
		else if(p.getOperation().equals("divide") && p.getLevel() == 2){
			targets.add(new SpaceTarget(x, y, p.getSolution().getDecimal()));
			solutionFloat = p.getSolution().getDecimal();
		}
		else if (p.getTwoPartProblem()){
			targets.add(new SpaceTarget(x, y, p.getSolution().getNumerator()));
			x = generator.nextInt(2);
			y = generator.nextInt(12);
			while(usedCols.contains(y))
			{
				y = generator.nextInt(12);
			}
			usedCols.add(y);
			targets.add(new SpaceTarget(x, y, p.getSolution().getWholeNumber()));
			solution = p.getSolution().getNumerator();	
			solutionTwo = p.getSolution().getWholeNumber();
		}

		//Generate other random incorrect targets
		for(int i = 0; i < 6; i++){
			if(solutionFloat == -1 && !p.getTwoPartProblem()){
				int wrong = generator.nextInt(20);
				while(wrong == solution)
				{
					wrong = generator.nextInt(20);
				}
				x = generator.nextInt(4);
				y = generator.nextInt(12);
				while(usedCols.contains(y))
				{
					y = generator.nextInt(12);
				}
				targets.add(new SpaceTarget(x, y, wrong));
				usedCols.add(y);
			}
			else if (p.getTwoPartProblem())
			{
				int wrong = generator.nextInt(20);
				while(wrong == solution || wrong == solutionTwo)
				{
					wrong = generator.nextInt(20);
				}
				x = generator.nextInt(4);
				y = generator.nextInt(12);
				while(usedCols.contains(y))
				{
					y = generator.nextInt(12);
				}
				targets.add(new SpaceTarget(x, y, wrong));
				usedCols.add(y);
			}
			else{
				float wrong = generator.nextFloat();
				while(wrong == solution){
					wrong = generator.nextFloat();
				}
				x = generator.nextInt(4);
				y = generator.nextInt(12);
				while(usedCols.contains(y)){
					y = generator.nextInt(12);
				}
				targets.add(new SpaceTarget(x, y, wrong));
				usedCols.add(y);
			}
		}
		return targets;
	}
}
