package mainGame;

import java.awt.GridLayout;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class StatusPanel extends JPanel{
	private JCheckBox DL1, DL2, DL3, FL1, FL2, FL3, AL1, AL2, AL3, SL1, SL2, SL3;
	
	public StatusPanel(){
		//setLayout(new GridLayout(2, 1));
		createProgressPanel();
		setVisible(true);
	}

	public void createProgressPanel(){
		JPanel levelProgress = new JPanel();
		//setLayout(new GridLayout(4,2));
		levelProgress.setLayout(new GridLayout(4,2));
		levelProgress.setVisible(true);
		JLabel progressLabel = new JLabel("Progress/Level");
		JTextField divide = new JTextField("Divide");
		DL1 = new JCheckBox("Level 1");
		DL2 = new JCheckBox("Level 2");
		DL3 = new JCheckBox("Level 3");
		levelProgress.add(divide);
		levelProgress.add(DL1);
		levelProgress.add(DL2);
		levelProgress.add(DL3);
		JTextField factor = new JTextField();
		JTextField add = new JTextField();
		JTextField sub = new JTextField();
		
		
	}
}
