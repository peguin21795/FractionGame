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
	private JPanel progressPanel, scorePanel;
	private int currentScore;
	
	public StatusPanel(){
		setLayout(new GridLayout(2, 1));
		progressPanel = createProgressPanel();
		add(progressPanel);
		scorePanel = createScoreBoard();
		add(scorePanel);
		setVisible(true);
	}

	public JPanel createProgressPanel(){
		JPanel temp = new JPanel();
		JPanel levelProgress = new JPanel();
		JPanel buttons = new JPanel();
		buttons.setLayout(new GridLayout(4,3));
		levelProgress.setLayout(new GridLayout(4,1));
		levelProgress.setVisible(true);
		JLabel divide = new JLabel("Divide");
		divide.setBorder(new EtchedBorder());
		divide.setFont(divide.getFont().deriveFont(14.0f));
		JLabel factor = new JLabel("Factor");
		factor.setBorder(new EtchedBorder());
		factor.setFont(factor.getFont().deriveFont(14.0f));
		JLabel add = new JLabel("Addition");
		add.setBorder(new EtchedBorder());
		add.setFont(add.getFont().deriveFont(14.0f));
		JLabel sub = new JLabel("Subtraction");
		sub.setBorder(new EtchedBorder());
		sub.setFont(sub.getFont().deriveFont(14.0f));
		divide.setHorizontalAlignment(JTextField.CENTER);
		factor.setHorizontalAlignment(JTextField.CENTER);
		add.setHorizontalAlignment(JTextField.CENTER);
		sub.setHorizontalAlignment(JTextField.CENTER);
		DL1 = new JCheckBox("Level 1");
		DL2 = new JCheckBox("Level 2");
		DL3 = new JCheckBox("Level 3");
		DL1.setEnabled(false);
		DL2.setEnabled(false);
		DL3.setEnabled(false);
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
		FL1.setEnabled(false);
		FL2.setEnabled(false);
		FL3.setEnabled(false);
		AL1.setEnabled(false);
		AL2.setEnabled(false);
		AL3.setEnabled(false);
		SL1.setEnabled(false);
		SL2.setEnabled(false);
		SL3.setEnabled(false);
		temp.add(levelProgress);
		temp.add(buttons); 
		return temp;
	}
	
	public JPanel createScoreBoard(){
		JPanel temp = new JPanel();
		JLabel score = new JLabel("Score");
		JTextField liveScore = new JTextField();
		score.setLayout(new GridLayout(1,1));
		score.setHorizontalAlignment(JTextField.CENTER);
		score.setFont(score.getFont().deriveFont(30.0f));
		liveScore.setLayout(new GridLayout(1,1));
		liveScore.setHorizontalAlignment(JTextField.CENTER);
		liveScore.setFont(score.getFont().deriveFont(60.0f));
		liveScore.setText(Integer.toString(currentScore));
		temp.add(score);
		temp.add(liveScore);
		
		return temp;	
	}

	public void setCurrentScore(int currentScore) {
		this.currentScore = currentScore;
	}
}
