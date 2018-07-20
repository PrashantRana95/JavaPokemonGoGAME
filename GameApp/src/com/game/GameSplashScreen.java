package com.game;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.log4j.Logger;

import com.game.GameMainMenuScreen;
import com.game.GameSplashScreen;

import jaco.mp3.player.MP3Player;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JProgressBar;
import javax.swing.JWindow;
import javax.swing.Timer;

import java.awt.Font;
import javax.swing.SwingConstants;

public class GameSplashScreen extends JWindow {
	
	//This is a label created for GameTitle
	private JLabel lblGame = new JLabel("GAME-2017");
	//This is used for the progressbar
	private JProgressBar progressBar = new JProgressBar();
	//A boolean variable is taken 
	private boolean isVisible ;
	private JPanel contentPane;
	//progressCounter has been taken
	private int progressCounter;
	private Timer timer;
	//For Music in Splash Screen
	private MP3Player mp3;
	//For Logging 
	private Logger logger = Logger.getLogger(GameSplashScreen.class);
	
	
	private void playSound(){
		logger.debug("Play Sound Call");
		mp3 = new MP3Player(GameSplashScreen.class.getResource("Wonder Woman.mp3"));
		mp3.play();
	}
	
	
	private void doAnimation(){
		logger.debug("Animation Call Start...");
		timer = new Timer(25,(e)->{
			progressBar.setValue(progressCounter);
			progressCounter++;
			if(progressCounter>100){
				timer.stop();
				mp3.stop();
				GameMainMenuScreen menu = new GameMainMenuScreen();
				menu.setVisible(true);
				GameSplashScreen.this.setVisible(false);
				GameSplashScreen.this.dispose();
			}
			lblGame.setVisible(isVisible);
			isVisible = !isVisible;
		});
		timer.start();
		logger.debug("Animation Call Ends...");
	}
	
	//Launch the application.
	 
	public static void main(String[] args) {
		
		GameSplashScreen frame = new GameSplashScreen();
		frame.setVisible(true);
		frame.playSound();
		frame.doAnimation();
		
	}

	//Creates the frame
	public GameSplashScreen() {
		logger.debug("Game Splash Screen Constructor Call");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(614, 466);
		setLocationRelativeTo(null);
		//setBounds(100, 100, 623, 466);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(GameSplashScreen.class.getResource("/com/images/New.jpg")));
		lblNewLabel.setBounds(0, 0, 613, 386);
		contentPane.add(lblNewLabel);
		progressBar.setFont(new Font("Bernard MT Condensed", Font.BOLD, 18));
		progressBar.setForeground(Color.GREEN);
		progressBar.setStringPainted(true);
		
		
		progressBar.setBounds(52, 397, 532, 33);
		contentPane.add(progressBar);
		lblGame.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		lblGame.setFont(new Font("Bernard MT Condensed", Font.BOLD, 18));
		lblGame.setBounds(217, 433, 181, 33);
		contentPane.add(lblGame);
	}
}
