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
	
	/**
	*
	*@return date
	*/
	public Date getDate(){
		return this.date;
	}
	
	/**
	*
	*@param date
	*/
	public void setDate(Date date){
		this.date = date;
	}
	
	@Override
	/**
	*
	*Output this object in string format
	*@return String
	*/
	public String toString(){
		return 	"Post at " + this.date+ " :" + this.content;	
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
		
		Post post = (Post)o;
		if (o.getClass().equals(this.getClass()) && post.getContent()==this.content 
				&& post.getDate()==this.date){
			ans = true;
		}
		
		return ans;
		
	}
	
	@Override
	/**
	*
	*/
	public int hashCode(){
		
		int hashCode = 0;
		
		hashCode = this.date.hashCode()*2 + this.content.hashCode()*3;
		
		return hashCode;
		
	}
	
	/**
	*check whether this post contains some keywords
	*@param date
	*@param content
	*/
	public boolean contains(String keyword) {
		return this.content.contains(keyword);
	}
	
	
}



