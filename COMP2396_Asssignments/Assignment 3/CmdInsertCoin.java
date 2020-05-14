/**
 * A class inherited from the Command Class used to perform the action of inserting the coin in coinslot to purchase soft drinks. 
 * @author Suyash Lohia 
 * @version 1.0
 *
 */
public class CmdInsertCoin extends Command {
	
	/**
	 * A method function which overrides the dummy function of its parent class to input the value of the coin and add it to the coin slot returning a string containing
	 * the confirmational statement to be printed. 
	 * @param v, of type VendingMachine representing the vending machine on which the operations are to be performed. 
	 * @param cmdPart, a string representing the command to be executed. 
	 * @return a string signifying that the coin has been successfully inserted.  
	 */
	
	@Override
	public String execute (VendingMachine v, String cmdPart) {
		Integer coin = Integer.valueOf(cmdPart);
		v.addCoinToCoinSlot(coin);
		return "Inserted a $"+ coin+" coin. $"+ v.coinSlotTotal() + " in Total.";
	}
}