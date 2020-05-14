import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

/**
 * A class modelling the database of the users. It contains an arraylist of users which stores the details of all users 
 * recorded and has method functions to manipulate the records. 
 * @author Suyash Lohia 
 * @version 1.0
 *
 */
public class User_Database {
	
	private ArrayList<User> UserList;

	
	
	/**
	 * A constructor function of the User_Database class which creates/initialises a new Userlist which represents the database
	 */
	public User_Database() {
		UserList = new ArrayList<User>();
	}
	
	/**
	 * A method function to add the user u to the user database represented by Userlist
	 * @param u, an object of class User which is to be added to the user database. 
	 */
	public void add_User(User u) {
		UserList.add(u);
		System.out.println("Record added successfully!");
	}
	
	
	/**
	 * A method function which checks if the string parameter uname containing the username already exists in the 
	 * database or not and returns a boolean value accordingly indicating the same. 
	 * @param uname, a string containing the username to be checked. 
	 * @return true/false, a boolean value indicating if the username already exists or not
	 */
	public Boolean valid_username(String uname) {
		
		for (int i=0; i<UserList.size();i++) {
			if(UserList.get(i).rName().equals(uname))
				return false;
			
		}
	
		return true;
	}
	

	/**
	 * A method function which checks the login credentials of an already existing user. It takes string parametres 
	 * password and username and then checks if the password provided matches the password of the particular user returning 
	 * a boolean value indicating the same. 
	 * @param password, a string containing the unhashed passowrd of the user which is to be checked. 
	 * @param username, a string contatining the username of the user whose password is to be checked. 
	 * @return true/ false, a  boolean value indicating if the password entered is correct or not. 
	 */
	public boolean correct_password(String password, String username) {
		int temp=0;
		User check = new User();
		
		for (int i=0; i<UserList.size();i++) {
			if(UserList.get(i).rName().equals(username)) {
				temp=i;
				break;
			}
		}
		if (UserList.get(temp).checkAccStatus()) {
			System.out.println("Login failed! Your account has been locked!");
			return false;
			}
		check.setPassword(password);
		if (UserList.get(temp).rPass().equals(check.rPass())){
			UserList.get(temp).successLogin();
			return true;
		}
		else {
			UserList.get(temp).failedLogin();
		}
		
		return false;
	}

	/**
	 * A method function which takes in the new updated password of the user from string parametre tempPass and the username
	 * from string paramter username to update the password of the user. 
	 * @param tempPass, a string containing the new unshashed password of the user. 
	 * @param username, a string containing the username of the user whose password is to be updated. 
	 */
	public void set_new_password(String tempPass, String username) {
		int temp=0;
		for (int i=0; i<UserList.size();i++) {
			if(UserList.get(i).rName().equals(username)) {
				temp=i;
				break;
			}
		}
		UserList.get(temp).setnewPassword(tempPass);
				
	}

	/**
	 * A method function which takes in the new updated full name of the user from string parametre inputLine and the username
	 * from string paramter username to update the full name of the user. 
	 * @param inputLine, a string contaning the new full name of the user. 
	 * @param username, a string containing the username of the user whose full name is to be updated. 
	 */
	public void set_new_name(String inputLine, String username) {
		
		int temp=0;
		for (int i=0; i<UserList.size();i++) {
			if(UserList.get(i).rName().equals(username)) {
				temp=i;
				break;
			}
		}
		UserList.get(temp).setnewname(inputLine);
	}
	
	
	/**
	 * A method function which takes in the new updated email ID of the user from string parametre inputLine and the username
	 * from string paramter username to update the email ID of the user. 
	 * @param inputLine, a string contaning the new email ID of the user. 
	 * @param username, a string containing the username of the user whose email ID is to be updated. 
	 */
	public void set_new_email(String inputLine, String username) {
		
		int temp=0;
		for (int i=0; i<UserList.size();i++) {
			if(UserList.get(i).rName().equals(username)) {
				temp=i;
				break;
			}
		}
		UserList.get(temp).setnewemail(inputLine);
		
	}

	public void exportDetails() {
		
		JFileChooser ChooseFile = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		int check = ChooseFile.showSaveDialog(null);
		String filepath ="";
		if (JFileChooser.CANCEL_OPTION== check) {
			System.exit(1);
		}
		else if (JFileChooser.APPROVE_OPTION==check) {
			File ActualFile = ChooseFile.getSelectedFile();
			filepath= ActualFile.getAbsolutePath().toString();
		}
		try {
			FileOutputStream FOut = new FileOutputStream(new File(filepath));
			DataOutputStream DOut = new DataOutputStream(FOut);
			
			for (User u: UserList) {
				DOut.writeBytes("username:"+ u.rName()+";");
				DOut.writeBytes("hashPassword:"+u.rPass()+"\n");
			}
					
				
		    DOut.close();
			FOut.close();

		}  catch (Exception err) {
			System.out.println("Export Game Error!");
		}
		
		
	} 
}
