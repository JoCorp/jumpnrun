package JoZeeGame;

import javafx.geometry.Point2D;

import javax.swing.*;
import java.awt.*;

public class Character {

    public IntPoint position = new IntPoint(500,0);
    private final Image characterImg;

    public Character() {
        ImageIcon s = new ImageIcon(getClass().getResource("/res/Bowser_On_Skateboard.png"));
        characterImg = s.getImage();
    }

    public void draw(Graphics2D graphics2D) {
        graphics2D.drawImage(characterImg, position.getX(), position.getY(), 100, 100, null);
    }
}
