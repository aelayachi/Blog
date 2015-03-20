package base;

import java.util.Date;

public class User {
	private String nickname;
	
	/**
	*Constructor
	*@param nickname
	*/
	public User(String nickname) {
		this.nickname = nickname;
	}
	
	/**
	*
	*@return nickname
	*/
	public String getNickname(){
		return this.nickname;
	}
	
	/**
	*
	*@param nickname
	*/
	public void setNickname(String nickname){
		this.nickname = nickname;
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
		if (user.getNickname() == this.nickname){
			ans = true;
		}
		
		return ans;
		
	}
}
