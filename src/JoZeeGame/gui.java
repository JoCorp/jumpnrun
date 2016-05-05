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

	Image img;
	int key;
	int lauf;
	int X_Bild;
	Timer time;
	int nx, nx2;

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
		addKeyListener(new AL());

		time = new Timer(5, this);
		time.start();
	}

	public void actionPerformed(ActionEvent e) {
		bewegen();
		repaint();

	}

	public void paint(Graphics g) {

		super.paint(g);

		Graphics2D f2 = (Graphics2D) g;
		// 4000= Länge des Bildes x 2
		// länge des Bildes - länge des Fensters
		if (getXBild() == 1000 + (anzahl * 4000)) {

			anzahl += 1;
			nx = 0;

		}

		if (getXBild() == 3000 + (anzahl2 * 4000)) {
			anzahl2 += 1;
			nx2 = 0;
		}

		if (getXBild() >= 1000) {
			f2.drawImage(img, 1000 - nx, 0, null);
		}

		f2.drawImage(img, 1000 - nx2, 0, null);

		// f2.drawImage(img, 0, 0, 1708, 800, 0, 0, 3881, 1817, null);
	}

	public void bewegen() {
		X_Bild += lauf;
		nx += lauf;
		nx2 += lauf;
	}

	public int getXBild() {
		return X_Bild;

	}

	private class AL extends KeyAdapter {

		public AL() {

		}

		public void keyPressed(KeyEvent e) {

			key = e.getKeyCode();

			if (key == KeyEvent.VK_LEFT) {
				lauf = 2;
			} else if (key == KeyEvent.VK_RIGHT) {
				lauf = -2;

			}
		}

		public void keyReleased(KeyEvent e) {

			key = e.getKeyCode();

			if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_RIGHT) {
				lauf = 0;
			}
		}

	}
}
