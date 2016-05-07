package JoZeeGame;

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

public class gui extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//Welt
	Image img;
	//Charakter
	Image img2;
	int key;
	int lauf;
	int X_Bild;
	Timer time;
	//Zur bewegung des Hintergrundbildes notwendig
	int nx, nx2;
	//Zur Bewegung des Charakters notwendig
	int figur_y = 500;
	int left = 0;
	int anzahl = 0;
	int anzahl2 = 0;

	public gui() {
		nx = 0;
		//Größe des Fensters
		nx2 = 1000;

		key = 0;
		lauf = 0;

		setFocusable(true);
		
		ImageIcon u = new ImageIcon(getClass().getResource("/res/background.jpg"));
		
		img = u.getImage();
		
		ImageIcon s = new ImageIcon(getClass().getResource("Bowser_On_Skateboard.png"));
		
		img2 = s.getImage();
		
		addKeyListener(new AL());
		
		Sprung sp = new Sprung();

		time = new Timer(5, this);
		time.start();
	}

	public void actionPerformed(ActionEvent e) {
		bewegen();
		figur_y = Sprung.sprungPosition;
		repaint();

	}

	public void paint(Graphics g) {

		super.paint(g);

		Graphics2D f2 = (Graphics2D) g;
		// 4000= Länge des Bildes x 2
		// 1000=länge des Bildes - länge des Fensters
		if (getXBild() == 1000 + (anzahl * 4000)) {

			anzahl++;
			nx = 0;

		}

		if (getXBild() == 3000 + (anzahl2 * 4000)) {
			anzahl2++;
			nx2 = 0;
		}

		if (getXBild() >= 1000) {
			f2.drawImage(img, 1000 - nx, 0, null);
		}

		f2.drawImage(img, 1000 - nx2, 0, null);
		
		f2.drawImage(img2, left, figur_y,100,100, null);

	}

	public void bewegen() {
		
		if(lauf != -2){
			if(left + lauf <= 300){
				left += lauf;
			}else {
				X_Bild += lauf;
				nx += lauf;
				nx2 += lauf;
			}
		}else{
			if(left + lauf > 0){
				left += lauf;
			}
			
		}
		
		
		
	}

	public int getXBild() {
		return X_Bild;

	}

	private class AL extends KeyAdapter {

		public AL() {

		}

		public void keyPressed(KeyEvent e) {

			key = e.getKeyCode();

			if (key == KeyEvent.VK_RIGHT) {
				lauf = 2;
			} else if (key == KeyEvent.VK_LEFT) {
				lauf = -2;
			}else if(key ==KeyEvent.VK_SPACE){
				Sprung();
			}
		}

		public void keyReleased(KeyEvent e) {

			key = e.getKeyCode();

			if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_RIGHT) {
				lauf = 0;
			}
		}

	}
	public void Sprung(){
		Sprung SprungAnimation = new Sprung();
		SprungAnimation.start();
	}
}
