package al223bn;


/** 
 * This program handles the reading and translation of a binary message.
 *
 * @version 1.0
 * @author Andreas Lengqvist
 * Created 16:05, June 18, 2015.
 */
public class Steg3_lab13 {

	public static void main(String[] args) {
		
		// Create an instance of the class Dekrypto.
		Dekrypto dekrypto = new Dekrypto();

		// Read the binary message, translate it and print the translated message.
		System.out.println(dekrypto.translate((dekrypto.readFile("krypto.txt"))));
	}
}
