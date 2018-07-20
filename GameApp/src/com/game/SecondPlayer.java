package com.game;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class SecondPlayer extends Sprite{
	
	private ArrayList<SecondPower> secondpowerList = new ArrayList<>();
	
	
	public ArrayList<SecondPower> getSecondpowerList() {
		return secondpowerList;
	}

	public void setSecondpowerList(ArrayList<SecondPower> secondpowerList) {
		this.secondpowerList = secondpowerList;
	}
	
	

	public SecondPlayer(){
		
		x=950;
		h=130;
		w=180;
		y=445-(h-7);
		img=new ImageIcon(Player.class.getResource(SECOND_PLAYER_IMG)).getImage();
	}
	final int GRAVITY=1;
	int acc;
	
	
//	int energy = 200;
//	public void EnergyBar(Graphics g){
//		g.setFont(new Font ("Berlin Sans FB Demi",Font.BOLD,20));
//		g.drawString("ENERGY", GAME_WIDTH - 400, 110);
//		g.setColor(Color.GREEN);
//		g.fillRect(850, 115, energy, 30);
//	}
//	
	int energy = 200;
	public void EnergyBar(Graphics g){
		img=new ImageIcon(Player.class.getResource(GAME_ENERGY)).getImage();
		g.drawImage(img, 863, 115, energy, 50, null);
		img=new ImageIcon(Player.class.getResource("FireLogo.png")).getImage();
		g.drawImage(img, 820, 117, 50, 50, null);
		
		img=new ImageIcon(Player.class.getResource(GAME_TEXT)).getImage();
		g.drawImage(img, 883, 66, 130, 60, null);
		
	}
	
	
	
	
	//fire method creates to fire the power from player Blastoise
	public void fire(){
		//Obj created 
		SecondPower secondpower = new SecondPower(x+w/4,y+h/4);
		secondpowerList.add(secondpower);
	}
	
	boolean isAir ;
	int index = 0;
	public void doAir(){
		isAir = true;
		currentMove = 0;
		index = 0;
	}
	boolean isFlys ;
	public void doFly(){
		isFlys = true;
		currentMove = 1;
		index = 0;	}
	
	boolean isFireSpin ;
	public void doFireSpin(){
		isFireSpin = true;
		currentMove = 2;
		index = 0;
	}
	
	boolean isMoveFront ;
	public void doMoveFront(){
		isMoveFront = true;
		currentMove = 3;
		index = 0;
	}
	
	boolean isMoveBack ;
	public void doMoveBack(){
		isMoveBack = true;
		currentMove = 4;
		index = 0;
	}
	
	
	
	int currentMove ;
	SpriteLoader2 sl = new SpriteLoader2();
	BufferedImage arrofFlying[] = sl.powerair();
	BufferedImage arrofMoves[] = sl.moving();
	BufferedImage arrofFires[] = sl.firespin();
	BufferedImage arrofMoveFront[] = sl.movefront();
	BufferedImage arrofMoveBack[] = sl.moveback();
	
	
	int moveSecondIndex =0;
	public void movessecond(Graphics g){
			if(currentMove ==0){
			 g.drawImage(arrofMoves[moveSecondIndex], x, y, w, h, null);
			 //System.out.println(index);
			 moveSecondIndex++;
			}
		 
		 if(moveSecondIndex>=2){
			 currentMove = 0;
			 moveSecondIndex = 0;
		 }
	}
	
	public void kicksecond(Graphics g){
		//System.out.println("Kick Call "+index+" "+currentMove);
		 if(currentMove==1){
			 g.drawImage(arrofFlying[index], x, y, w,h,null);
			 //System.out.println(index+" "+currentMove);
			 index++;
		 }
		 if(index>=5){
			 currentMove = 0;
			 index = 0;
		 }
	}
	
	public void fireballs(Graphics g){
		if(currentMove==2){
			g.drawImage(arrofFires[index], x, y, w, h, null);
			//System.out.println(index);
			index++;
		}
		if(index>=5){
			currentMove = 0 ;
			index = 0 ;
		}
	}
	
	
	public void movefront(Graphics g){
		if(currentMove==3){
			g.drawImage(arrofMoveFront[index],x,y,w,h,null);
			index++;
		}
		if(index>=5){
			currentMove = 0;
			index = 0 ;
		}
	}
	
	public void moveback(Graphics g){
		if(currentMove==4){
			g.drawImage(arrofMoveBack[index], x, y, w, h, null);
			index++;
		}
		if(index>=5){
			currentMove = 0;
			index = 0;
		}
		
	}
		
		
	/*
	private boolean isJump = false;
	//This will allows the player to jump from its position
	public void jump(){
		if(!isJump){
		acc= -25;
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
	
	*/
	private boolean isFly=false;
	
	public void fly(){
		if(!isFly){
			acc = -17;
			y = y + acc;
			//x = x - 50;
			isFly = true;
		}
	}
	
	public void fall(){
		if(y<FLOOR - (h-20)){
			acc = acc + GRAVITY;
			y = y + acc;
		}
		if(y>=FLOOR - (h-20)){
			isFly = false;
		}
	}
	
	public void move(){
		x -=speed;
	}
	
	public void drawPlayer(Graphics g){
		g.drawImage(img, x, y, w, h, null);
	}
}
