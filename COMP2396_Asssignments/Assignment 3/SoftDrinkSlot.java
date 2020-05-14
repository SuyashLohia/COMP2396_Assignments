
/**
 * A class representing the Soft Drinks to be stored and disbursed by the vending machine. 
 * The instances include a String representing the name of the soft drink and two integers price and quantity representing the price and quantity of that particular 
 * soft drink respectively. 
 * @author Suyash Lohia
 * @version 1.0
 *
 */
public class SoftDrinkSlot { 

	private String name;
	private int price;
	private int quantity;

	/**
	 * A constructor function of the class SoftDrunkSlot taking three parameters representing the name, price and quantity of the soft drink and assigning it to object. 
	 * @param name, a string representing the name of the soft drink. 
	 * @param price, an integer representing the price of the soft drink in $.
	 * @param quantity, an integer representing the quantity of the soft drink available. 
	 */
	public SoftDrinkSlot(String name, int price, int quantity) { 
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}


	/**
	 * A method function which takes in an integer newQuantity as a parameter and assigns it to the quantity instance of the object. 
	 * @param newQuantity, an integer representing the modified quantity of soft drink.
	 */
	public void editQuantity(Integer newQuantity) {
		quantity = newQuantity;
	}
	
	/**
	 * A method function which returns the quantity of the soft drink object. 
	 * @return quantity, an integer representing the quantity of soft drink. 
	 */
	public Integer getQuantity() { 
		return quantity;
	}
	
	/**
	 * A method function which returns the price of the soft drink object. 
	 * @return price, an integer representing the price of soft drink. 
	 */
	
	public Integer getPrice() { 
		return price;
	}
	
	/**
	 * A method function which returns the name of the soft drink object. 
	 * @return name, a String representing the name of the soft drink. 
	 */
	
	public String getName() { 
		return name;
	}
	
}
