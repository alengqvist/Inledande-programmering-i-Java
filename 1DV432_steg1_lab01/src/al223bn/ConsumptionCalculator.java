package al223bn;

import java.util.Scanner;


/** 
 * This class lets the user enter three digits which then is summed together.
 *
 * @version 1.0
 * @author Andreas Lengqvist
 * Created 12:50, June 8, 2015.
 */
public class ConsumptionCalculator {
	
	// Define and initialize variables			
	private final static double PRICE_OF_ELECTRICITY = 0.7493;  // The variable price of electricity.
	private final static int FIXED_PRICE = 300;					// The fixed price (Yearly, 12 months).
	
	private Scanner input = new Scanner(System.in);		// Instance of Scanner for input.
	private int previouslyMonthsValue = 0;				// Previously months kWh-value.
	private int latestMonthsValue = 0;					// Latest months kWh-value.
	
	private int consumption = 0;						// The calculated consumption.
	private double totalCost = 0;						// The calculated total cost.
	
	private boolean finished = false;					// Variable to let the application know when its finished.


	/* 
	 * Method which basically works like a View (Managing inputs and outputs).
	 */
	public void show() {
		
		while (!finished) {
			
			// Let user enter previously months kWh-value.
			System.out.print("Ange föregående månads avlästa värde: ");
			
		    if(isValid()) {
		    	
		    	// Save the entered value.
	        	previouslyMonthsValue = input.nextInt();

				// Let user enter latest months kWh-value
				System.out.print("Ange senaste månads avlästa värde: ");
				
			    if(isValid()) {
			    	
			    	// Save the entered value.
		        	latestMonthsValue = input.nextInt();

					// Calculate the consumption.
					consumption = latestMonthsValue - previouslyMonthsValue;
					
					// Calculate the total cost (! - Fixed price for one month only).
					totalCost = (PRICE_OF_ELECTRICITY * consumption) + (FIXED_PRICE / 12);
					
					// Present the results for the user.
					System.out.printf("Förbrukning: %d kWh\n", consumption);
					System.out.printf("Kostnad: %.2f kr\n", totalCost);
					finished = true;
			    }
		    }
		}
	}
	
	/* 
	 * Method which checks if the entered input is valid.
	 */
	private boolean isValid() {
		
		// If user entered a invalid input.
        if (!input.hasNextInt()) {
            System.out.println("kWh-värdet måste vara angivet i heltal!\n");
        	input.next();
        	return false;
        }
        return true;
	}
}