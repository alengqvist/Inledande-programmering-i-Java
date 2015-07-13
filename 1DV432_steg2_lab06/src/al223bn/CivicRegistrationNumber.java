package al223bn;


/** 
 * This class handles the validation of an Civic Registration Number and 
 * also if it belongs to a female or a male.
 *
 * @version 1.0
 * @author Andreas Lengqvist
 * Created 14:00, June 15, 2015.
 */
public class CivicRegistrationNumber {
	
	// Define variables.
	private final String crn;	// Civic Registration Number.

	
	/**
	 * Constructor.
	 * 
	 * @param input String - Input string from user
	 */
	public CivicRegistrationNumber(String input) {
		this.crn = stringToCrn(input);
	}
	
	/*
	 * Method which transforms the input string to a Civic Registration Number.
	 * 
	 * @param input String - Input string to transform
	 */
	private String stringToCrn(String input) {
		
		// RegEx that replaces everything that isn't a number with "".
		return input.replaceAll("[^0-9]+", "");
	}
	
	/*
	 * Method which transforms a string to an Array of integers.
	 * 
	 * @param crn String - String to transform
	 */
	private int[] stringToArray(String crn) {
		
		// Define and initialize a array of integers with the length of the crn.
		int array[] = new int[crn.length()];
		
		// Basically divides the crn into digits and adds them to the array.
		for(int i = 0; i < crn.length(); i++) {
			array[i] = (new Integer("" + crn.charAt(i))).intValue();
		}
		
		return array;	
	}
	
	/*
	 * Method which controls if the input is a valid Civic Registration Number.
	 */
	public boolean isValid() {
				
		// Get the length of the crn.
		int crnLength = crn.length();
		
		// If the length is 10.
		if (crnLength == 10) {
			
			// Transform the crn to an Array.
			int[] crnArray = stringToArray(crn);

			int sum = 0;
			
			// For each digit in the crn.
			for(int i = 0; i < crnLength; i++) {

				// On every other digit (På varannan siffra).
				if(i % 2 == 0) {
					
					// Multiple with 2.
					int digitSum = 2 * crnArray[i];

					// If the digitSum oversteps 10.
					if(digitSum >= 10) {
						
						// Decrement with 9.
						digitSum = digitSum - 9;
					}
					
					// Add the current digitSum to the total sum.
					sum = sum + digitSum;
				} else {
					
					// Add the current digitSum to the total sum.
					sum = sum + crnArray[i];
				}
			}
			
			// If modulus is evenly with 10.
			return (sum % 10 == 0);
		}
		return false;
	}
	
	/*
	 * Method which checks if the Civic Registration Number belongs to a female or a male.
	 */
	public boolean isFemale() {
		
		// Get the next to last (nästsista) digit in the crn.
		int digit = Character.digit(crn.charAt(crn.length() - 2), 10);
		
		// If modulus is evenly with 2 it belongs to a female.
		if (digit % 2 == 0) {
			return true;
		}
		
		// It belongs to a man.
		return false;
	}
}
