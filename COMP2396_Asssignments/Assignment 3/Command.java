/**
 * A class representing the interface for the main program to perform actions on the vending machine. 
 * Different types of commands are handled by different specific classes that inherit the Command class.
 * The Command class is the parent class of three classes namely CmdPurchase, CmdInsertCoin and CmdRejectCoins. 
 * @author Suyash Lohia 
 * @version 1.0
 *
 */
public class Command {
	/**
	 * A dummy method function to be overridden by the subclasses having the same function. 
	 * @param v, of type VendingMachine representing the vending machine on which the operations are to be performed. 
	 * @param cmdPart, a string representing the command to be executed. 
	 * @return result, a dummy string in this method function always containing null value. 
	 */
	public String execute(VendingMachine v, String cmdPart) {
		String result = null; 
		return result;
	}
}
