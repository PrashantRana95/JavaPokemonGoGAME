package com.game;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Powers extends Sprite{
	
	//Boolean variable is taken here for visibilty
	//This is by default sets to false
	//As boolean variables default value is False
	private boolean isVisible;
	
	
	//Setters and getters are used for this boolean variable
	public boolean isVisible() {
		return isVisible;
	}

	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}
	
	//power constructor is created here then 
	public Powers(int x, int y){
		//this.x=x;
		//this.y=y;
		this.x = x;
		this.y = y;
		this.speed=10;
		this.h = 30;
		this.w = 40;
		isVisible= true;
		//Used to put the image in the board 
		img=new ImageIcon(Powers.class.getResource(POWER_ICE)).getImage();
		
		}
	
	/*public Powers(){
		this.x = x;
		this.y = y;
		this.speed=10;
		this.h = 30;
		this.w = 40;
		isVisible= true;
		
		secondimg=new ImageIcon(Powers.class.getResource(POWER_FIRE)).getImage();
		
	}*/
	
	/*
	public void drawPowers(Graphics g){
		g.setColor(Color.ORANGE);
		g.fillOval(x, y, w, h);
	}
	*/
	
	public void move(){
		x +=speed;
	}
	
	public void outOfScreen(){
		if(x>=GAME_WIDTH){
			isVisible=false;
		}
	}

	public void drawPowers(Graphics g){
		g.drawImage(img, x, y, w, h, null);
	}

	public void drawPowersWaterGun(Graphics g){
		g.drawImage(secondimg, x, y, w, h, null);
	}
	
}
