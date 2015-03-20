package base;

import java.util.Date;

public class FriendsPost extends Post{
	
	private User friend;

	/**
	*Constructor
	*@param friend
	*@param date
	*@param content
	*/
	public FriendsPost(Date date, String content, User friend) {
		super(date, content);
		this.friend = friend;
	}
	
	@Override
	/**
	*
	*Output this object in string format
	*@return String
	*/
	public String toString(){
		return 	"Post from " + friend.getNickname() +  " at " 
				+ super.getDate() + ": " + super.getContent();	
	}
}
