package com.game;
import javax.swing.JFrame;

public class GameFrame extends JFrame implements GameConstants{
	
	public GameFrame(){
		//size has been given here
		setSize(GAME_WIDTH,GAME_HEIGHT);
		//board obj created here and thus board default constructor will be called first
		Board board=new Board();
		//The Board will be added here
		add(board);
//		Thread worker = new Thread(board);
//		worker.start();
		
		//Used for Song play
		PlaySong.songPlay();
		//Sets true to the frame
		setVisible(true);
		//sets the frame in the center
		setLocationRelativeTo(null);
		//will not be Resizable
		setResizable(false);
		//will be completely close from the background
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
//		//GameFrame obj created 
//		//GameFrame obj=new GameFrame();
		new GameFrame();
	}

}
