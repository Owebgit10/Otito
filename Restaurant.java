package waitandnotify;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class Restaurant {
	

	
	
	
	public Restaurant () {
		
	

			
		
	}

	public static void main(String[] args) {
		
		List<Order >restorder = new ArrayList<>();  //declaring arraylist
		

		// Creating JFrame and giving it a title
		JFrame RestaurantOrder = new JFrame();
		RestaurantOrder.setTitle("Order a Three-Course-Meal");
		RestaurantOrder.setLayout(new BorderLayout());
		
		
		
		
		//MENU TO ORDER AN APPETIZER
		JMenu appetizer = new JMenu("APPETIZER");
		
		
		// Radio button showing Appetizer options
		ButtonGroup Appgroup = new ButtonGroup();
		JRadioButton radioApp1 = new JRadioButton("Soup & Scone");
Appgroup.add(radioApp1);
	appetizer.add(radioApp1);
		
		JRadioButton radioApp2 = new JRadioButton("Sausage roll");
		Appgroup.add(radioApp2);
		appetizer.add(radioApp2);
		

		JRadioButton radioApp3 = new JRadioButton("Bread sticks");
		Appgroup.add(radioApp3);
		appetizer.add(radioApp3);
		
		
		
		
		//MENU TO ORDER A MAIN MEAL
		JMenu mainmeal = new JMenu("MAIN-MEAL");
		
		
		//Radio button to choose one side from main meal Menu
		
		ButtonGroup mainsidegroup = new ButtonGroup();
		JRadioButton radiomainsideA = new JRadioButton("Chips");
	mainsidegroup.add(radiomainsideA);
	mainmeal.add(radiomainsideA);
		
		JRadioButton radiomainsideB = new JRadioButton("Wedges");
		mainsidegroup.add(radiomainsideB);
		mainmeal.add(radiomainsideB);
		

		JRadioButton radiomainsideC = new JRadioButton("Goujons");
		mainsidegroup.add(radiomainsideC);
		mainmeal.add(radiomainsideC);
		
		
		
		//separator to separate the checkbox and the radiobutton
		mainmeal.addSeparator();
		
		
		//RadioButton to choose one Drink from MainMeal Menu
		
		ButtonGroup maindrinkgroup = new ButtonGroup();
		JRadioButton radiomaindrinkA = new JRadioButton("Fanta");
	maindrinkgroup.add(radiomaindrinkA);
	mainmeal.add(radiomaindrinkA);
		
		JRadioButton radiomaindrinkB = new JRadioButton("Coke");
		maindrinkgroup.add(radiomaindrinkB);
		mainmeal.add(radiomaindrinkB);
		

		JRadioButton radiomaindrinkC = new JRadioButton("7UP");
		maindrinkgroup.add(radiomaindrinkC);
		mainmeal.add(radiomaindrinkC);
		
		
		
		//Adding a separator between the radiobutton and checkbox
		
		mainmeal.addSeparator();
		
		
		
		/*Note: For checkBox you may need to go back 
		 * into the menu as it exits it when you click a CheckBox
		 */
		
		
		//CheckBox to any Meal from Main Meal Menu
		
		 JCheckBoxMenuItem mainorder1 = new JCheckBoxMenuItem("Steak");
		 mainmeal.add(mainorder1);
		 
		 JCheckBoxMenuItem mainorder2 = new JCheckBoxMenuItem("Pizza");
		mainmeal.add(mainorder2);
		 
		 JCheckBoxMenuItem mainorder3 = new JCheckBoxMenuItem("Burger");
		 mainmeal.add(mainorder3);
		
		
		
		 
		 
		//MENU FOR ORDERING A DESSERT
		JMenu Dessert = new JMenu("DESSERT");
		
	
		//Radiobutton to choose one dessert from Dessert Menu
		
		ButtonGroup dessertbuttongroup = new ButtonGroup();
		JRadioButton radiodessertA = new JRadioButton("Vanilla Milkshake");
		dessertbuttongroup.add(radiodessertA);
		Dessert.add(radiodessertA);
		
		JRadioButton radiodessertB = new JRadioButton("Strawberry Milkshake");
		dessertbuttongroup.add(radiodessertB);
		Dessert.add(radiodessertB);
		

		JRadioButton radiodessertC = new JRadioButton("Chocolate Milkshake");
		dessertbuttongroup.add(radiodessertC);
		Dessert.add(radiodessertC);
		

		JRadioButton radiodessertd = new JRadioButton("Ice Cream");
		dessertbuttongroup.add(radiodessertd);
		Dessert.add(radiodessertd);
		
		
		Dessert.addSeparator();
		
		
		
		
	/*Note: For checkBox you may need to go back 
	 * into the menu as it exits it when you click a CheckBox
	 */
		
		
		// CheckBox to pick any dessert from Dessert menu
		
 JCheckBoxMenuItem dessert1 = new JCheckBoxMenuItem("Chocolate brownie");
 Dessert.add(dessert1);
 
 JCheckBoxMenuItem dessert2 = new JCheckBoxMenuItem("Muffin");
 Dessert.add(dessert2);
 
 JCheckBoxMenuItem dessert3 = new JCheckBoxMenuItem("Waffles");
 Dessert.add(dessert3);
 
	
		
		
		
		//Menu bar to add each Menu 
		JMenuBar coursebar = new JMenuBar();
		
		coursebar.add(appetizer);
		coursebar.add(mainmeal);
		coursebar.add(Dessert);
		
		
		RestaurantOrder.setJMenuBar(coursebar);
		
	//Creating textArea and button to display order
		
		JPanel panel1 = new JPanel(new BorderLayout());
		RestaurantOrder.add(panel1, "Center");
		
		JLabel orderlabel = new JLabel("Here is your order");
		JTextArea displayorder = new JTextArea();
		displayorder.setEditable(false);
	
		JButton orderbutton = new JButton("Place order");
		
		panel1.add(orderlabel, "North");
	panel1.add(displayorder, "Center");
	panel1.add(orderbutton, "South");

		

		//setting the size of the JFrame
		
		RestaurantOrder.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		RestaurantOrder.setSize(450,450);
		RestaurantOrder.setVisible(true);
		
		//creating the wait thread

		Thread waiting = new Thread(() -> {
            while(true) {
                synchronized(restorder) {  // synchronizing on the arraylist
                    try {
                        restorder.wait();      //placing wait on the arraylist
                        Thread.sleep(3000);    // sleep for 3 seconds before notifying order is ready
                        JOptionPane.showMessageDialog(RestaurantOrder, "Order" /*myorder*/ + "is complete!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });
        waiting.start();
		
		
		orderbutton.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				 synchronized(restorder) {
	                  
	                    restorder.notify(); // notifying that the order in the collection is ready
	                }

				String myorder = ""; //printing text depending on which item is being ordered

				if (radioApp1.isSelected())
				{
					myorder = myorder+ "Your ordeer [" +radioApp1.getText()+"] has been added!\n";
					
				}
				if (radioApp2.isSelected())
				{
					myorder = myorder + "\"Your ordeer [" +radioApp2.getText()+"] has been added!\n";
					
				}
				if (radioApp3.isSelected())
				{
					myorder = myorder + "\"Your ordeer [" +radioApp3.getText()+"] has been added!";
					
				}
				if (radiomainsideA.isSelected())
				{
					myorder = myorder+ "Your ordeer [" +radiomainsideA.getText()+"] has been added!";
					
				}
				if (radiomainsideB.isSelected())
				{
					myorder = myorder + "\"Your ordeer [" +radiomainsideB.getText()+"]has been added!";
					
				}
				if (radiomainsideC.isSelected())
				{
					myorder = myorder + "\"Your ordeer [" +radiomainsideC.getText()+"]has been added!\n";
					
				}
				
				//printing text depending on which item is being ordered

				
				
				if (radiomaindrinkA.isSelected())
				{
					myorder = myorder+ "Your ordeer [" +radiomaindrinkA.getText()+"] has been added!\n";
					
				}
				if (radiomaindrinkB.isSelected())
				{
					myorder = myorder + "\"Your ordeer [" +radiomaindrinkB.getText()+"] has been added!";
					
				}
				if (radiomaindrinkC.isSelected())
				{
					myorder = myorder + "\"Your ordeer [" +radiomaindrinkC.getText()+"] has been added!\n";
					
				}
				
				//printing text depending on which item is being ordered

				
				
				if (radiodessertA.isSelected())
				{
					myorder = myorder+ "Your ordeer [" +radiodessertA.getText()+"] has been added!\n";
					
				}
				if (radiodessertB.isSelected())
				{
					myorder = myorder + "\"Your ordeer [" +radiodessertB.getText()+"] has been added!\n";
					
				}
				if (radiodessertC.isSelected())
				{
					myorder = myorder + "\"Your ordeer [" +radiodessertC.getText()+"] has been added!\n";
					
				}
				
				
				//printing text depending on which item is being ordered

				
				if (mainorder1.isSelected())
				{
					myorder = myorder + "Checkbox button [" +mainorder1.getText()+"]has been added!\n";
				}
				
				if (mainorder2.isSelected())
				{
					myorder = myorder+ "Checkbox button [" +mainorder1.getText()+"] has been added!\n";
				}
				if (mainorder3.isSelected())
				{
					myorder = myorder + "Checkbox button [" +mainorder1.getText()+"] has been added!\n";
				}
			
				
				
				//printing text depending on which item is being ordered

				if (dessert1.isSelected())
				{
					myorder = myorder + "Checkbox button [" +dessert1.getText()+"] has been added!\n";
				}
				
				if (dessert2.isSelected())
				{
					myorder = myorder+ "Checkbox button [" +dessert2.getText()+"]has been added!\n";
				}
				if (dessert3.isSelected())
				{
					myorder = myorder + "Checkbox button [" +dessert3.getText()+"] has been added!\n";
				}
				
				if(myorder!= " ") {
				 
		//restorder.add(myorder); //Adding the order to the collection
				
				Order ordermade = new Order(myorder);
		
				
				
				//displaying the order in the text area when the jbutton is clicked	
			displayorder.setText("Here is your order: " + myorder + "\n");  // ordermade instead of myorder
			
				}
			}
			
			
	
		});

		
		Waiter waiter = new Waiter(restorder); //crating waiter object and passing in the arraylist
		waiter.start();  // starting the waiter thread
		
		
		new Restaurant();
	}
}

	
