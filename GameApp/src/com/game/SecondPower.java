package com.game;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;

public class SecondPower extends Sprite{
	private boolean isVisible;
	
	
	//Setters and getters are used for this boolean variable
	public boolean isVisible() {
		return isVisible;
	}

	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}
	
	
	//power constructor is created here then 
	public SecondPower(int x, int y){
		this.x = x;
		this.y = y;
		this.speed=6;
		this.h = 40;
		this.w = 60;
		isVisible= true;
		img = new ImageIcon(Powers.class.getResource(POWER_FIRE)).getImage();
		//img = new ImageIcon(Powers.class.getResource(POWER_ICE)).getImage();
	}
	
	
	/*public void drawPowers(Graphics g){
		g.setColor(Color.ORANGE);
		g.fillOval(x, y, w, h);
	}
	*/
	
	public void move(){
		x -=speed;
	}
	
	public void outOfScreen(){
		if(x>=GAME_WIDTH){
			isVisible=false;
		}
	}
	
	public void drawPowers(Graphics g){
		g.drawImage(img, x, y, w, h, null);
	}
}
