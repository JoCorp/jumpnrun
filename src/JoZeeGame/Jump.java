package JoZeeGame;

public class Jump extends Thread{
	
	static boolean done = true;
	static boolean highPoint = false;
	static int originalY = 500;
	static int jumpPosition = originalY;
	int jumpHeight = 150;
	
	public Jump(){
	
	}

	public void run(){
		
		done = false;
		int delay = 20;
		
		while(done == false){
			
			jump();
			
			try{
				
				Thread.sleep(delay);
			
			}catch(Exception e){
				
			}
			
		}
		
		highPoint = false;
	}

	public void jump(){
		
		if(highPoint == false){
			
			jumpPosition -= 10;
		
		}
		
		if(jumpPosition == originalY-jumpHeight){
			
			highPoint = true;
		}
		
		if(highPoint == true && jumpPosition <= originalY){
			
			jumpPosition += 10;
			
			if(jumpPosition == originalY){
				
				done = true;
			}
		}
		
	}

}
	

