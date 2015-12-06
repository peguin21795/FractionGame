package mainGame;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

public class StatusPanel extends JPanel{
	private JCheckBox DL1, DL2, DL3, FL1, FL2, FL3, AL1, AL2, AL3, SL1, SL2, SL3;
	
	public StatusPanel(){
		setLayout(new GridLayout(2, 1));
		createProgressPanel();
		createScoreBoard();
		setVisible(true);
	}

	public void createProgressPanel(){
		JPanel levelProgress = new JPanel();
		JPanel buttons = new JPanel();
		buttons.setLayout(new GridLayout(4,3));
		levelProgress.setLayout(new GridLayout(4,1));
		levelProgress.setVisible(true);
		JLabel divide = new JLabel("Divide");
		divide.setBorder(new EtchedBorder());
		JLabel factor = new JLabel("Factor");
		factor.setBorder(new EtchedBorder());
		JLabel add = new JLabel("Addition");
		add.setBorder(new EtchedBorder());
		JLabel sub = new JLabel("Subtraction");
		sub.setBorder(new EtchedBorder());
		divide.setHorizontalAlignment(JTextField.CENTER);
		factor.setHorizontalAlignment(JTextField.CENTER);
		add.setHorizontalAlignment(JTextField.CENTER);
		sub.setHorizontalAlignment(JTextField.CENTER);
		DL1 = new JCheckBox("Level 1");
		DL2 = new JCheckBox("Level 2");
		DL3 = new JCheckBox("Level 3");
		levelProgress.add(divide);
		levelProgress.add(factor);
		levelProgress.add(add);
		levelProgress.add(sub);
		buttons.add(DL1);
		buttons.add(DL2);
		buttons.add(DL3);
		FL1 = new JCheckBox("Level 1");
		FL2 = new JCheckBox("Level 2");
		FL3 = new JCheckBox("Level 3");
		buttons.add(FL1);
		buttons.add(FL2);
		buttons.add(FL3);
		AL1 = new JCheckBox("Level 1");
		AL2 = new JCheckBox("Level 2");
		AL3 = new JCheckBox("Level 3");
		buttons.add(AL1);
		buttons.add(AL2);
		buttons.add(AL3);
		SL1 = new JCheckBox("Level 1");
		SL2 = new JCheckBox("Level 2");
		SL3 = new JCheckBox("Level 3");
		buttons.add(SL1);
		buttons.add(SL2);
		buttons.add(SL3);
		add(levelProgress);
		add(buttons); 
		//	JTextField factor = new JTextField();
	//	JTextField add = new JTextField();
	//	JTextField sub = new JTextField();
		
		
	}
	
	public void createScoreBoard(){
		JLabel score = new JLabel("     Score");
		score.setLayout(new GridLayout(1,1));
		score.setHorizontalAlignment(JTextField.CENTER);
		score.setFont(score.getFont().deriveFont(60.0f));
		add(score);
		
		
	}
}
