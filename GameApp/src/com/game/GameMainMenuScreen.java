package com.game;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import org.apache.log4j.Logger;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

public class GameMainMenuScreen extends JFrame {
	
	
	//Logging class obj is created here 
	Logger logger = Logger.getLogger(GameMainMenuScreen.class);
	private JPanel contentPane;
	public static JMenu mnGames = new JMenu("Games");
	private boolean isTitlePresent ;
	private String title = "                                                                                                                                       ";
	private Timer timer;
	StringBuffer sb = new StringBuffer();
	static JMenuItem mntmRegister = new JMenuItem("Register");
	
	
	//This is used to make revolving title
	public void prepareTitle(){
		if(this.getTitle().trim().length()>0 && !isTitlePresent){
			title += this.getTitle();
			isTitlePresent = true;
			this.setTitle(title);
			sb.append(title);
		}
	}
	public void doTitleAnimation(){
		timer = new Timer(100,(e)->{
			if(isTitlePresent){
				char singleChar = sb.charAt(0);
				sb.append(singleChar);
				sb.deleteCharAt(0);
				//System.out.println("["+sb+"]");
				this.setTitle(sb.toString());
			}
		});
		timer.start();
	}
	/**
	 * Create the frame.
	 */
	public GameMainMenuScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 607, 350);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmLogin = new JMenuItem("Login");
		mntmLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openLogin();
			}
		});
		mntmLogin.setIcon(new ImageIcon(GameMainMenuScreen.class.getResource("/com/images/Login.png")));
		mnFile.add(mntmLogin);
		mntmRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openRegister();
			}
		});
		
		mntmRegister.setIcon(new ImageIcon(GameMainMenuScreen.class.getResource("/com/images/Register.png")));
		mnFile.add(mntmRegister);
		
		//By setting this false..when game main menu screen will be opened it will automatically sets to false
		mnGames.setEnabled(false);
		mnGames.setIcon(new ImageIcon(GameMainMenuScreen.class.getResource("/com/images/gaming.png")));
		mnFile.add(mnGames);
		
		JMenuItem mntmPokemon = new JMenuItem("Pokemon");
		mntmPokemon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startPokemon();
			}
		});
		mntmPokemon.setIcon(new ImageIcon(GameMainMenuScreen.class.getResource("/com/images/Poke.png")));
		mnGames.add(mntmPokemon);
		
		JMenuItem mntmIceHockey = new JMenuItem("Ice Hockey");
		mntmIceHockey.setIcon(new ImageIcon(GameMainMenuScreen.class.getResource("/com/images/ice.png")));
		mnGames.add(mntmIceHockey);
		
		JMenuItem mntmTicTacToe = new JMenuItem("Tic Tac Toe");
		mntmTicTacToe.setIcon(new ImageIcon(GameMainMenuScreen.class.getResource("/com/images/Tic-Tac-Toe-Game.png")));
		mnGames.add(mntmTicTacToe);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.setIcon(new ImageIcon(GameMainMenuScreen.class.getResource("/com/images/exit.png")));
		mnFile.add(mntmExit);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(GameMainMenuScreen.class.getResource("/com/images/Pokemons.jpg")));
		lblNewLabel.setBounds(0, 0, 1362, 684);
		contentPane.add(lblNewLabel);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		isAlreadyRegister();
	}
	
	private void isAlreadyRegister(){
		//This will check in the file if user already register then it will sets the false to register menu item
		String path = "F:\\Prashant\\Experiments\\JAVA\\GameApp\\users.dat";
		File file = new File(path);
		if(file.exists()){
			mntmRegister.setVisible(false);
		}
		
	}
	
	
	
	private void openLogin(){
		
		LoginScreen login = new LoginScreen(this);
		logger.debug("Inside Login"+login.isVisible());
		login.setVisible(true);
		logger.debug("Login Ends"+login.isVisible());
	}
	
	
	private void startPokemon(){
		//GameFrame pokemon = new GameFrame();
		new GameFrame();
	}
	
	
	
	private void openRegister(){
		logger.debug("Inside Register");
		RegisterScreen rs = new RegisterScreen();
		rs.setVisible(true);
		logger.debug("Register Ends ");
		
	}

}
