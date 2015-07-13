package al223bn;

import java.util.Scanner;


/** 
 * This class basically just works like a View that handles the input and outputs from and to the user.
 *
 * @version 1.0
 * @author Andreas Lengqvist
 * Created 16:20, June 29, 2015.
 */
public class CashDispenserView {

	// Define and initialize a scanner.
	private Scanner input = new Scanner(System.in);		// Instance of Scanner for input.
	
	/**
	 * Get the pin code from the user.
	 * 
	 * @return pinCode - the pin code from the user
	 */
	public int getPinCode() {

		System.out.println("Välkommen till Fejk-bankomaten\n");
		
		while (true) {
		
			System.out.println("Ange din fyrasiffriga kod: ");
			
			if (isValid()) {
				return input.nextInt();
			}
		}
	}
	
	/**
	 * Get the amount to withdraw from the user.
	 * 
	 * 	 * @return amount - the amount to withdraw from the user
	 */
	public int getAmount() {

		while (true) {
		
			System.out.println("Ange önskat belopp: ");
			
			if (isValid()) {
				return input.nextInt();
			}
		}
	}

	/**
	 * Method which checks if the entered input is valid.
	 */
	private boolean isValid() {
		
		// If user entered a invalid input.
        if (!input.hasNextInt()) {
            System.out.println("Du kan endast skriva in siffror!\n");
        	input.next();
        	return false;
        }
        return true;
	}
	
	/**
	 * Method which shows the withdrawal and the new balance.
	 * 
	 * @param amount - The withdrawal
	 * @param balance - The new balance
	 */
	public void showWithdrawal(int amount, double balance) {
		System.out.printf("Du har nu tagit ut: %d kr\n", amount);
		System.out.printf("Disponibelt belopp: %.2f kr", balance);
	}
	
	/**
	 * Method which shows the error.
	 * 
	 * @param error - The error message
	 */
	public void showError(String error) {
		System.out.printf(error);
	}
}