import java.awt.Polygon;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;


/**
 * The main class depicts the Authentication model having mulitiple mthods with the functionality of 
 *  adding a user record, authenticating the user and lastly editing the user record. 
 * 
 * @author Suyash Lohia
 * @version 1.0
 */

public class Main {
	
	
	private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	
	
	
	/**
	 * This method reads information from the input file line by line and then returns it as a string 
	 * @return inputLine, a string which contains a line of the input user 
	 */
	public static String readInput() {

		
		String inputLine;
		
		try {
			inputLine = input.readLine();
			return inputLine;
		} catch (IOException e) {
			System.err.println("Input ERROR.");
		}

		// return empty string if error occcurs
		return "";
	}
	

	
	/**
	 * The main method being the first function to be called  prints the instructions for the user presenting him with 
	 * a menu to choose from and then executing the respective functions 
	 * @param args, an array of string
	 */
	
	public static void main(String[] args) {
		
		User_Database uList = new User_Database();
		
		System.out.println("Welcome to the COMP2396 Authentication system!");
		System.out.println("1. Authenticate user");
		System.out.println("2. Add user record");
		System.out.println("3. Edit user record");
		System.out.println("What would you like to perform?");		
		System.out.println("Please enter your command (1-3, or 0 to terminate the system):");
		
		
		
		String cmdPrompt=readInput(); 
		
		while (!cmdPrompt.equals("0")) {
			
			if(cmdPrompt.equals("1")) {
				User_Login(uList);
			}
			
			if(cmdPrompt.equals("2")) {
				Add_User(uList);
			}
			
			if(cmdPrompt.equals("3")) {
				Modify_User(uList);
			}
			
			System.out.println("Please enter your command (1-3, or 0 to terminate the system):");	
			
			cmdPrompt= readInput();
		}
		uList.exportDetails();
		
	}


//	private static void ExportDeatils(User_Database uLi) {
//		
//		
//		JFileChooser ChooseFile = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
//		int check = ChooseFile.showSaveDialog(null);
//		String filepath ="";
//		if (JFileChooser.CANCEL_OPTION== check) {
//			System.e2xit(1);
//		}
//		else if (JFileChooser.APPROVE_OPTION==check) {
//			File ActualFile = ChooseFile.getSelectedFile();
//			filepath= ActualFile.getAbsolutePath().toString();
//		}
//		try {
//			FileOutputStream FOut = new FileOutputStream(new File(filepath));
//			DataOutputStream DOut = new DataOutputStream(FOut);
//			
//			for (User u: uLi) {
//				
//			}
//				
//			
//				
//		    DOut.close();
//			FOut.close();
//
//		}  catch (Exception err) {
//			System.out.println("Export Game Error!");
//		}
//		
//	}



	private static  void Add_User(User_Database u ) {
		
		User temp = new User();
		
		System.out.println("Please enter your username:");
		String inputLine=readInput();
		
		if(!u.valid_username(inputLine)) {
			System.out.println("The username is already taken!");
			return;
		}
		// User_Check() if username is available or not
		temp.setUsername(inputLine);
		
		System.out.println("Please enter your password:");
		inputLine=readInput();
		
		while (!valid_password(inputLine)) {
		     
        	System.out.println("Your password has to fulfil: at least 6 characters, 1 small letter, 1 capital letter, 1 digit!");
        	System.out.println("Please enter your password:");
    		inputLine=readInput();
			
		}
	
   

		
		String tempPass = inputLine;
		
		System.out.println("Please re-enter your password:");
		
		inputLine=readInput();

		if (tempPass.equals(inputLine)) {
			temp.setPassword(inputLine);
		}
		else {
			System.out.println("Passwords do not match, no user added!");
			return;
		}
	
		System.out.println("Please enter your full name:");
		inputLine=readInput();

		
		temp.setFull(inputLine);
		System.out.println("Please enter your email address:");
		inputLine=readInput();

		
		temp.setemailID(inputLine);
		
		System.out.println("Please enter your phone number:");

		inputLine=readInput();

		
		temp.setphoneNo(inputLine);
		
		u.add_User(temp);
		// u.print();
	
		
	}


	private static void User_Login(User_Database u) {
		
		System.out.println("Please enter your username:");
		String Username=readInput();
		
		System.out.println("Please enter your password:");
		String Password=readInput();
		
		if(u.valid_username(Username)) {
			System.out.println("User not found!");
			return;
		}
		if(u.correct_password(Password,Username)) 
			System.out.println("Login success! Hello " + Username + "!");

		
	}
	
	private static  void Modify_User(User_Database u) {
		
		System.out.println("Please enter your username:");
		String Username=readInput();
		
		System.out.println("Please enter your password:");
		String Password=readInput();
		
		if(u.valid_username(Username)) {
			System.out.println("User not found!");
			return;
		}
		if(!u.correct_password(Password,Username))
			return;
		
		System.out.println("Login success! Hello " + Username + "!");
		
		System.out.println("Please enter your new password:");
		String inputLine=readInput();
		
		while (!valid_password(inputLine)) {
		     
        	System.out.println("Your password has to fulfil: at least 6 characters, 1 small letter, 1 capital letter, 1 digit!");
        	System.out.println("Please enter your new password:");
    		inputLine=readInput();
			
		}
	
   

		
		String tempPass = inputLine;
		
		System.out.println("Please re-enter your new password:");
		
		inputLine=readInput();

		if (tempPass.equals(inputLine)) {
			u.set_new_password(tempPass,Username);
		}
		else {
			System.out.println("New passwords do not match, user record not edited!");
			return;
		}
		
		
		System.out.println("Please enter your new full name:");
		inputLine=readInput();
		u.set_new_name(inputLine,Username);

		
		System.out.println("Please enter your new email address:");
		inputLine=readInput();
		u.set_new_email(inputLine,Username);
		
		System.out.println("Record update successfully!");
		
		
		
	}


	
	/**
	 * This method function checks if a given string is a valid password by checking the 4 conditions namely 
	 * minimum 6 character long, checking if digit is there, presence of small case letter and big case letter and resturning 
	 * a boolean variable answering if the password is valid or not.  
	 * 
	 * @param password, a string 
	 * @return true/false, a boolean variable answering if the password is valid. 
	 */
	
	public static  Boolean valid_password(String password) {

		if (password.length()<6)
			return false;
		int count=0;
		for (int i = 65; i <= 90; i++) { 
			  
            // type casting 
            char c = (char)i; 

            String str1 = Character.toString(c); 
            if (password.contains(str1)) { 
                count = 1; 
            } 
        }
		if (count==0)
			return false;
		
		count = 0; 		  
        for (int i = 90; i <= 122; i++) { 

            // type casting 
            char c = (char)i; 
            String str1 = Character.toString(c); 

            if (password.contains(str1)) { 
                count = 1; 
            } 
        } 
        if (count==0)
			return false;
        
        count = 0; 
        for (int i = 0; i <= 9; i++) { 

            String str1 = Integer.toString(i); 

            if (password.contains(str1)) { 
                count = 1; 
            } 
        }
        if (count==0)
			return false;
        
        return true;
	}
	
	
	
	
}


