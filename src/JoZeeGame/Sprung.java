package JoZeeGame;

public class Sprung extends Thread{
	
	static boolean fertig = true;
	static boolean hochpunkt = false;
	
	int sprungh�he = 100;
	static int ursprungY = 500;
	static int sprungPosition = ursprungY;
	
	public Sprung(){
	}

	public void run(){
		fertig = false;
		int verz�gerung = 20;
		while(fertig == false){
			Jump();
			
			try{
				Thread.sleep(verz�gerung);
			}catch(Exception e){
				
			}
			
		}
		hochpunkt = false;
		
	}

	public void Jump(){
		if(hochpunkt == false){
			sprungPosition -= 10;
		}
		if(sprungPosition == ursprungY-sprungh�he){
			hochpunkt = true;
		}
		
		if(hochpunkt == true && sprungPosition <= ursprungY){
			sprungPosition += 10;
			if(sprungPosition == ursprungY){
				fertig = true;
			}
		}
		
	}

}
	

