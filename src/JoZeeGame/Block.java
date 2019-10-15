package JoZeeGame;

import java.awt.Color;

public class Block {

	private final int x, y;
	private final int width, height;

	public void setCoins(int coins) {
		this.coins = coins;
	}

	private int coins = 1;
	private final Color color;
	
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
				if (coins != 3){
				coins = 2;
				}
				Jump.highPoint = true;
				return true;
			}else{
				if(x_char -822 <= x_block + width){
					if (coins != 3){
					coins = 2;
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
	
	public int getCoins(){
		return coins;
	}
	}
	

