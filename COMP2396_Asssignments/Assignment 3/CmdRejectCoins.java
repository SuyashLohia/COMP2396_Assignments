/**
 * A class inherited from the Command Class used to perform the action of rejecting all the coins from the coinslot to model the
 * cancellation function of the vending machine. 
 * @author Suyash Lohia 
 * @version 1.0
 */

public class CmdRejectCoins extends Command {

	/**
	 * A method function which overrides the dummy function of its parent class to reject all the coins present in the coinslot returning a string containing
	 * the confirmational statement to be printed. 
	 * @param v, of type VendingMachine representing the vending machine on which the operations are to be performed. 
	 * @param cmdPart, a string representing the command to be executed. 
	 * @return a string signifying that all coin have been successfully rejected from the coinslot.  
	 */
	
	@Override
	public String execute(VendingMachine v, String cmdPart) {
		v.sortCoinSlot();
		String str = v.coinsRejected();
		int tot = v.coinSlotTotal();
		v.emptyCoinSlot();
		if (tot == 0) {
			return ("Rejected " + str);
		}
		else {
			return ("Rejected " + str + " $" + tot + " in Total.");
		}
	}
}
