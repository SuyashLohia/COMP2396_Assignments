import java.io.*;

/**
 * This class is created to convert Postfix into Infix and to evaluate it. 
 * 
 * @author Suyash Lohia
 * @version 1.o 
 */

public class PostfixReader {
	
	public static void main(String[] args) {
		PostfixReader myAnswer = new PostfixReader();
		myAnswer.doConversion();
	}
	
	/**
	 * This method reads postfix input using readPostfix() and then converts it to infix and prints it out 
	 */
	
	public void doConversion() {

		
		
		String[] Postfix = readPostfix();				
		Stack st = new Stack();
		int i=0;
		while (i < Postfix.length) {
			String op = Postfix[i];
			String y= new String();
			String x= new String();
			if (isOperator(op)) {
				if (!st.isEmpty()) {
					y = st.pop();}
				else {
					System.out.println("Error: Invalid postfix");
					System.exit(1);
				}
				if (!st.isEmpty()) {
					x = st.pop();}
				else {
					System.out.println("Error: Invalid postfix");
					System.exit(1);
				}	
				st.push("( " + x + " " + op + " " + y + " )");
			} else
				st.push(op);
			i++;
		}
		String infixx = st.pop();
		System.out.println("Infix: " + infixx);
		evalInfix(infixx);
	}

	/**
	 * 
	 * This method function evaluates the infix representation of the input arithmetic expression and then prints the result
	 * of the evaluation of the expression on the next line. 
	 * 
	 * @param infix used to evaluate the result
	 * 
	 */
	public void evalInfix(String infix) {

		String[] newinput = infix.split(" ");
		Stack tempst = new Stack(); 
		int i=0;
		while (i<newinput.length){
			if (newinput[i].equals(")")) {
				Integer y = Integer.parseInt(tempst.pop());
				String op = tempst.pop();
				Integer x = Integer.parseInt(tempst.pop());
				tempst.pop();
				tempst.push(Integer.toString(Calc(op, y, x)));
			}
			else {
				tempst.push(newinput[i]);
			}
			i++;
		}
		System.out.println("Result: " + tempst.pop());
	}
	
    
    /**
     * This method function conducts the arithmetic operation between two operands and returns the result 
     * @param o operator 
     * @param y operand 2
     * @param x operand 1 
     * @return answer after performing the calculation between operand 1 and operand 2 using the operator
     */
    public static int Calc(String o, int y, int x) 
    { 
    	if(o.equals("+"))
            return x + y; 
      	if(o.equals("-"))
            return x - y; 
      	if(o.equals("*"))
            return x * y; 
      	if(o.equals("/"))        
            return x / y; 
      	if(o.equals("^")) {
        	int expo = 1;
        	for (int i = 0; i < y; i++) {
        		expo = expo* x;
        	}
        	return expo;
      	}
      	return 0;
    } 
    
	private boolean isOperator(String s) {
		if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/") || s.equals("^")) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * This method function asks the user for an input, splits it to convert into a string array and returns it. 
	 * @return array of strings
	 */
	public String[] readPostfix() {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		String inputLine;
		
		try {
			System.out.print("Input postfix: ");
			inputLine = input.readLine();
			return inputLine.split(" ");
		} catch (IOException e) {
			System.err.println("Input ERROR.");
		}

		// return empty array if error occurs
		return new String[] {};
	}
}

/**
 * 
 * This class represents a stack implemented to store operands and operators and extract them according to the need. 
 * 
 * @author suyashlohia
 * @version 1.0
 * 
 */
class Stack {
	
	String arry[] = new String[1000];
	private int t;


	/**
	 * Constructor to initialize stack with t variable =-1 
	 */
	Stack()
	{
		t = -1;
	}
	
	/**
	 * Function to check if the stack is empty
	 * @return boolean value, representing if the stack is empty or not 
	 */
	public Boolean isEmpty()
	{
		return t == -1;
	}

	// Utility function to pop top element from the stack
	/**
	 * Utility function to pop and extract the top element from the stack 
	 * @return the topmost element of stack
	 */
	public String pop()
	{
		return arry[t--];
	}
	
	/**
	 * Utility function to add an element or string s into the stack. 
	 * @param s , a string which is to inserted in the stack 
	 */
	public void push(String s)
	{
		t+=1;
		arry[t] = s;
	}
	
}
