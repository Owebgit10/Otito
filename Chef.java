package waitandnotify;

import java.util.List;

public class Chef extends Thread{

	
	private Order ordermade;
	
	List<Order> restorder;  // declaring the arraylist
	public Chef(List<Order> restorder) {
		
		this.restorder = restorder;
	}
	//creating run method where the thread will run
	public void run() {
		
		//getting the order placed and printing something
		System.out.println(ordermade.getMyOrder() + " is currently being made");
		try {
			sleep(3000); // thread sleeping for seconds
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		synchronized(restorder) {   // synchronizing the arratlist
			ordermade.setFinished(true);
			System.out.println("Your order " + ordermade.getMyOrder() + " is now ready ");
			
			// notifying when the order is ready
			ordermade.notify();
		}
	}
	
}
