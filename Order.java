package waitandnotify;

public class Order {

//Declaring String and Boolean Variables
	private String myorder;
	private boolean finished;
	
	
	//Get and set methods to return the output
	public Order(String myorder) {
		
		this.myorder = myorder;
		this.finished = false;
	}
	
	public String getMyOrder() {
		return myorder;
	}
	
	public boolean hasFinished() {
		return finished;
	}
	
	public void setFinished(boolean finished) {
		this.finished = finished;
	}
	
}
