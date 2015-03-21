package base;

import java.io.*;

public class User implements Comparable<User>, Serializable{

	private int userID;
	private String userName;
	private String userEmail;
	
	/**
	*Constructor
	*@param userID
	*@param userName
	*@param userEmail
	*/
	public User(int userID, String userName, String userEmail) {
		this.userID = userID;
		this.userName = userName;
		this.userEmail = userEmail;
	}

	/**
	*
	*@return userID
	*/
	public int getUserID() {
		return userID;
	}
	
	/**
	*
	*@param userID
	*/
	public void setUserID(int userID) {
		this.userID = userID;
	}

	/**
	*
	*@return userName
	*/
	public String getUserName() {
		return userName;
	}

	/**
	*
	*@param userName
	*/
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	*
	*@return userEmail
	*/
	public String getUserEmail() {
		return userEmail;
	}

	/**
	*
	*@param userEmail
	*/
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
	@Override
	/**
	*
	*Output this object in string format
	*@return String
	*/
	public String toString(){
		return 	"User [userID=" + userID + 
				", userName=" + userName 
				+ ", userEmail=" + userEmail + "]"; 	
	}
	
	@Override
	/**
	*
	*Check whether this object equals object o
	*@param object o
	*@return Boolean
	*/
	public boolean equals(Object o){
		
		boolean ans = false;
		
		if (o == null){
			return false;
		}
		
		User user = (User)o;
		if (user.getUserName() == this.userName &&
				user.getUserID() == this.userID &&
				user.getUserEmail() == this.userEmail){
			ans = true;
		}
		
		return ans;
		
	}
	
	
	
	public int compareTo(User U){
		if (this.userID == U.getUserID()){
			return 0;
		} else if (this.userID > U.getUserID()){
			return 1;
		} else {
			return -1;
		}
	}
}
