package JoZeeGame;

import java.awt.Color;

public class Block {

	final int x, y;
	final int width, height;
	int coin = 1;
	final Color color;
	
	public Block (int p_x, int p_y, int p_width, int p_height, Color p_color){
		
		x = p_x;
		y = p_y;
		width = p_width;
		height = p_height;
		color = p_color;
	}
	
	public boolean collisionDetection (int x_block, int y_block, int x_char, int y_char){
		if (x_char >= x_block && y_char >= y_block && y_char <= y_block+height){
			if(x_char <= x_block+width){
				if (coin != 3){
				coin = 2;
				}
				Jump.highPoint = true;
				return true;
			}else{
				if(x_char -822 <= x_block + width){
					if (coin != 3){
					coin = 2;
					}
					return true;
				}
			}
			}else{
				return false;
			
		}
		return false;
	}
	
	public int getX_Block(){
		return x;
	}
	
	public int getY_Block(){
		return y;
	}
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}
	
	public Color getColor(){
		return color;
	}
	
	public int getCoin(){
		return coin;
	}
	}
	

