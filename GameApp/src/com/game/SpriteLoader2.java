package com.game;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class SpriteLoader2 {
	BufferedImage img;
	public SpriteLoader2(){
		try {
			img=ImageIO.read(SpriteLoader.class.getResource("Charizard Sprite.png"));
			
		} 
		catch (Exception e) {
			System.out.println("Can't Load the Player Sprite Image");
		}
	}
	
	//These are the specified portion of that images we need to print in the background
	//BufferedImage[] array type is used here
	////This powerSprite is used for powers mainly
	public BufferedImage[] powerair(){
		
		//These will be performed with jump
		BufferedImage arr[] = new BufferedImage[6];
		arr[0] = img.getSubimage(3, 254, 104, 78);
		arr[1] = img.getSubimage(196, 246, 85, 86);
		arr[2] = img.getSubimage(1, 172, 124, 73);
		arr[3] = img.getSubimage(126, 168, 123, 65);
		arr[4] = img.getSubimage(251, 168, 129, 63);
		arr[5] = img.getSubimage(381, 177, 129, 52);
		return arr;
			
	}
		
		
		//These moves apply with fire attacks attack
	public BufferedImage[] moving(){
		
		BufferedImage arr[] = new BufferedImage[3];
		arr[0] = img.getSubimage(107, 504, 93, 82);
		arr[1] = img.getSubimage(107, 504, 93, 82);
		arr[2] = img.getSubimage(107, 504, 93, 82);
		
		
		return arr;
	}
	
	
	
	//This is used when Charizard fires
	public BufferedImage[] firespin(){
		
		BufferedImage arr[] = new BufferedImage[6];
		arr[0] = img.getSubimage(1, 424, 115, 76);
		arr[1] = img.getSubimage(636, 427, 121, 73);
		arr[2] = img.getSubimage(507, 425, 128, 75);
		arr[3] = img.getSubimage(377, 425, 129, 75);
		arr[4] = img.getSubimage(243, 425, 130, 75);
		arr[5] = img.getSubimage(117, 427, 125, 73);
		
		return arr;
	}
	
	public BufferedImage[] movefront(){
		BufferedImage arr[] = new BufferedImage[6];
		arr[0] = img.getSubimage(1, 424, 115, 76);
		arr[1] = img.getSubimage(117, 3, 119, 76);
		arr[2] = img.getSubimage(590, 1, 111, 78);
		arr[3] = img.getSubimage(563, 256, 116, 76);
		
		return arr;
	}
	
	
	public BufferedImage[] moveback(){
		BufferedImage arr[] = new BufferedImage[6];
		arr[0] = img.getSubimage(1, 424, 115, 76);
		arr[1] = img.getSubimage(491, 510, 117, 76);
		arr[2] = img.getSubimage(609, 513, 121, 73);
		
		return arr;
	}

}
