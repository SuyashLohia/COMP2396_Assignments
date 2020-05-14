import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * A class modelling the user containing instances storing all the details of the users having multiple
 * methods to edit the private strings. This class also implements the Hash interface with the primary functionality to 
 * convert the string password into a hashed number for added security. 
 * 
 * @author Suyash Lohia
 * @version 1.0
 */

public class User implements Hash {
	
	private String username;
	private String hashedPassword;
	private String fullName;
	private String emailID;
	private String phoneNo;
	private int failedLoginCount;
	private boolean accountLocked;
	
	
	/**
	 * A construction function of the User class which sets the value the value of failed login attempts as 0
	 * and the current account status to be unlocked.  
	 */
	public User() {
		failedLoginCount=0;
		accountLocked=false;
	}

	
	
	/**
	 * Method function which assigns the value from paramter name to private instance username
	 * @param name, a string containing the name of the username to be stored. 
	 */
	public void setUsername(String name) {
		username= name;
	}
	
	/**
	 * Method function to set the hashed passowd. It takes the value of the unhashed password from string parameter
	 * name, performs a one way hash and the stores it in private instance hashedPassword. 
	 * @param name, a string containing the unhashed password to be hashed and stored. 
	 */
	public void setPassword(String name) {
		hashedPassword= hashing(name);
	}
	
	/**
	 * Method function which assigns the value from paramter name to private instance fullName
	 * @param name, a string containing the full name of the user to be stored. 
	 */
	public void setFull(String name) {
		fullName= name;
	}
	
	/**
	 * Method function which assigns the value from paramter name to private instance phoneNo
	 * @param name, a string containing the phone number of the user to be stored. 
	 */
	public void setphoneNo(String name) {
		phoneNo= name;
	}
	
	/**
	 * Method function which assigns the value from paramter name to private instance emailID. 
	 * @param name, a string containing the email ID of the user to be stored. 
	 */
	public void setemailID(String name) {
		emailID= name;
	}
	
	/**
	 * A method function which returns the private instance username of the user to be computed in other functions
	 * @return username, a string containing the name of the user. 
	 */
	public String rName() {
		return username;
	}
	
	/**
	 * A method function which returns the private instance hashedPassword of the user to be computed in other functions.
	 * @return hashedPassword, a string containing the hashed password of the particular user. 
	 */
	public String rPass() {
		return hashedPassword;
	}

	/**
	 * A method function executed when the login is failed to update the failed login count and accodingly modify the 
	 * status of the account. 
	 */
	public void failedLogin() {
		
		if(accountLocked) {
			System.out.println("Login failed! Your account has been locked!");
			return;
		}
		
		failedLoginCount +=1;
		if (failedLoginCount>2) {
			accountLocked = true;
		}
		System.out.println("Login failed!");
	}

	/**
	 * A method function executed when login has been conducted succesfully where the account status is modified to active 
	 * and the failed login count is reset. 
	 */
	public void successLogin() {
		
		accountLocked = false;
		failedLoginCount=0;
	}

	/**
	 * A method function which checks the account status of the usewr and returns a boolean value 
	 * indicating the answer
	 * @return true/false, a boolean variable indicating if the account is locked or not. 
	 */
	public boolean checkAccStatus() {
		
		if (accountLocked==true)
			return true;
		return false;
	}



	/**
	 * A method function which edits the existing password of the user by taking the value from a string parameter called 
	 * tempPass and then hashing it and stroing it in private instance hashedPassword. 
	 * @param tempPass, a string containing upated unhashed password of user. 
	 */
	public void setnewPassword(String tempPass) {
		
		hashedPassword= hashing(tempPass);
		
	}



	/**
	 * A method function which edits the existing fullName of the user by taking the value from a string parametre called 
	 * inputLine and storing it in private instance fullName
	 * @param inputLine, a string containing the updated full name of the user. 
	 */
	public void setnewname(String inputLine) {
		
		fullName= inputLine;
		
	}


	/**
	 * A method function which edits the existing emailID of the user by taking the value from a string parametre called 
	 * inputLine and storing it in private instance emailID
	 * @param inputLine, a string containing the updated email ID of the user. 
	 */
	
	public void setnewemail(String inputLine) {
		
		emailID = inputLine;
		
	}



	/**
	 *A method function which performs the hashing using SHA-256 method of the unhashed password. It takes the value of unhashed password from 
	 *string parametee passowrd and then hashes it returing a string containig the hashed password. 
	 *@param password, a string containing the unhashed password of the user 
	 *@return generatedPassword, a string containing the Hashed password of the user. 
	 */
	@Override
	public String hashing(String password) {
		
		String passwordToHash = password;
        String generatedPassword = null;
        try {
            // Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            //Add password bytes to digest
            md.update(passwordToHash.getBytes());
            //Get the hash's bytes 
            byte[] bytes = md.digest();
            //This bytes[] has bytes in decimal format;
            //Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            //Get complete hashed password in hex format
            generatedPassword = sb.toString();
        } 
        catch (NoSuchAlgorithmException e) 
        {
            e.printStackTrace();
        }
        return generatedPassword;
		
	}
	
	
	
	

}
