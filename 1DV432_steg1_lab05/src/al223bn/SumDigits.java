package al223bn;

import java.util.Scanner;


/** 
 * This class lets the user enter three digits which then is summed together.
 *
 * @version 1.0
 * @author Andreas Lengqvist
 * Created 13:50, June 8, 2015.
 */
public class SumDigits {
	
	// Define and initialize variables			
	private Scanner input = new Scanner(System.in);		// Instance of Scanner for input.
	private Integer inputValue = 0;						// Input from the Scanner.
	private boolean finished = false;					// Variable to let the application know when its finished.
	

	/* 
	 * Method which basically works like a View (Managing inputs and outputs).
	 */
	public void show() {
		
		while (!finished) {
					
			// Let user enter a value of 3 digits.
			System.out.print("Ange ett tresiffrigt heltal: ");
			
			if(isValid()) {
				
				// Call the sum-method and present the result for the user.
				System.out.println("Summan av siffrorna är: " + sum(inputValue) + "\n");
				finished = true;
			}
		}
	}
	
	/* 
	 * Method which checks if the entered input is valid.
	 */
	private boolean isValid() {
		
		// Check if user entered a invalid input.
        if (input.hasNextInt()) {
    		inputValue = input.nextInt();
        } else {
            System.out.println("Endast heltal får matas in!\n");
        	input.next();
			return false;
        }
        
		// Check if user entered a value contains 3 digits.
		if (inputValue.toString().length() < 3 || inputValue.toString().length() > 3) {
            System.out.println("Det måste vara ett tresiffrigt heltal!\n");
			return false;
		}
		return true;
	}
	
	/* 
	 * Method which calculates the three digits to receive the sum.
	 */
	private int sum(int inputValue) {
		int sum = 0;

		while (inputValue != 0) {
			
			sum += inputValue % 10;
			inputValue /= 10;
		}
		return sum;
	}
}
