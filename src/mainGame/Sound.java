package mainGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.JButton;
import javax.swing.JPanel;

import sun.audio.AudioData;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;

public class Sound extends JPanel{
	
	public Sound(){
	//	JPanel soundTest = new JPanel();
		JButton BRDM = new JButton("Intro Music");
		JButton battleMusic = new JButton("Battel Music");
		add(BRDM);
		add(battleMusic);
		BRDM.addActionListener(new IntroAudioListener());
		battleMusic.addActionListener(new BattleAudioListener());
		
		
	}
	
	class IntroAudioListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
	//		try {
				music();
		}
	}
	
	class BattleAudioListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
	//		try {
				try {
					musicBattle();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		}
	}
	
	public void music() {
		AudioPlayer backgroundPlayer = AudioPlayer.player;
		InputStream in = null;
		try {
			in = new FileInputStream("Vollejo_bed.wav");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		AudioStream introMusic = null;
		try {
			introMusic = new AudioStream(new FileInputStream("c:\\Vollejo_bed.wav"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			introMusic = new AudioStream(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		AudioData musicData = null;
		ContinuousAudioDataStream loop = null;
		try {
			musicData = introMusic.getData();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		loop = new ContinuousAudioDataStream(musicData);

		backgroundPlayer.start(loop);
	}

	public void musicBattle() throws FileNotFoundException, IOException{
		AudioPlayer battlePlayer = AudioPlayer.player;
		AudioStream battleMusic;
		AudioData battleMusicData;
		ContinuousAudioDataStream loop = null;
		battleMusic = new AudioStream(new FileInputStream("PropellerheadsSpybreak.mp3"));
		battleMusicData = battleMusic.getData();
		loop = new ContinuousAudioDataStream(battleMusicData);
		
		battlePlayer.start(loop);
	}

}
