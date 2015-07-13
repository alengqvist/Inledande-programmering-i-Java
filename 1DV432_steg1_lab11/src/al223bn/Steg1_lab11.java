package al223bn;


/** 
 * This assignment calculates how many candles you need for your 1th and up until your 100th birthday.
 *
 * @version 1.0
 * @author Andreas Lengqvist
 * Created 11:40, June 9, 2015.
 */
public class Steg1_lab11 {
	
	// Define and initialize variables			
	private final static int BOX_OF_CANDLES = 24;	// Each box contains 24 candles.

	
	public static void main(String[] args) {
		
		int totalBoxes = 1;			// Counter of Total boxes of candles purchased.
		int candlesLeft = 24;		// Counter of Candles left each year.
		
		// Loop through all birthdays.
		for (int years = 1; years <= 100; years++) {
			
			// If this birthday has more more years than there is candles.
			if (years > candlesLeft) {
			
				int candleBoxes = 0;
				
				// Buy boxes of candles until you have enough for this birthday.
				for (int boxes = 1; candlesLeft < years; boxes++) {
					candlesLeft += BOX_OF_CANDLES;
					candleBoxes = boxes;
				}		
				
				// Print the receipt.
				System.out.printf("r %d, kšp %d ask(ar)\n", years, candleBoxes);
				
				// Add purchased boxes to the total box-counter.
				totalBoxes += candleBoxes;		
			}
			
			// Use candles for this birthday.
			candlesLeft -= years;
		}
		System.out.printf("Det gŒr Œt %d askar och det blir %d ljus šver.", totalBoxes, candlesLeft);
	}
}
