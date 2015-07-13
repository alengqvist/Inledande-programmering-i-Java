package al223bn;


/** 
 * This class works like an CashDispenser and makes withdrawals from users inputs.
 *
 * @version 1.0
 * @author Andreas Lengqvist
 * Created 16:20, June 29, 2015.
 */
public class CashDispenser {
	
	// Define and initialize variables.
	private static final int PIN_CODE = 0000;
	private static final int MAX_WITHDRAW = 2500;
	private static final int MIN_WITHDRAW = 100;
	private double balance;
	
	/** 
	 * Constructor.
	 */
	public CashDispenser() {
		balance = 750.0;
	}
	
	/** 
	 * @return balance - the current balance left
	 */
	public double getBalance() {
		return balance;
	}

	/** 
	 * Lets the user make an withdraw.
	 * 
	 * @param pinCode - pincode which is used to authenticate the user
	 * @param amount - the amount which the user wants to withdraw
	 * 
	 * @throws CashDispenserException exceptions
	 */
	public void withdrawal(int pinCode, int amount) throws CashDispenserException {
		
		// Check PIN CODE.
		if (pinCode != PIN_CODE) {
			throw new CashDispenserException("Fel kod.");
		}
			
		// Check MIN- and MAX-limits.
		if (amount < MIN_WITHDRAW || amount > MAX_WITHDRAW) {
			throw new CashDispenserException("UttagsgrŠnsen Šr 100 - 2500 kr.");
		}
		
		// Check if amount consists of 100 and/or 500.
		if (amount % 100 != 0 && amount % 500 != 0) {
			throw new CashDispenserException("Endast uttag av 500- och 100-lappar Šr mšjligt.");
		}
		
		// Check if amount is higher than balance.
		if (amount > balance) {
			throw new CashDispenserException("Uttag medges inte.");
		}
		
		// And if all steps is OK. Make the withdrawal.
		balance -= amount;
	}
}