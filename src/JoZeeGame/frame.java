package JoZeeGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class frame extends JFrame implements ActionListener {

	private JButton start, options, info, exit;

	public static void main(String[] args) {
		//Main menu
		frame frame = new frame("Main menu");
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setSize(400, 400);

		frame.setLayout(null);
		frame.setVisible(true);
	}

	public frame(String title) {

		super(title);
		//starts the real game
		start = new JButton("Play");
		start.setBounds(120, 40, 160, 40);
		start.addActionListener(this);
		add(start);

		options = new JButton("Options");
		options.setBounds(120, 120, 160, 40);
		options.addActionListener(this);
		add(options);

		info = new JButton("Credits");
		info.setBounds(120, 200, 160, 40);
		info.addActionListener(this);
		add(info);

		exit = new JButton("Exit");
		exit.setBounds(120, 280, 160, 40);
		exit.addActionListener(this);
		add(exit);

	}

	public static void window() {
		
		//Game panel
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(EXIT_ON_CLOSE);
		window.setSize(1000, 650);
		window.setVisible(true);
		window.setResizable(false);
		window.add(new Gui());
	}

	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == start) {
			
			window();
		
		}else if (e.getSource() == info) {
			
			Object[] options = { "JoZee" };
			JOptionPane.showOptionDialog(null, "Programmed by JoCorp", "Information", JOptionPane.DEFAULT_OPTION,
			JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
		
		} else if (e.getSource() == options) {
			
			// Not done yet
		
		}else if (e.getSource() == exit) {
			
			System.exit(0);
		}
	}
}