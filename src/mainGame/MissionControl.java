package mainGame;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MissionControl extends JPanel{
	private JLabel wholeNumber,numerator,denominator;
	private Boolean shootCorrectFlag = false;
	public MissionControl()
	{
		//	prob = null;
	}
	public MissionControl(Problem prob) throws IOException{
		//this.prob = prob;
		createFirstTermPanel(prob);
		createEqualsSign();
		createSolutionTerm(prob);
		setVisible(true);

	}

	public Problem generateProblem(){
		return null;
	}

	public void createFirstTermPanel(Problem prob) throws IOException{
		//JPanel firstPanel = new JPanel();
		setLayout(new GridLayout(1,2));
		BufferedImage myPicture = ImageIO.read(new File("fracline.png"));
		JLabel fracLine = new JLabel(new ImageIcon(myPicture));
		//JLabel fracLine = new JLabel("");
		//fracLine.setFont(fracLine.getFont().deriveFont(24.0f));
		//fracLine.setFont(fracLine.getFont().deriveFont(Font.BOLD));
		//fracLine.setHorizontalAlignment(JTextField.CENTER);
		//fracLine.setVerticalAlignment(JTextField.TOP);
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
		add(wholeNumber);
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
		add(displayFraction);

	}

	public void createEqualsSign(){
		JPanel equals = new JPanel();
		JLabel equ = new JLabel("=");
		equ.setFont(equ.getFont().deriveFont(72.0f));
		equals.add(equ);
		add(equals);
	}

	public void createSolutionTerm(Problem prob) throws IOException{
		if (shootCorrectFlag)
		{
			setLayout(new GridLayout(1,2));
			BufferedImage myPicture = ImageIO.read(new File("fracline.png"));
			JLabel fracLine = new JLabel(new ImageIcon(myPicture));
			fracLine.setFont(fracLine.getFont().deriveFont(24.0f));
			fracLine.setFont(fracLine.getFont().deriveFont(Font.BOLD));
			fracLine.setHorizontalAlignment(JTextField.CENTER);
			fracLine.setVerticalAlignment(JTextField.TOP);
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
			add(wholeNumber);
			JPanel displayFraction = new JPanel();
			displayFraction.setLayout(new GridLayout(3, 1));
			numerator = new JLabel();
			numerator.setHorizontalAlignment(JTextField.CENTER);
			denominator = new JLabel();
			denominator.setHorizontalAlignment(JTextField.CENTER);
			if (prob.getSolution().getNumerator() != 0 && prob.getSolution().getDenominator() != 0)
			{
				numerator.setText(Integer.toString(prob.getSolution().getNumerator()));
				denominator.setText(Integer.toString(prob.getSolution().getDenominator()));
				displayFraction.add(numerator);
				displayFraction.add(fracLine);
				displayFraction.add(denominator);
			}

			add(displayFraction);
		}
		else
		{
			createQuestionMark();
		}
	}

	public void createQuestionMark(){
		JPanel question = new JPanel();
		JLabel quest = new JLabel("?");
		quest.setFont(quest.getFont().deriveFont(60.0f));
		question.add(quest);
		add(question);
	}

	public void progressDisplay(){

	}

	public void updateDisplay(){

	}

	public ArrayList<SpaceTarget> generateTargets(){
		return null;
	}

}
