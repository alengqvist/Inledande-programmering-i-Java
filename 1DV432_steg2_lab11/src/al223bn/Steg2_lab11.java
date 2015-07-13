package al223bn;


/** 
 * This class handles creation of the classes to perform a calculation for WineChilling.
 *
 * @version 1.0
 * @author Andreas Lengqvist
 * Created 13:15, June 16, 2015.
 */
public class Steg2_lab11 {

	public static void main(String[] args) {
		
		// Create a instance of ChillerInput in which the user can enter the wine bottles properties.
		ChillerView chillerView = new ChillerView();
		chillerView.showInput();
			
		// Create a instance of WineChiller with the arguments from the InputChiller.
		WineChiller wineChiller = new WineChiller(
				chillerView.getWineTemp(), 
				chillerView.getPreferedTemp(), 
				chillerView.getChillTemp());
		
		// Get and show the chilling time.
		chillerView.showOutput(wineChiller.getChillingTime());
	}
}
