package JoZeeGame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frame extends JFrame implements ActionListener{

	private JButton schliessen;
	private JButton einstellung;
	private JButton info;
	private JButton ende;
	
	public static void main(String[] args){
		
		frame frame = new frame("Menü");
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setSize(400, 400);
		
		frame.setLayout(null);
		frame.setVisible(true);
	}


public frame(String title){
	
	super(title);
	
	schliessen = new JButton("Spiel starten");
	schliessen.setBounds(120,40,160,40);
	schliessen.addActionListener(this);
	add(schliessen);
	
	einstellung = new JButton("Einstellungen");
	einstellung.setBounds(120,120,160,40);
	einstellung.addActionListener(this);
	add(einstellung);
	
	info = new JButton("Credits");
	info.setBounds(120,200,160,40);
	info.addActionListener(this);
	add(info);
	
	ende = new JButton("Ende");
	ende.setBounds(120,280,160,40);
	ende.addActionListener(this);
	add(ende);
	 
}


public static void fenster(){
	
	JFrame fenster = new JFrame();
	fenster.setDefaultCloseOperation(EXIT_ON_CLOSE);
	fenster.setSize/**(1800, 1000)*/(1000,650);
	fenster.setVisible(true);
	fenster.add(new gui());
}

//public static void auswahl(){
	
//}

@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	if(e.getSource()==schliessen){
		fenster();
	}else if(e.getSource()== info){
		Object[] options = { "JoZee"};
		JOptionPane.showOptionDialog(null, "Programmiert von JoZee!","Information",JOptionPane.DEFAULT_OPTION,JOptionPane.PLAIN_MESSAGE,null,options,options[0]);
	}else if(e.getSource()== einstellung){
		//auswah();
	}else if(e.getSource()== ende){
		System.exit(0);
	}
}
}