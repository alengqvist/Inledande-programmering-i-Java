package al223bn;


/** 
 * This class generates a array with 10 000 random numbers between 0 and 9.
 * It also counts how many 3 and 8 there is in the generated array.
 *
 * @version 1.0
 * @author Andreas Lengqvist
 * Created 13:25, June 18, 2015.
 */
public class Steg3_lab04 {

	public static void main(String[] args) {
		
		// Define and initialize.
		int[] numbers = new int[10000];
		int count = 0;
		
		// Randomize.
		numbers = randomize(numbers);

		// Loop and count occurrences.
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] == 3 || numbers[i] == 8) {
				count++;
			}
		}

		System.out.printf("Antalet slumpade treor och Œttor Šr: %d", count);
	}

	private static int[] randomize(int[] numbers) {
		
		// Loop and randomize each position in the array.
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = (int)(Math.random() * 10);
		}
		
		return numbers;
	}
}
