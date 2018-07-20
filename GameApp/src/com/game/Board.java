package com.game;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.Timer;

import org.apache.log4j.Logger;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Board extends JPanel implements GameConstants{//, Runnable{
	//the image background is set here
	//image variable created
	Image background;
	//player class variable created on board
	Player player;
	SecondPlayer secondplayer;
	
	
	//Powers powerLists = new Powers();
	private Timer timer;
	private Logger logger = Logger.getLogger(Board.class);
	
	private void bindEvents(){
		//KeyListener is used to listen to the key event
		addKeyListener(new KeyAdapter(){
			
			@Override
			public void keyReleased(KeyEvent e){
				//System.out.println("Release "+e.getKeyCode()+" "+e.getKeyChar());
			}
			
			@Override
			public void keyPressed(KeyEvent e){
				if(e.getKeyCode()==KeyEvent.VK_RIGHT){
					//System.out.println("Right");
					player.setSpeed(30);
					player.move();
					
					player.doWalk();
					
				}
				else
				if(e.getKeyCode()==KeyEvent.VK_LEFT){
					//System.out.println("Left");
					player.setSpeed(-10);
					player.move();
					
					player.doBack();
				}
				//A key will act as left key
				else 
				if(e.getKeyCode()==KeyEvent.VK_A){
					secondplayer.setSpeed(30);
					secondplayer.move();
					
					secondplayer.doMoveFront();
				}
				else
				if(e.getKeyCode()==KeyEvent.VK_D){
					secondplayer.setSpeed(-10);
					secondplayer.move();
					
					secondplayer.doMoveBack();
				}
				else
				if(e.getKeyCode()==KeyEvent.VK_SPACE){

					player.doKick();
					
					player.jump();
					//repaint();
				}
				else
				if(e.getKeyCode()==KeyEvent.VK_F){
					//System.out.println("Space");
					secondplayer.doFly();
					//secondplayer.doAir();
					secondplayer.fly();
					
				}
				else
				if(e.getKeyCode()==KeyEvent.VK_I){
					

					
					player.doIce();
					//through this player will fire the fire balls
					player.fire();
					
					//repaint();
				}
				else
				if(e.getKeyCode()==KeyEvent.VK_B){
					secondplayer.doFireSpin();
					//Through this the second player will fire 
					secondplayer.fire();
				}
			}
		}		
	);
	}
	
	
	//Collision method is done here 
	private boolean isCollision(SecondPlayer secondplayer, Powers powers){
		System.out.println("isCollision x"+secondplayer.getX());
		System.out.println("Powers x"+powers.getX());
		int xDistance = Math.abs(secondplayer.getX()- powers.getX());
		//System.out.println(xDistance);
		//System.out.println(secondplayer.getX() - powerLists.getX());
		
		int yDistance = Math.abs(secondplayer.getY()- powers.getY());
		//System.out.println(getY());
		System.out.println("Secondplayer width "+secondplayer.getW());
		System.out.println("Powers width"+powers.getW());
		int width = Math.max(secondplayer.getW(), powers.getW());
		//System.out.println(secondplayer.getW());
		//System.out.println("Power Width" +powerLists.getW());
		int height = Math.max(secondplayer.getH(), powers.getH());
		return xDistance<=(width-150) && yDistance<=(height-20);
	}
	
	private boolean isCollision2(Player player, SecondPower secondpowers){
		System.out.println("isCollision x"+player.getX());
		System.out.println("SecondPowers x"+secondpowers.getX());
		int xDistance = Math.abs(player.getX()- secondpowers.getX());
		//System.out.println(xDistance);
		//System.out.println(player.getX() - secondpowers.getX());
		
		int yDistance = Math.abs(player.getY()- secondpowers.getY());
		//System.out.println(getY());
		System.out.println("Player width "+player.getW());
		System.out.println("SecondPowers width"+secondpowers.getW());
		int width = Math.max(player.getW(), secondpowers.getW());
		//System.out.println(player.getW());
		//System.out.println("Power Width" +secondpowers.getW());
		int height = Math.max(player.getH(), secondpowers.getH());
		return xDistance<=(width-10) && yDistance<=(height-20);
	}
	
	
	Image img;
	//Method to stop the game 
	private void gameOver(Graphics g){
		
//		g.setFont(new Font("Arial", Font.BOLD,40));
//		g.setColor(Color.RED);
//		g.drawString("Game Over",GAME_WIDTH/2, GAME_HEIGHT/2);
	
		img=new ImageIcon(Board.class.getResource(GAME_OVER)).getImage();
		g.drawImage(img, GAME_WIDTH/4, GAME_HEIGHT/3, null);			
	}
	
	private boolean isGameOver = false;
	
	//Powers powerLists[] = new Powers[5];
	
	//ArrayList<Powers> powerList = new ArrayList<>();
	
	
	private void checkCollision(){
		
		
		ArrayList<Powers> powerList = player.getPowerList();
		ArrayList<SecondPower> secondpowerList = secondplayer.getSecondpowerList();
		
		
		
		System.out.println("Accessing powers "+powerList);
		if(powerList.size()>0){
			for(Powers powers : powerList){
				System.out.println("isCollision Call"+isCollision(secondplayer, powers));
				if(isCollision(secondplayer, powers)){
					System.out.println("Another Call"+isCollision(secondplayer, powers));
					//isGameOver = true;
					if(player.health==0){
						isGameOver = true;
						timer.stop();
					}
					else
					{
						player.health-=5;
						isGameOver =  false;
					}
					repaint();
					//timer will stop after two players meet each other
//					timer.stop();
					 
	//				try {
	//					Thread.sleep(50);
	//				} catch (InterruptedException e) {
	//					// TODO Auto-generated catch block
	//					e.printStackTrace();
	//				}
				}
			}
		}
		
		else{
			for(SecondPower secondpowers : secondpowerList){
				System.out.println("isCollision Call"+isCollision2(player, secondpowers));
				if(isCollision2(player, secondpowers)){
					System.out.println("Another Call"+isCollision2(player, secondpowers));
//					isGameOver = true;
					System.out.println("Current Second Player Energy"+secondplayer.energy);
					if(secondplayer.energy==0){
						
						isGameOver = true;
						//timer will stop after two players meet each other
						timer.stop();
					}
					else{
						secondplayer.energy-=5;
						isGameOver = false;
					}
					//timer will stop after two players meet each other
//					timer.stop();
					repaint();
					 
	//				try {
	//					Thread.sleep(50);
	//				} catch (InterruptedException e) {
	//					// TODO Auto-generated catch block
	//					e.printStackTrace();
	//				}
				}
			}
			
		}
	}
	
	/*
	@Override
	public void run(){
	
		//This will work in an infinite loop
		while(true){
		//System.out.println("Name Please "+Thread.currentThread().getName());
		repaint();
		player.fall();
		secondplayer.fall();
		//System.out.println(checkCollision());
		checkCollision();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
	*/
	
	
	
	
	private void gameLoop(){
		timer=new Timer(DELAY,(e)->
		{
			repaint();
			player.fall();
			secondplayer.fall();
			checkCollision();
		}
				);
		timer.start();
	}
	
	
	//default constructor is created here
	public Board(){
		//sets the size of the board
		setSize(GAME_WIDTH,GAME_HEIGHT);
		//sets the background image
		background=new ImageIcon(Board.class.getResource(BACKGROUND)).getImage();
		player=new Player();
		secondplayer=new SecondPlayer();
		//sets the image true on the board	
		//This Basically helps the key to be active on the time of Board
		//If this is False then key will be pressed but its focus would not set to the Board
		//That's why this is Set to true so that whenever any key presses it is set to focusable True
		setFocusable(true);
		//This is used to call the key events method
		bindEvents();
		//This gameloop method is used for Timer
		gameLoop();
	}
	
	
	
	//This will display the players powers
	private void printPowers(Graphics g){
		//ArrayList of type Powers so that it will make object of type power only
		ArrayList<Powers> powerList = player.getPowerList();
		if(powerList.size()>0){
			for(Powers power : powerList){
				if(power.isVisible()){
					//draws the power from player
				power.drawPowers(g);
				power.drawPowersWaterGun(g);
				//powers will be moving at a constant speed
				power.move();
				//it vanish when goes out of screen
				power.outOfScreen();
				}
			}
		}
	}
	
	//Private method of powers are created here 
	private void printSecondPowers(Graphics g){
		//ArrayList is created here 
		ArrayList<SecondPower> secondpowerList = secondplayer.getSecondpowerList();
		if(secondpowerList.size()>0){
			for(SecondPower secondpower : secondpowerList){
				if(secondpower.isVisible()){
					secondpower.drawPowers(g);
					secondpower.move();
					secondpower.outOfScreen();
				}
			}
		}
	}
	
	
	//paint component will paint the images again n again on the screen
	@Override
	public void paintComponent(Graphics g){
		//It will render the screen again n again calls its super constructor to clear the screen
		super.paintComponent(g);
		//this will  call the printBg method to paint on the screen
		printBg(g);	
		
		player.moves(g);
		player.kick(g);
		player.front(g);
		player.back(g);
		
		secondplayer.movessecond(g);
		secondplayer.kicksecond(g);
		secondplayer.fireballs(g);
		secondplayer.movefront(g);
		secondplayer.moveback(g);
		
		if(isGameOver)
		{
			gameOver(g);
		}
		
		//player will be drawn here 
		//player.drawPlayer(g);
	    
		//secondplayer.drawPlayer(g);
	    
	    /*Use to print the score on the top of the screen
	     * 
	     */
	    //printScore(g);
	    //will paint the powers again n again
	    
	    printPowers(g);
	    printSecondPowers(g);
	    
	    player.Energy(g);
	    secondplayer.EnergyBar(g);
	    
	}

	
	//Used to print the score...here we have defined the score method
	/*
	int score=0;
	private void printScore(Graphics g){
		g.setColor(Color.BLACK);
		g.setFont(new Font("Arial",Font.BOLD,18));
		g.drawString("Power "+score,GAME_WIDTH-100,30);
	}
	*/
	
	
	private void printBg(Graphics g){
		//This drawImage will be draw the image on the board
		g.drawImage(background,0,0,GAME_WIDTH,GAME_HEIGHT,null);
	}
}
