package Test;

import java.util.Date;

import base.User;
import base.FriendsPost;

public class TestObject {

	public static void main(String[] args) {
		
		User user = new User(1,"aelayachi","aelayachi@gmail.com");
		Date date = new Date();
		String content= "This is my first post";
		FriendsPost postFromFriend = new FriendsPost(date,content,user);
		System.out.println(postFromFriend);
		System.out.println(postFromFriend.contains("This"));
		System.out.println(postFromFriend.contains(" post"));
		System.out.println(postFromFriend.hashCode());
	}
}
