package al223bn;

import java.util.Scanner;

public class Steg2_lab04 {

	public static void main(String[] args) {
		
		SecretNumber secretNumber = new SecretNumber(); 
		Scanner in = new Scanner(System.in);
		System.out.println("Gissa ett tal mellan 0-100: ");
		for (int i = 0; i < SecretNumber.MAX_NUMBER_OF_GUESSES; ++i)
		{
			if (secretNumber.makeGuess(in.nextInt())) 
			{
				break; 
			}
		}
	}
}
