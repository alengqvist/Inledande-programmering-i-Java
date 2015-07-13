package al223bn;


/** 
 * This assignment finds all prime numbers from 1 to 100.
 *
 * @version 1.0
 * @author Andreas Lengqvist
 * Created 10:30, June 9, 2015.
 */
public class Steg1_lab13 {

	public static void main(String[] args) {
		
        System.out.println("Primtalen mellan 1 och 100 Šr:\n");
        
        // Loop through all numbers between 3 and 100.
        for (int i = 3; i < 100; i++ ) {
        	
        	boolean isPrime = true;
        	
        	// Loop through each number (i) to check if its a Prime number.
        	for (int j = 2; j < i; j++) {
        		if (i % j == 0) {
        			isPrime = false;
        			break;
        		}        		
        	}

        	// And if prime was found, print it.
            if (isPrime) {
                System.out.print(i + " ");
            }
        }
	}
}
