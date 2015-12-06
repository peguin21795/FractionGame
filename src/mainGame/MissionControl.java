package mainGame;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MissionControl extends JPanel{
	private JLabel wholeNumber,numerator,denominator;
	private boolean showCorrectWholeFlag = false;
	private boolean showCorrectNumFlag = false;
	private ArrayList<Integer> usedCols;
	private JPanel firstPanel, secondPanel, solutionPanel, operatorPanel, equalsPanel;
	public MissionControl()
	{
		//	prob = null;
	}
	public MissionControl(Problem prob){
		firstPanel = new JPanel();
		secondPanel = new JPanel();
		solutionPanel = new JPanel();
		operatorPanel = new JPanel();
		
		if (prob.getSecond() == null)
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

	public JPanel createFirstTermPanel(Problem prob) throws IOException{
		JPanel temp = new JPanel();
		temp.setLayout(new GridLayout(1,2));
		BufferedImage myPicture = ImageIO.read(new File("fracline.png"));
		JLabel fracLine = new JLabel(new ImageIcon(myPicture));
		wholeNumber = new JLabel();
		wholeNumber.setHorizontalAlignment(JTextField.CENTER);
		wholeNumber.setFont(wholeNumber.getFont().deriveFont(60.0f));
		if (prob.getFirst().getWholeNumber() == 0)
		{
			wholeNumber.setText("");
		}
		else
		{
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

	public JPanel createSecondTermPanel(Problem prob) throws IOException{
		JPanel temp = new JPanel();
		temp.setLayout(new GridLayout(1,2));
		BufferedImage myPicture = ImageIO.read(new File("fracline.png"));
		JLabel fracLine = new JLabel(new ImageIcon(myPicture));
		wholeNumber = new JLabel();
		wholeNumber.setHorizontalAlignment(JTextField.CENTER);
		wholeNumber.setFont(wholeNumber.getFont().deriveFont(60.0f));
		if (prob.getSecond().getWholeNumber() == 0)
		{
			wholeNumber.setText("");
		}
		else
		{
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

	public JPanel createEqualsSign(){
		JPanel equals = new JPanel();
		JLabel equ = new JLabel("=");
		equ.setFont(equ.getFont().deriveFont(72.0f));
		equals.add(equ);
		add(equals);
		return equals;
	}

	public JPanel createSolutionTermPanel(Problem prob) throws IOException{
		JPanel temp = new JPanel();
		if (showCorrectWholeFlag == true && showCorrectNumFlag == true)
		{
			temp.setLayout(new GridLayout(1,2));
			BufferedImage myPicture = ImageIO.read(new File("fracline.png"));
			JLabel fracLine = new JLabel(new ImageIcon(myPicture));
			wholeNumber = new JLabel();
			wholeNumber.setHorizontalAlignment(JTextField.CENTER);
			wholeNumber.setFont(wholeNumber.getFont().deriveFont(60.0f));
			if (prob.getSolution().getWholeNumber() == 0)
			{
				wholeNumber.setText("");
			}
			else
			{
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
			if (prob.getSolution().getNumerator() != 0 && prob.getSolution().getDenominator() != 0)
			{
				numerator.setText(Integer.toString(prob.getSolution().getNumerator()));
				denominator.setText(Integer.toString(prob.getSolution().getDenominator()));
				displayFraction.add(numerator);
				displayFraction.add(fracLine);
				displayFraction.add(denominator);
			}

			temp.add(displayFraction);
		}
		else if (showCorrectWholeFlag == true)
		{
			temp.setLayout(new GridLayout(1,2));
			BufferedImage myPicture = ImageIO.read(new File("fracline.png"));
			JLabel fracLine = new JLabel(new ImageIcon(myPicture));
			wholeNumber = new JLabel();
			wholeNumber.setHorizontalAlignment(JTextField.CENTER);
			wholeNumber.setFont(wholeNumber.getFont().deriveFont(60.0f));
			if (prob.getSolution().getWholeNumber() == 0)
			{
				wholeNumber.setText("");
			}
			else
			{
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
			if (prob.getSolution().getNumerator() != 0 && prob.getSolution().getDenominator() != 0)
			{
				numerator.setText("?");
				denominator.setText(Integer.toString(prob.getSolution().getDenominator()));
				displayFraction.add(numerator);
				displayFraction.add(fracLine);
				displayFraction.add(denominator);
			}

			temp.add(displayFraction);
		}
		else
		{
			temp.setLayout(new GridLayout(1,2));
			BufferedImage myPicture = ImageIO.read(new File("fracline.png"));
			JLabel fracLine = new JLabel(new ImageIcon(myPicture));
			wholeNumber = new JLabel();
			wholeNumber.setHorizontalAlignment(JTextField.CENTER);
			wholeNumber.setFont(wholeNumber.getFont().deriveFont(60.0f));
			if (prob.getSolution().getWholeNumber() == 0)
			{
				wholeNumber.setText("");
			}
			else
			{
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
			if (prob.getSolution().getNumerator() != 0 && prob.getSolution().getDenominator() != 0)
			{
				numerator.setText("?");
				denominator.setText(Integer.toString(prob.getSolution().getDenominator()));
				displayFraction.add(numerator);
				displayFraction.add(fracLine);
				displayFraction.add(denominator);
			}

			temp.add(displayFraction);
		}
		return temp;
	}


	public JPanel createQuestionMark(){
		JPanel question = new JPanel();
		JLabel quest = new JLabel("?");
		quest.setFont(quest.getFont().deriveFont(60.0f));
		question.add(quest);
		add(question);
		return question;
	}

	public JPanel createAdditionSign()
	{
		JPanel addition = new JPanel();
		JLabel add = new JLabel("  +");
		add.setFont(add.getFont().deriveFont(60.0f));
		addition.add(add);
		add(addition);
		return addition;
	}

	public JPanel createSubtractionSign(){
		{
			JPanel subtraction = new JPanel();
			JLabel sub = new JLabel("  -");
			sub.setFont(sub.getFont().deriveFont(60.0f));
			subtraction.add(sub);
			add(subtraction);
			return subtraction;
		}
	}

	public void progressDisplay(){

	}

	public void updateDisplay(Problem p)
	{
		this.removeAll();
		this.repaint();
		if (p.getSecond() == null)
		{
			try
			{
				firstPanel = createFirstTermPanel(p);
				add(firstPanel);
				operatorPanel = createEqualsSign();
				add(operatorPanel);
				solutionPanel = createSolutionTermPanel(p);
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
			if (p.getOperation() == "subtract")
			{
				try
				{
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
		this.revalidate();
	}

	public ArrayList<SpaceTarget> generateTargets(Problem p)
	{	
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
		float solutionFloat = -1;
		if(p.getOperation().equals("divide") && p.getLevel() == 1)
		{
			targets.add(new SpaceTarget(x, y, p.getSolution().getWholeNumber()));
			solution = p.getSolution().getWholeNumber();
		}
		else if((p.getOperation().equals("divide") && p.getLevel() == 3) || 
				(p.getOperation().equals("factor") && p.getLevel() == 1) ||
				(p.getOperation().equals("add") && p.getLevel() == 1) ||
				(p.getOperation().equals("subtract") && p.getLevel() == 1))
		{
			targets.add(new SpaceTarget(x, y, p.getSolution().getNumerator()));
			solution = p.getSolution().getNumerator();
			//div level 2: float, wholenumber
			//factor level 2/3: whole number and numerator
			//add level 2/3: whole number and numerator if > 1
			//sub level 2/3: whole number, numerator 
			
		}
		else if(p.getOperation().equals("divide") && p.getLevel() == 2)
		{
			targets.add(new SpaceTarget(x, y, p.getSolution().getDecimal()));
			solutionFloat = p.getSolution().getDecimal();
		}
		else
		{
		}

		//Generate other random incorrect targets
		for(int i = 0; i < 6; i++)
		{
			if(solutionFloat == -1)
			{
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
			else
			{
				float wrong = generator.nextFloat();
				while(wrong == solution)
				{
					wrong = generator.nextFloat();
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
		}

		return targets;
	}

}
