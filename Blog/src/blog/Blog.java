package blog;

import java.util.ArrayList;

import base.*;

public class Blog {
	
	private User user;
	private ArrayList<Post> allPosts;
	
	/**
	*Constructor
	*@param user
	*/
	public Blog(User user) {
		this.user = user;
		this.allPosts = new ArrayList<Post>();
	}
	
	/**
	*
	*@return user
	*/
	public User getUser() {
		return user;
	}
	
	/**
	*
	*@param user
	*/
	public void setUser(User user) {
		this.user = user;
	}
	
	/**
	*
	*@return allPosts
	*/
	public ArrayList<Post> getAllPosts() {
		return allPosts;
	}
	
	/**
	*
	*@param allPosts
	*/
	public void setAllPosts(ArrayList<Post> allPosts) {
		this.allPosts = allPosts;
	}
	
	/**
	* create a new post in your blog
	*@param post
	*/
	public void post(Post p){
		this.allPosts.add(p);
		if (this.allPosts.contains(p)){
			System.out.println("New Post:");
			System.out.println(p);
		} else {
			System.out.println("Error, try again to post your message!");
		}
	}
	
	/**
	* list all posts in the blog
	*
	*/
	public void list(){
		System.out.println("Current posts:");
		for (int i=0; i<allPosts.size(); i++){
			System.out.println("Post[" + (i+1) + "] " + allPosts.get(i));
		}
	}
	
	/**
	* delete a post from the blog
	* @param index
	*/
	public void delete(int index){
		if (index >= 0 && index < allPosts.size()){
			allPosts.remove(index-1);
		} else {
			System.out.println("ERROR: Message " + index + " does not exist.");
		}
	}
	
	@Override
	/**
	*
	*Output this object in string format
	*@return String
	*/
	public String toString(){
		return 	"Blog of " + this.user.getNickname();	
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
		
		if (o == null) {
			return false;
		}
		
		Blog b = (Blog)o;
		// Check for sizes and nulls
	    if ((this.allPosts.size() != b.getAllPosts().size()) || 
	    		(this.allPosts == null && b.getAllPosts()!= null) || 
	    		(this.allPosts != null && b.getAllPosts()== null)){
	        return false;
	    }

	    // Compare the two lists (no need to sort because dates) 
		ans = this.allPosts.equals(b.getAllPosts());
	    	
	    if (b.getUser().getNickname() == this.user.getNickname()){
	    	ans =  ans && true;
	    }
	    
	    return ans;
	}
	
	@Override
	/**
	*
	*/
	public int hashCode(){
		
		int hashCode = 0;
		
		hashCode = this.user.hashCode()*2 + this.allPosts.hashCode()*3;
		
		return hashCode;
		
	}

}
