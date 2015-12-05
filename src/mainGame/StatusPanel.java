package mainGame;

import java.awt.GridLayout;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class StatusPanel extends JPanel{
	private JCheckBox DL1, DL2, DL3, FL1, FL2, FL3, AL1, AL2, AL3, SL1, SL2, SL3;
	
	
	public StatusPanel(){
		
	}

	public void createProgressPanel(){
		JPanel levelProgress = new JPanel();
		setLayout(new GridLayout(4,1));
		levelProgress.setLayout(new GridLayout(4,3));
		JLabel progressLabel = new JLabel("Progress/Level");
		JTextField divide = new JTextField();
		JTextField factor = new JTextField();
		JTextField add = new JTextField();
		JTextField sub = new JTextField();
		DL1 = new JCheckBox("Level 1");
		DL2 = new JCheckBox("Level 2");
		DL3 = new JCheckBox("Level 3");
		
	}
}
