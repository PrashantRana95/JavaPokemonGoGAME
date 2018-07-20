package com.game;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteLoader {
	BufferedImage img;
	public SpriteLoader(){
		try {
			img=ImageIO.read(SpriteLoader.class.getResource("Blastoise-Sprite.png"));
			
		} 
		catch (Exception e) {
			System.out.println("Can't Load the Player Sprite Image");
		}
	}
	
	//These are the specified portion of that images we need to print in the background
	//BufferedImage[] array type is used here
	////This powerSprite is used for powers mainly
	public BufferedImage[] powerSprite(){
		BufferedImage arr[] = new BufferedImage[4];
		arr[0] = img.getSubimage(724, 283, 71, 67);
		arr[1] = img.getSubimage(650, 286, 72, 64);
		arr[2] = img.getSubimage(484, 292, 83, 58);
		arr[3] = img.getSubimage(257, 281, 71, 69);
		return arr;
			
	}
		
		
		//These moves apply with water gun attack
	public BufferedImage[] moves(){
		
		BufferedImage arr[] = new BufferedImage[4];
		//arr[0] = img.getSubimage(725, 143, 70, 67);
		//arr[1] = img.getSubimage(725, 72, 70, 66);
		//arr[2] = img.getSubimage(496, 212, 74, 67);
		
		arr[0] = img.getSubimage(724, 283, 71, 67);
		
		arr[1] = img.getSubimage(724, 283, 71, 67);
		
		arr[2] = img.getSubimage(724, 283, 71, 67);
		
		arr[3] = img.getSubimage(724, 283, 71, 67);
		
		return arr;
	}
	
	
	//While he walks we need to make another method
	public BufferedImage[] frontwalk(){
		BufferedImage arr[] = new BufferedImage[4];

		arr[0] = img.getSubimage(724, 283, 71, 67);
		arr[1] = img.getSubimage(658, 139, 66, 64);
		arr[2] = img.getSubimage(587, 141, 70, 66);
		arr[3] = img.getSubimage(513, 144, 73, 66);
		
		return arr;
	}
	
	public BufferedImage[] backwardwalk(){
		BufferedImage arr[] = new BufferedImage[4];
		
		arr[0] = img.getSubimage(724, 283, 71, 67);
		arr[1] = img.getSubimage(442, 143, 70, 67);
		arr[2] = img.getSubimage(375, 139, 66, 67);
		arr[3] = img.getSubimage(304, 141, 70, 67);
		return arr;
	}
}
