package JoZeeGame;

public class Sprung extends Thread{
	
	static boolean fertig = true;
	static boolean hochpunkt = false;
	
	int sprunghöhe = 200;
	int ursprungY = 500;
	int sprungPosition = ursprungY;
	
	public Sprung(){
	}

	public int sprungPosition(){
	
		return sprungPosition;
	
	}
	
}
