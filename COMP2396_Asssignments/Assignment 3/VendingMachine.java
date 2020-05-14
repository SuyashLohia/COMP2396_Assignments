import java.util.ArrayList;
import java.util.Collections;



/**
 * A class representing a vending machine model containing a coin slot and coin changer to dispense Soft Drinks.
 * The instances include an Integer ArrayList containing the coins in the coin changer, an Integer ArrayList containing the coins in the coin slot 
 * and an ArrayList of Type SoftDrinkSlot which contains the details of the soft drinks to be dispensed. 
 * @author Suyash Lohia
 * @version 1.0 
 */

public class VendingMachine { 
	private ArrayList<Integer> coinChanger;
	private ArrayList<Integer> coinSlot;
	private ArrayList<SoftDrinkSlot> softDrinkSlots;

	
	/**
	 * Constructor method of the Vending Machine Class declaring and initializing the three ArrayList instances of the class namely coinChanger, coinSlot and softDrinksSlots.
	 */
	public VendingMachine() { 
		coinChanger = new ArrayList<Integer>();
		coinSlot = new ArrayList<Integer>();
		softDrinkSlots = new ArrayList<SoftDrinkSlot>();
	}

	/**
	 * A method function which adds the integer c representing the coin to the coin changer used to dispense change to the user/customer. 
	 * @param c, an integer denoting the coin value to be added to the coin changer. 
	 */
	public void addCoinToCoinChanger(Integer c) {  //FIXED
		coinChanger.add(c);
	}

	/**
	 * A method function which adds the details of SoftDrinkSlot s representing the soft drink's details to the ArrayList softDrinkSlots. 
	 * @param s of type SoftDrinkSlot representing the details of the soft drink including the name, quantity and price. 
	 */
	public void addSoftDrinkSlot(SoftDrinkSlot s) { //FIXED
		softDrinkSlots.add(s);
	}



	/**
	 * A method function which adds the coin to the coin slot for the user to purchase the soft drink. 
	 * @param coin, an integer representing the value of the coin to be added to the coinslot. 
	 */
	
	public void addCoinToCoinSlot(Integer coin) { 
		coinSlot.add(coin);
	}

	/**
	 * A method function which calculated the total value of coins in the coinslot and returns it. 
	 * @return tot, an integer representing the total coinslot value which is purchase used to purchase drinks.  
	 */
	public int coinSlotTotal() { 
		int tot = 0;
		for (int j = 0; j < coinSlot.size(); j++) {
			tot = tot + coinSlot.get(j);
		}
		return tot;
	}

	/**
	 * A method function which sorts the coinSlot ArrayList by ascending order to represent the order of rejected coins. 
	 */
	public void sortCoinSlot() { 
		Collections.sort(coinSlot);
	}

	/**
	 * A method function which traverses through the sorted coinSlot ArrayList and adds the value of the coins to be rejected into a string which is to be printed 
	 * and then returns the string. 
	 * @return str, a String representing the statement to be printed containing all coins which are to be rejected. 
	 */
	public String coinsRejected() {
		if (coinSlot.isEmpty() == true) {
 
			return "no coin!";
		}
		else {
			String str="";
			
			for (int j = 0; j < coinSlot.size(); j++) {
				str += ", $" + coinSlot.get(j);
			}
			str = str + ".";
			str= str.substring(2);	
			return str;
		}
	
	}

	/**
	 * A method function which deletes all elements of the ArrayList coinSlot denoting that there are currently no coins left in the coin slot. 
	 */
	public void emptyCoinSlot() { 
		coinSlot.clear();
	}

	
	/**
	 * A method function taking the name of the soft drink as a parameter to traverse through the softDrinkSlots ArrayList and perform a linear search to find the 
	 * required soft drink and also check if there is stock left. Returning the index of the product if the conditions are satisfied. 
	 * @param product_name, a String representing the name of the Soft Drink to be purchased. 
	 * @return i, an integer representing the index of the Product to be bought in the SoftDrinkSlot Array list. 
	 */
	public int indexOfProduct(String product_name) { 

		for (int i=0; i<softDrinkSlots.size();i++) {
			if(this.softDrinkSlots.get(i).getQuantity()>0 && this.softDrinkSlots.get(i).getName()==product_name) {
				return i;
			}	
		}
				
		return -2;
	}

	/**
	 * A method function which checks if the amount of money entered into the coinslot is sufficient enough to carry out the purchase. It takes in the index of the 
	 * soft drink as a parameter and returns the amount of extra money entered in the coin slot or -2 if the money isn't enough. 
	 * @param index, an integer representing the index of the product in the SoftDrinkSlot ArrayList. 
	 * @return an integer representing the amount to be dispensed from coin changer as change. 
	 */
	public int sufficientAmount(Integer index) { 
		if (coinSlotTotal()<this.softDrinkSlots.get(index).getPrice()) {
			return this.softDrinkSlots.get(index).getPrice()-coinSlotTotal();
		}
		return -2;
	}

		

	/**
	 *  A method function which moves all the coins from the coin slot to the coin changer as soon as the purchase is completed and the change is disbursed. 
	 */
	
	public void moveFromSlotToChanger() { 
		coinChanger.addAll(coinSlot);
	}

	/**
	 * A method function removing all elements from the change ArrayList created to disburse change. 
	 * @param changeList, an Integer ArrayList containing the coins from the coin changer used to disburse change.
	 */
	public void editChanger(ArrayList<Integer> changeList) { 
		for (Integer i : changeList)
			coinChanger.remove(i);
	}
	
	/**
	 * A method function which reduces the quantity of the stock of soft drink once the purchase is completed. 
	 * @param index, an integer representing the index of the product in the SoftDrinkSlot ArrayList.
	 */
	public void modifyQuantity(Integer index) { 
		this.softDrinkSlots.get(index).editQuantity(this.softDrinkSlots.get(index).getQuantity()-1);
		
	}
	



	/**
	 * A method function which calculates the change to be disbursed and then performs necessary operations to find the List of minimum coins to be ejected as change for the customer.
	 * @param index, an integer representing the index of the product in the SoftDrinkSlot ArrayList.
	 * @return changeList, an integer ArrayList representing the coins to be disbursed as change. 
	 */
	public ArrayList<Integer> calChange(int index) { 
		ArrayList<Integer> changeList = new ArrayList<Integer>();
		int chAmount = this.coinSlotTotal() - this.softDrinkSlots.get(index).getPrice();
		if (chAmount < 1) {
			changeList.add(0);
			return changeList;
		}
		boolean found = false;
		Collections.sort(coinChanger, Collections.reverseOrder());
		outer_loop: 
			for (int i = 0; i < coinChanger.size(); i++) {
			int tempchAmount = chAmount;
			for (int j = i; j < coinChanger.size(); j++) {
				if (coinChanger.get(j) <= tempchAmount) {
					tempchAmount = tempchAmount - coinChanger.get(j);
					changeList.add(coinChanger.get(j));
				}
			}
			int checkSum = 0; //changed
			for (int k=0; k<changeList.size();k++) { 
				checkSum = checkSum + changeList.get(k);
			}
			if (checkSum == chAmount) { 
				found = true;
				break outer_loop;
			}
			changeList.clear();
		}
		if (found==true) { 
			Collections.sort(changeList);
			return changeList;
		}
		changeList.clear(); 
		return changeList;

	}



}
