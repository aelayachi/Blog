package blog;

import java.util.ArrayList;
import java.io.*;
import java.util.Calendar;

import base.*;

public class Blog implements Serializable{
	
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
	public ArrayList<Post> getPosts() {
		return allPosts;
	}
	
	/**
	*
	*@param allPosts
	*/
	public void setPosts(ArrayList<Post> allPosts) {
		this.allPosts.clear();
		for (Post p : allPosts){
			this.allPosts.add(p);
		}
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
	* list all posts in the blog
	*
	*/
	public String listPosts(){
		String result;
		result = "Current posts:\n" ;
		for (int i=0; i<allPosts.size(); i++){
			result = result + System.getProperty("line.separator") + 
					"Post[" + (i+1) + "] " + allPosts.get(i);
		}
		System.out.println(result);
		return result;
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
		return 	"Blog of " + this.user.getUserName();	
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
	    if ((this.allPosts.size() != b.getPosts().size()) || 
	    		(this.allPosts == null && b.getPosts()!= null) || 
	    		(this.allPosts != null && b.getPosts()== null)){
	        return false;
	    }

	    // Compare the two lists (no need to sort because dates) 
		ans = this.allPosts.equals(b.getPosts());
	    	
	    if (b.getUser().getUserID() == this.user.getUserID() &&
	    		b.getUser().getUserName() == this.user.getUserName() &&
	    		b.getUser().getUserEmail() == this.user.getUserEmail()){
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
	
	/**
	 * Search posts created in month and mentioned someone
	 * 
	 * @param month
	 * @param someone
	 */
	public void search(int month, String someone){
		Calendar cal = Calendar.getInstance();
		//search from all posts
		for (Post p : allPosts){
			//get the current post's month (note that Calendar.Month starts
			//with 0, not 1)
			cal.setTime(p.getDate());
			int postMonth = cal.get(Calendar.MONTH);
			if ((postMonth+1 == month) && p.contains(someone)){
				System.out.println(p.toString());
			}
		}
	}
	
	public void save(String filepath){
		try{
			FileOutputStream fs = new FileOutputStream(filepath); 
			ObjectOutputStream os = new ObjectOutputStream(fs);
			os.writeObject(this);
			os.close();
		}catch(FileNotFoundException ex){
			ex.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void load(String filepath){
		try{
			FileInputStream fileStream = new FileInputStream(filepath);
			ObjectInputStream is = new ObjectInputStream(fileStream);
			Blog bl = (Blog)is.readObject();
			this.setUser(bl.getUser());
			this.setPosts(bl.getPosts());
		} catch (Exception e){
			System.out.println("Wait! There is something wrong. I cannot find the file..");
		}	
	}
	
}
