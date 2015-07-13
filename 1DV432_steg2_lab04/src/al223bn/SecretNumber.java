package al223bn;


/** 
 * This class checks if the guessed number is equals to the secret number.
 *
 * @version 1.0
 * @author Andreas Lengqvist
 * Created 13:30, June 15, 2015.
 */
public class SecretNumber {
	
	// Define and initialize variables			
	public final static int MAX_NUMBER_OF_GUESSES = 7;	// Total number of guesses.
	private static int numberOfGuesses = 0;				// Number of guesses made.
	private int secretNumber;							// Generated secret number.
	
	
	/* 
	 * Constructor. Basically just generates a secretNumber.
	 */
	public SecretNumber() {
		this.secretNumber = (int) (Math.random() * 101);
	}
	
	/* 
	 * Method which checks if the guessed number is equals to the secretNumber.
	 * 
	 * @param guessedNumber int - the number the users entered
	 */
	public boolean makeGuess(int guessedNumber) {
		
		// If the guessedNumber is not out of range. 
		if (guessedNumber > 0 && guessedNumber <= 100) {
		
			// First we increase the number of guesses by 1.
			numberOfGuesses += 1;
	
			// If the guessedNumber is equals to the secretNumber.
			if (guessedNumber == secretNumber) {
				System.out.printf("RÄTT GISSAT! Du klarade det på %d försök.\n", getNumberOfGuesses());
				return true;
			}
			
			// If the guessedNumber is lower than the secretNumber.
			if (guessedNumber < secretNumber) {
				System.out.printf("%d är för lågt. Du har %d försök kvar.\n", guessedNumber, MAX_NUMBER_OF_GUESSES - getNumberOfGuesses());
			}
			
			// If the guessedNumber is higher than the secretNumber.
			if (guessedNumber > secretNumber) {
				System.out.printf("%d är för högt. Du har %d försök kvar.\n", guessedNumber, MAX_NUMBER_OF_GUESSES - getNumberOfGuesses());
			}
		} else {
			System.out.println("Det inmatade värdet måste vara ett heltal mellan 0 - 100!");
		}
		return false;
	}
	
	/* 
	 * Static method to retrieve the number of guesses.
	 */
	private static int getNumberOfGuesses() {
		return numberOfGuesses;
	}
}
