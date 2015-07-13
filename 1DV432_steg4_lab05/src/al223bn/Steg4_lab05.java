package al223bn;


/** 
 * This program handles withdrawals from users through an Cashdispenser.
 *
 * @version 1.0
 * @author Andreas Lengqvist
 * Created 16:20, June 29, 2015.
 */
public class Steg4_lab05 {

	public static void main(String[] args) {

		// Create a instance of a View.
		CashDispenserView view = new CashDispenserView();
		
		// Get the pin code from the user.
		int pinCode = view.getPinCode();
		
		// Get the amount to withdraw from the user.
		int amount = view.getAmount();
		
		// Create a instance of a CashDispenser.
		CashDispenser cashDispenser = new CashDispenser();
		
		try {
			
			// Try to make a withdrawal.
			cashDispenser.withdrawal(pinCode, amount);
			
			// Show the made withdrawal and the new balance for the user.
			view.showWithdrawal(amount, cashDispenser.getBalance());
			
		} catch (CashDispenserException ex) {
			
			// Show the caught error for the user.
			view.showError(ex.getMessage());
		}
	}
}
