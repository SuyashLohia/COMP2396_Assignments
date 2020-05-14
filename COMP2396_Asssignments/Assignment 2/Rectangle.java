
/**
 * The rectangle class is used to model rectangles. It is a subclass of the class Shape and inherits its methods and instances. 
 * @author Suyash Lohia 
 * @version 1.0
 *
 */
public class Rectangle extends Shape {

	
	
	/**
	 * Construction function with two parameters calling the Construction function of its parent class using super()
	 * to declare and initialize the rectangle figure. 
	 * @param width representing the width of the rectangle or the number of columns of the boolean 2d array. 
	 * @param height representing the height of the rectangle or the number of rows of the boolean 2d array. 
	 */
	public Rectangle(int width, int height) {
			
		super(width,height);
	}	
} 
