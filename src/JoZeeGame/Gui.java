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

    //World and Character
    private final Image backgroundImg;
    private final Character character = new Character();

    //Background positioning
    private int run, backgroundOffset, nx, nx2 = 1000;

    private int ammount, ammount2 = 0;

    private Block block1;
    private int coinScore;

    public Gui() {

        setFocusable(true);

        ImageIcon u = new ImageIcon(getClass().getResource("/res/background.jpg"));
        backgroundImg = u.getImage();


        addKeyListener(new AL());

        block1 = new Block(250, 330, 50, 50, Color.RED);


        Timer time = new Timer(5, this);
        time.start();
    }

    public void actionPerformed(ActionEvent e) {
        move();
        character.position.setY(Jump.jumpPosition);
        repaint();
    }

    public void paint(Graphics g) {

        super.paint(g);

        Graphics2D graphics = (Graphics2D) g;
        if (backgroundOffset == 1000 + (ammount * 4000)) {
            ammount++;
            nx = 0;
        }

        if (backgroundOffset == 3000 + (ammount2 * 4000)) {
            ammount2++;
            nx2 = 0;
        }

        if (backgroundOffset >= 1000) {
            graphics.drawImage(backgroundImg, 1000 - nx, 0, null);
        }

        graphics.drawImage(backgroundImg, 1000 - nx2, 0, null);

        character.draw(graphics);

        graphics.setColor(block1.getColor());
        graphics.fillRect(block1.getX_Block() - backgroundOffset,
                block1.getY_Block(),
                block1.getWidth(),
                block1.getHeight());

        block1.collisionDetection(block1.getX_Block() - backgroundOffset,
                block1.getY_Block() + block1.getHeight(),
                character.position.getX() + 50,
                character.position.getY());
        if (block1.getCoins() == 2) {
            coinScore = coinScore + 1;
            block1.setCoins(3);
        }
        graphics.drawString("Score : " + coinScore, 10, 15);
    }

    private void move() {

        if (run != -2) {
            if (character.position.getX() + run <= 300) {
                character.position.addX(run);
            } else {
                backgroundOffset += run;
                nx += run;
                nx2 += run;
            }
        } else {
            if (character.position.getX() + run > 0) {
                character.position.addX(run);
            }
        }
    }

    private class AL extends KeyAdapter {

        int key;

        public void keyPressed(KeyEvent e) {

            key = e.getKeyCode();

            if (key == KeyEvent.VK_RIGHT) {
                run = 2;
            } else if (key == KeyEvent.VK_LEFT) {
                run = -2;
            } else if (key == KeyEvent.VK_UP) {
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

    public void jump() {
        Jump jumpAnimation = new Jump();
        jumpAnimation.start();
    }
}
