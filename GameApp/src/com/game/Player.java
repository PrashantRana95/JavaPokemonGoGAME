package com.game;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Player extends Sprite{
	
	
	//ArrayList created because of unlimited bullets feature
		//ArrayList is created of type class Power and named it with powerList
		private ArrayList<Powers> powerList = new ArrayList<>();
		
		//Then after creating the powerlList setters and getters are been made
		public ArrayList<Powers> getPowerList() {
			return powerList;
		}
		//to set the value of powerList
		public void setPowerList(ArrayList<Powers> powerList) {
			this.powerList = powerList;
		}
	
	//Default constructor is created
	public Player(){
		
		x=177;
		h=90;
		w=110;
		y= FLOOR - (h-10);
		img=new ImageIcon(Player.class.getResource(PLAYER_IMG)).getImage();
	}
	final int GRAVITY=1;
	//acc=acceleration of the player
	int acc;
	
	//This health is equivalent to the width and we need to decrease the width each time collision happens
//	int health = 200;
//	public void Energy(Graphics g){
//		g.setFont(new Font ("Berlin Sans FB Demi",Font.BOLD,20));
//		g.drawString("ENERGY", GAME_WIDTH - 1060, 110);
//		g.setColor(Color.RED);
//		g.fillRect(190, 115, health, 30);
//	}
	
	
	int health = 200;
	public void Energy(Graphics g){
		img=new ImageIcon(Player.class.getResource(GAME_ENERGY)).getImage();
		g.drawImage(img, 190, 115, health, 50, null);
		img=new ImageIcon(Player.class.getResource("WaterLogo.png")).getImage();
		g.drawImage(img, 147, 115, 50, 50, null);
		
		img=new ImageIcon(Player.class.getResource(GAME_TEXT)).getImage();
		g.drawImage(img, 220, 66, 130, 60, null);
		
	}
	
	
	
	//fire method creates to fire the power from player Blastoise
	public void fire(){
		//Object created 
		Powers power = new Powers(x+w/4,y+h/4);
		powerList.add(power);
	}
	
	boolean isKick ;
	int index = 0;
	public void doKick(){
		isKick = true;
		currentMove = 0;
		index = 0;
	}
	boolean isIce ;
	public void doIce(){
		isIce = true;
		currentMove = 1;
		index = 0;
	}
	
	
	boolean isWalk ;
	public void doWalk(){
		isWalk = true;
		currentMove = 2;
		index =0;
	}
	
	boolean isBack ;
	public void doBack(){
		isBack = true;
		currentMove = 3;
		index = 0;
	}
	
	int currentMove ;
	SpriteLoader sl = new SpriteLoader();
	BufferedImage arrofkicks[] = sl.powerSprite();
	BufferedImage arrofMoves[] = sl.moves();
	BufferedImage arrofFrontWalks[] = sl.frontwalk();
	BufferedImage arrofBackWalks[] = sl.backwardwalk();
	public void moves(Graphics g){
			if(currentMove ==0){
			 g.drawImage(arrofMoves[index], x, y, w,h,null);
			 //System.out.println(index);
			 index++;
			}
		 
		 if(index>4){
			 currentMove = 0;
			 index = 0;
		 }
	}
	
	public void kick(Graphics g){
		 if(currentMove==1){
			 g.drawImage(arrofkicks[index], x, y, w,h,null);
			 //System.out.println(index);
			 index++;
		 }
		 if(index>3){
			currentMove = 0;
			 index = 0;
		 }
	}
	
	public void front(Graphics g){
		if(currentMove==2){
			g.drawImage(arrofFrontWalks[index], x, y, w,h,null);
			//System.out.println(index);
			index++;
		}
		if(index>=4){
			currentMove = 0;
			index = 0;
		}
	}
	
	public void back(Graphics g){
		if(currentMove==3){
			g.drawImage(arrofBackWalks[index], x, y, w,h,null);
		    //System.out.println(index);
			index++;
		}
		if(index>=4){
			currentMove = 0;
			index = 0;
		}
	}
	
	
	private boolean isJump = false;
	//This will allows the player to jump from its position
	public void jump(){
		if(!isJump){
		acc= -17   ;
		y = y + acc;
		isJump = true;
		}
	}
	
	//After jumping it needs to be fall back to the floor
	public void fall(){
		if(y<FLOOR - (h-20)){
		acc =  acc + GRAVITY;
		y = y + acc;
		}
		if(y>=FLOOR - (h-20)){
			isJump =false;
		}
	}
	
	
	public void move(){
		x +=speed;
	}
	
	//Used to drawn the player image 
	public void drawPlayer(Graphics g){
		g.drawImage(img, x, y, w, h, null);
	}
}
