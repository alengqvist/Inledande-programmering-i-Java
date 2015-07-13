package al223bn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;


/** 
 * This class generates a random row in lotto.
 *
 * @version 1.0
 * @author Andreas Lengqvist
 * Created 12:15, June 17, 2015.
 */
public class Lotto {

	private int[] row;
	private static Random random = new Random();
	   
	public Lotto() {
		
		// Skapa en array (rad) fšr 7 nummer. 
		this.row = new int[7];
		draw();
	}
	
	public void draw() {

		// Loopa igenom raden.
		for (int i = 0; i < row.length; i++) {
			
			// Slumpa fram ett nummer.
			int n = 1 + random.nextInt(35);
			
			// Loopa igenom raden.
			for ( int j = 0; j < row.length; j++) {
				
				// Om det slumpade numret redan finns i raden.
		        if (n == row[j]) {
		        	
		        	// Slumpa pŒ nytt och "gŒ tillbaks" fšr att kontrollera igen.
		             n = 1 + random.nextInt(35);
		             j =- 1;                  
		        }                           
		    }
			
			// LŠgg till numret till raden.
			row[i] = n;
		}
		
		
	// ALTERNATIV L…SNING - Inte lika effektiv men kŠnns renare och "sŠkrare".
/*
		// Skapa en lista som har hand om alla tŠnkbara nummer.
        ArrayList<Integer> list = new ArrayList<Integer>();

		// LŠgg till alla nummer mellan 1 och 35 till listan.
		for (int i = 1; i < 35; i++) {
			list.add(i);
		}
		
		// Blanda listan.
		Collections.shuffle(list);

		// Ta nu ut de 7 fšrsta numren frŒn den blandade listan.
		for (int j = 0; j < 7; j++) {
			
			// Spara ner varje nummer till raden.
			row[j] = list.get(j);
		}
*/

		// Sortera raden.
		Arrays.sort(row);
	}
	
	public String toString() {
		
		// Skapa en strŠng som fungerar som uppsamlare av radnummer.
		String rowAsString = "";
		
		// Loopa igenom raden och sammanfoga varje radnummer till strŠngen. 
		for (int i = 0; i < row.length; i++) {
			rowAsString += row[i] + " ";
		}
		
		// Returnera raden.
		return rowAsString;
	}
	
	public boolean equals(Lotto other) {
		return Arrays.equals(this.row, other.row);
	}
}
