package waitandnotify;

import java.util.List;

public class Waiter extends Thread {
	
private List<Order> restorder;



//passing in the arraylist into the constructor
public Waiter(List<Order> restorder) {
	
	this.restorder = restorder;
}
//run method to start the thread
	public void run(){
		
		
		
		for(Order ordermade: restorder) { 
			
			synchronized(restorder) {
				
				//
				System.out.println("Your order has been taken: " + ordermade.getMyOrder());
				Chef cater = new Chef(restorder); //creating instance of chef and passing in arraylist
				
				cater.start();  // starting the chef thread
				try {
					ordermade.wait(3000);  // order object waiting for 3 seconds
				}catch(InterruptedException e) {
					
					e.printStackTrace();
					
				}// if statement to print what should be done when the order has finished
				if(ordermade.hasFinished()) {  
					
					System.out.println("Your order " + ordermade.getMyOrder() + " is ready for you");
				}
				else{
					System.out.println("Your order " + ordermade.getMyOrder() + " is not ready for you ");
				}
				
				
			}
			
			
		}
		
		
	}
}
