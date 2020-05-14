
/**
 * This Shape class is created to model general shapes namely Rectangle, Diamond and Square.
 * @author Suyash Lohia
 * @version 1.0
 *
 */

public class Shape {
	
	/**
	 *  Integer rows created to depict number of rows of the two-dimensional boolean array
	 */
	public int rows; 
	/**
	 *  Integer columns created to depict number of columns of the two-dimensional boolean array
	 */
	public int columns;
	/**
	 *  Two Dimensional Boolean Array array_bool created to store location of all places containing * and ' '
	 */
	
	public boolean[][] array_bool; 
	/**
	 *  String answer initialized as an empty string to be used to print the result of toString() method 
	 */
	public String answer="";
	/**
	 *  Integer area initialized as 0 created to store the amount of locations containing '*' 
	 */
	public int area=0;
	
	/**
	 *  Dummy Constructor used to create the structure of shapes required.
	 */
	
	public Shape() {
		
	}
	
	/**
	 *  Constructor with single parameter of size to create a diamond structure 
	 *  @param integer n representing the size of diamond 
	 */
	public Shape(int n) {
		
		this.rows=(2*n) -1;
		this.columns=(2*n) -1;
		
		array_bool= new boolean[rows][columns];

			
		int i, j, space = 1;
	    space = n - 1;
	    for (j = 1; j <=n; j++) 
	       {
	           	int c=0;
	    		for (i = 1; i <= space; i++) 
	            {
	            	c++;
	            }
	            space--;
	            for (i = 1; i <= 2 * j - 1; i++) 
	            { 
	            	array_bool[j-1][c%rows]=true;
	            	c++;
	            }

	        }
	     space = 1;
	     for (j = 1; j <= n - 1; j++) 
	        {
	            int c=0;
	    	 	for (i = 1; i <= space; i++) 
	            {
	            	c++;
	            }
	            space++;
	            for (i = 1; i <= 2 * (n - j) - 1; i++) 
	            {
	            	array_bool[n+j -1][c%rows]=true;
	            	c++;
	            }

	        }
	
	}
		
	/**
	 *  Constructor with two parameter of length and width to create a rectangular structure 
	 *  @param integer cols representing the number of columns of the rectangular structure to be created 
	 *  @param integer ros representing the number of rows of the rectangular structure to be created. 
	 */	
	
	
	public Shape(int cols,int ros) {
		this.rows=ros;
		this.columns=cols;
		array_bool= new boolean[rows][columns];
		
		for (int r=0; r<ros; r++) {
			for (int c=0;c<cols;c++) {
				array_bool[r][c]=true;
				
			}
		}
	}
		
	/**
	 *  This method function traverses through the two dimensional boolean array to check for true values modifying the answer string 
	 *  and then returning it. 
	 *  @return a string called answer representing the drawing of the figure/shapes. 
	 */
	
	public String toString() {
		for (int r=0; r<rows; r++) {
			for (int c=0;c<columns;c++) {
				if (array_bool[r][c]==true) {

						answer+="*";
				}
				else {
					answer+=" ";
				}
			
				
			}
			answer+='\n';
		}
		return answer.substring(0, answer.length() - 1);
	}
	
	/**
	 *  This method function traverses through the two dimensional boolean array to check for true values adding one to the area variable each time  
	 *  and then returning it. 
	 *  @return area, an integer representing the area/ no of '*'s in the figure.  
	 */
	
	public int getArea() {
		
		for (int r=0; r<rows; r++) {
			for (int c=0;c<columns;c++) {
				if (array_bool[r][c]==true) {

						area++;
				}
			}
		}
		return area;
	}
	
	/**
	 *  This method function takes another shape as a parameter and performs the intersection with the original shape resulting in  
	 *  formation of a different figure and then returning it.  
	 *  @param	s, an object of class Shape with which the intersection is to be performed 
	 *  @return  temp, a modified object of class shape which is the result of the intersection of the two figures. 
	 */
	
	public Shape intersect(Shape s) {
		int newr,newc;
		if (s.rows < rows) {
			newr=s.rows;
		}
		else {
			newr= rows;
		}
		if (s.columns < columns) {
			newc= s.columns;
		}
		else {
			newc= columns;
		}

		Shape temp = new Shape(newc,newr);
		for (int r=0; r<newr; r++) {
			for (int c=0;c<newc;c++) {
				temp.array_bool[r][c]=false;
				
			}
		}
		for (int r=0; r<newr; r++) {
			for (int c=0;c<newc;c++) {
				if(array_bool[r][c]==true && s.array_bool[r][c]==true) {
					temp.array_bool[r][c]=true;
				}
						
			}
		}
	
		
		return temp;
	}
		
	/**
	 *  This method function takes another shape as a parameter and performs the union with the original shape resulting in  
	 *  formation of a different figure and then returning it.  
	 *  @param	s,an object of class shape with which the union is to be performed 
	 *  @return  temp, a modified object of class shape which is the result of the intersection of the two figures. 
	 */

	public Shape union(Shape s) {
		
		int newr,newc;
		if (s.rows > rows) {
			newr=s.rows;
		}
		else {
			newr= rows;
		}
		if (s.columns > columns) {
			newc= s.columns;
		}
		else {
			newc= columns;
		}

		Shape temp = new Shape(newc,newr);
		for (int r=0; r<newr; r++) {
			for (int c=0;c<newc;c++) {
				temp.array_bool[r][c]=false;
				
			}
		}
		for (int r=0; r<rows; r++) {
			for (int c=0;c<columns;c++) {
				if(array_bool[r][c]==true) {
					temp.array_bool[r][c]=true;
				}
						
			}
		}
		for (int r=0; r<s.rows; r++) {
			for (int c=0;c<s.columns;c++) {
				if(s.array_bool[r][c]==true) {
					temp.array_bool[r][c]=true;
				}
						
			}
		}
		
		return temp;
	}
}
