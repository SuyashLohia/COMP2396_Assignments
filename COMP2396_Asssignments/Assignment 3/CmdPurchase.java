import java.util.ArrayList;

/**
 * A class inherited from the Command Class used to perform the action of purchasing a soft drink, vending a can of soft drink to the customer
 * and calculating and disbursing the change in minimum number of coins  
 * @author Suyash Lohia 
 * @version 1.0
 */

public class CmdPurchase extends Command {
	
	/**
	 * A method function which overrides the dummy function of its parent class to perform the whole transaction of purchasing the soft drink and disbursing the required
	 * change returning a string containing the confirmational statement to be printed. 
	 * @param v, of type VendingMachine representing the vending machine on which the operations are to be performed. 
	 * @param cmdPart, a string representing the command to be executed. 
	 * @return a string signifying that the soft drink has been successfully purchased.
	 */
	
	@Override
	public String execute(VendingMachine v, String cmdPart) {
		String str = "";
		int index = v.indexOfProduct(cmdPart);
		if (index == -2) {
			str =str+ "Out of stock!";			
		} 
		else {
			int temp = v.sufficientAmount(index);
			if (temp != -2) {
				
				str = str + "Insufficient amount! Inserted $" + v.coinSlotTotal() + " but needs $" + (v.coinSlotTotal() + temp) + ".";
			} 
			else {
				
				ArrayList<Integer> changeList = v.calChange(index);
				if (changeList.isEmpty()) {
					
					str =str+ "Insufficient change!";
							
				} 
				else {
					
					str =str + "Success! Paid $" + v.coinSlotTotal();
					if (changeList.get(0) != 0) {
						str = str +". Change:";
						for (int i = 0; i < changeList.size() - 1; i++)
							str =str+ " $" + changeList.get(i) + ",";
						str =str+ " $" + changeList.get(changeList.size() - 1) + ".";
					}
					else {
						str =str+ ". No change.";
					}

					v.editChanger(changeList);
					v.modifyQuantity(index);
					v.moveFromSlotToChanger();
					v.emptyCoinSlot();
				}
						
			}
			
		}

		return "Purchasing " + cmdPart + "... " + str;
	}

}
