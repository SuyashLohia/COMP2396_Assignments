
/**
 * The Square class is used to model squares. It is a subclass of the class Rectangle which in itself is subclass of shape
 * inheriting both the parent and grandparents classe's methods and instances. 
 * @author Suyash Lohia 
 * @version 1.0
 *
 */

public class Square extends Rectangle {

	/**
	 * Construction function with one parameter calling the Construction function of its parent class using super()
	 * to declare and initialize the square figure.  
	 * @param size representing the length/width of the square to be modeled. 
	 */
	
	public Square(int size) {
		super(size, size);
	}
		
}
