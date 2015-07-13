package al223bn;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


/** 
 * This class reads and translates the binary message to something more understanding.
 *
 * @version 1.0
 * @author Andreas Lengqvist
 * Created 16:05, June 18, 2015.
 */
public class Dekrypto {

	/*
	 * Method to read the content from a file.
	 */
	public String readFile(String filename) {
		
		String content = "";
		
		// Try to read the file from the filename.
		try {
			
			// There are a ton of readFromFile-solutions but I think this one is the cleanest and 
			// more than enough for this assignment.
			content = new String(Files.readAllBytes(Paths.get(filename)));
			
		// If the file couldn't be opened.
		} catch (IOException e) {
			System.out.println("Textfilen gick inte att šppna!");
		}
		
		// Return the read message.
		return content;
	}
	
	/*
	 * Method to translate the binary message.
	 */
	public String translate(String content) {
		
		String translation = "";   
		
		// We want to loop through each byte (8-bits).
		// This way we will find each binary group (byte) which then can be translated to a char.
		for(int i = 0; i <= content.length() - 8; i += 8) {

			// By using parseInt and (char) we can generate the correct char for that binary group (byte).
			// And by that also add that char to the translated String.
			translation += (char)Integer.parseInt(content.substring(i, i + 8), 2);
		}
		
		// Return the translated message.
		return translation;
	}
}