package al223bn;

import java.util.Scanner;


/** 
 * This class basically just works like a View that handles the input and outputs from and to the user.
 *
 * @version 1.0
 * @author Andreas Lengqvist
 * Created 13:15, June 16, 2015.
 */
public class ChillerView {
	
	// Define and initialize a scanner.
	private Scanner input = new Scanner(System.in);		// Instance of Scanner for input.
	
	// Define member variables.
	private double wineTemp;							// Current temp of the wine bottle.
	private double preferedTemp;						// Prefered temp of the wine bottle.
	private double chillTemp;							// Freezers temp.
	
	// Getters.
	public double getWineTemp() {
		return wineTemp;
	}
	public double getPreferedTemp() {
		return preferedTemp;
	}
	public double getChillTemp() {
		return chillTemp;
	}
	
	
	/**
	 * Method which shows the outputs.
	 * 
	 * @param time int - The time until the wine bottle is chilled
	 */
	public void showOutput(int time) {
		System.out.printf("Det tar %d MINUTER innan vinet har den önskade temperaturen.", time);
	}
	
	/**
	 * Method which shows and handles the inputs.
	 */
	public void showInput() {

		System.out.println("VINETS AVKLYNINGSTID\n");
		
		while (true) {

			System.out.println("Ange vinets nuvarande temperatur:");
	
			if (isValid()) {
				
		    	// Save the entered current temp.
				wineTemp = input.nextDouble();
	        	
				System.out.println("\nAnge vinets önskade temperatur:");

				if (isValid()) {
					
			    	// Save the entered prefered temp.
					preferedTemp = input.nextDouble();
		        	
					System.out.println("Ange kylmediets temperatur:");
					
					if (isValid()) {
						
				    	// Save the entered freezer temp.
						chillTemp = input.nextDouble();
			        	
						// End Input-Loop.
			        	break;
					}
				}
			}
		}
	}
	
	/**
	 * Method which checks if the entered input is valid.
	 */
	private boolean isValid() {
		
		// If user entered a invalid input.
        if (!input.hasNextDouble()) {
            System.out.println("Temperaturen måste vara skrivet med siffror (tex. 5 eller 5,0)\n");
        	input.next();
        	return false;
        }
        return true;
	}
}