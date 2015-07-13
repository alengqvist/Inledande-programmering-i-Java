package al223bn;


public class Steg3_lab09 {

	public static void main(String[] args) {

		 // Skapar en array (kupong) med 10 Lotto-objekt (lottorader).
		Lotto[] coupon = new Lotto[10];
		
		// Räknare för antal klara lottorader.
		int index = 0;
		
		// Slumpar lottoraderna 0 till 9, d.v.s. 10 rader totalt.
		while (index < coupon.length) {
			
			// Skapar en ny lottorad.
			Lotto lotto = new Lotto();
			
			// Finns lottoraden bland dem som slumpats fram tidigare?
			int i = 0;
			while (i < index) {
				
			    // Om lottoraden redan finns...
				if (coupon[i].equals(lotto)) {
					
				       // ...dra en ny och...
				       lotto.draw();
				       // ...börja om jämförelsen från början...
				       i = 0; 
				} else {
					++i;
				}
			}
			
	        // Raden är unik - spara den och öka räknaren för lottoraderna med
	        // ett.
	        coupon[index++] = lotto;
		}
		
		// Skriver ut lottoraderna.
		for (int i = 0; i < coupon.length; ++i) {
			System.out.println(coupon[i]); 
		}
	}
}
