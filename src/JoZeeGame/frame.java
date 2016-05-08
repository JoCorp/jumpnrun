package JoZeeGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class frame extends JFrame implements ActionListener {

	private JButton schliessen, einstellung, info, ende;

	public static void main(String[] args) {
		//Hauptmenü
		frame frame = new frame("Menü");
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setSize(400, 400);

		frame.setLayout(null);
		frame.setVisible(true);
	}

	public frame(String title) {

		super(title);
		//startet eigentlich das Spiel
		schliessen = new JButton("Spiel starten");
		schliessen.setBounds(120, 40, 160, 40);
		schliessen.addActionListener(this);
		add(schliessen);

		einstellung = new JButton("Einstellungen");
		einstellung.setBounds(120, 120, 160, 40);
		einstellung.addActionListener(this);
		add(einstellung);

		info = new JButton("Credits");
		info.setBounds(120, 200, 160, 40);
		info.addActionListener(this);
		add(info);

		ende = new JButton("Ende");
		ende.setBounds(120, 280, 160, 40);
		ende.addActionListener(this);
		add(ende);

	}

	public static void fenster() {
		
		//SpielFenster
		JFrame fenster = new JFrame();
		fenster.setDefaultCloseOperation(EXIT_ON_CLOSE);
		fenster.setSize(1000, 650);
		fenster.setVisible(true);
		fenster.setResizable(false);
		fenster.add(new gui());
	}

	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == schliessen) {
			
			fenster();
		
		}else if (e.getSource() == info) {
			
			Object[] options = { "JoZee" };
			JOptionPane.showOptionDialog(null, "Programmiert von JoZee!", "Information", JOptionPane.DEFAULT_OPTION,
			JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
		
		} else if (e.getSource() == einstellung) {
			
			// auswahl();
		
		}else if (e.getSource() == ende) {
			
			System.exit(0);
		}
	}
}