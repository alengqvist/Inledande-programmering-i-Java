package al223bn;

import java.util.Scanner;


/** 
 * This class handles input of Civic Registration Numbers and 
 * calls a instance of CivicRegistrationNumber for validation.
 *
 * @version 1.0
 * @author Andreas Lengqvist
 * Created 14:00, June 15, 2015.
 */
public class Steg2_lab06 {

	public static void main(String[] args) {
		
		// Define and initialize scanner for user inputs.
		Scanner in = new Scanner(System.in);

		while (true) {
				
			System.out.println("Ange ett personnummer (ÅÅMMDD-PPKX) (tom sträng avbryter) :");
			
			// Save the input string.
			String input = in.nextLine();
			
			// If input string is empty, cancel.
			if (input.isEmpty()) {
				System.out.println("Programmet har stoppats.");
				break;
			}
			
			// Create instance of a class CivicRegistrationNumber.
			CivicRegistrationNumber civicRegistrationNumber = new CivicRegistrationNumber(input);
			
			// Check if CRN is valid.
			if (civicRegistrationNumber.isValid()) {

				// Check if CRN is female or male.
				if (civicRegistrationNumber.isFemale()) {
					System.out.printf("Kvinnans personnummer %s är korrekt!\n", input);
				} else {
					System.out.printf("Mannens personnummer %s är korrekt!\n", input);
				}

			} else {
				System.out.printf("%s är felaktigt!\n", input);
			}
		}
	}
}
