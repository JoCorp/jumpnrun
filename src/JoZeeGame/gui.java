package JoZeeGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Gui extends JPanel implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	//World and Character
	Image img, img2;
	//Necessary to move the background
	int key, run, x_picture, nx, nx2;
	Timer time;
	//Necessary to move the Character
	int figur_y = 500;
	int left, ammount, ammount2 = 0;
	
	Block block1;
	int coin_score;
	public Gui() {
		
		nx = 0;
		//Length of the window = 1000 = nx2
		nx2 = 1000;
		key = 0;
		run = 0;

		setFocusable(true);
		
		ImageIcon u = new ImageIcon(getClass().getResource("/res/background.jpg"));
		img = u.getImage();
		
		ImageIcon s = new ImageIcon(getClass().getResource("/res/Bowser_On_Skateboard.png"));
		img2 = s.getImage();
		
		addKeyListener(new AL());
		
		block1 = new Block(250,330,50,50, Color.GREEN);
		

		time = new Timer(5, this);
		time.start();
	}

	public void actionPerformed(ActionEvent e) {
		move();
		figur_y = Jump.jumpPosition;
		repaint();

	}

	public void paint(Graphics g) {

		super.paint(g);

		Graphics2D f2 = (Graphics2D) g;
		// 4000 = Background-length x 2
		// 1000 = Background length - Length of the window
		if (getXBild() == 1000 + (ammount * 4000)) {

			ammount++;
			nx = 0;

		}

		if (getXBild() == 3000 + (ammount2 * 4000)) {
			
			ammount2++;
			nx2 = 0;
		}

		if (getXBild() >= 1000) {
			f2.drawImage(img, 1000 - nx, 0, null);
		
		}
		
		f2.drawImage(img, 1000 - nx2, 0, null);
		f2.drawImage(img2, left, figur_y,100,100, null);
		f2.setColor(block1.getColor());
		f2.fillRect(block1.getX_Block()-getXBild(),block1.getY_Block(), block1.getWidth(),block1.getHeight());

		block1.collisionDetection(block1.getX_Block()-getXBild(), block1.getY_Block()+ block1.getHeight(),left +50, figur_y);
		if(block1.getCoin() == 2){
			coin_score = coin_score + 1;
			block1.coin = 3;
		}
		f2.drawString("Score : " +coin_score,  10, 15);
	}

	public void move() {
		
		if(run != -2){
			
			if(left + run <= 300){
				
				left += run;
			
			}else{
				
				x_picture += run;
				nx += run;
				
				nx2 += run;
			
			}
		
		}else{
			
			if(left + run > 0){
				
				left += run;
			
			}
			
		}
		
		
		
	}

	public int getXBild() {
		return x_picture;

	}

	private class AL extends KeyAdapter {

		public AL() {

		}

		public void keyPressed(KeyEvent e) {

			key = e.getKeyCode();

			if (key == KeyEvent.VK_RIGHT) {
				run = 2;
			} else if (key == KeyEvent.VK_LEFT) {
				run = -2;
			}else if(key ==KeyEvent.VK_UP){
				jump();
			}
		}

		public void keyReleased(KeyEvent e) {

			key = e.getKeyCode();

			if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_RIGHT) {
				run = 0;
			}
		}

	}
	public void jump(){
		Jump jumpAnimation = new Jump();
		jumpAnimation.start();
	}
}
