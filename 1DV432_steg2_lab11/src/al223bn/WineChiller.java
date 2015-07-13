package al223bn;


/** 
 * This class generates the time it takes to chill a bottle of wine.
 *
 * @version 1.0
 * @author Andreas Lengqvist
 * Created 13:15, June 16, 2015.
 */
public class WineChiller {
	
	// Define variables.
	private final static double DELTA_MINUTES = 0.1;
	private final static int TAO = 50;
	private double chillTemp;
	private double preferedTemp;
	private double wineTemp;
	
	
	/**
	 * Constructor.
	 * 
	 * @param wineTemp double - Wine bottles current temp
	 * @param preferedTemp double - Wine bottles prefered temp
	 * @param chillTemp double - The freezers temp
	 */
	public WineChiller(double wineTemp, double preferedTemp, double chillTemp) {
		this.wineTemp = wineTemp;
		this.preferedTemp = preferedTemp;
		this.chillTemp = chillTemp;
	}
	
	/**
	 * Method which calculates the time it takes to chill a bottle of wine. 
	 */
	public int getChillingTime() {
		
		double time = 0.0;
		
		// Loop until the preferedTemp is reached.
		while (wineTemp > preferedTemp) {
			
			// Add each loop (0.1 minutes) to the total time.
			time += DELTA_MINUTES;			
			
			// The differential equation to generate each steps chilled temp.
			wineTemp -= ((wineTemp - chillTemp) / TAO) * DELTA_MINUTES;
		}
		
		// Round to nearest integer.
		return (int) Math.round(time);
	}

}
