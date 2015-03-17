package base;
import java.util.Date;


public class Post {
	private Date date;
	private String content;
	
	/**
	*Constructor
	*@param date
	*@param content
	*/
	public Post(Date date, String content) {
		this.date = date;
		this.content = content;
	}
	
	/**
	*
	*@return content
	*/
	public String getContent(){
		return this.content;
	}
	
	/**
	*
	*@param content
	*/
	public void setContent(String content){
		this.content = content;
	}
	
	@Override
	/**
	*
	*Output this object in string format
	*@return String
	*/
	public String toString(){
		return 	"Post from the " + this.date+ " :" + this.content;	
	}
	
	@Override
	/**
	*
	*Check whether this object equals object o
	*@param object o
	*@return Boolean
	*/
	public boolean equals(Object o){
		
		boolean ans = true;
		return ans;
		
	}
}



