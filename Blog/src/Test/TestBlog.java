package Test;

import java.io.*;
import java.util.Date;

import base.*;
import blog.*;

public class TestBlog {
	
	/**
	 * Get user's input
	 * @return string
	 */
	public String getInput(){
		String line = "";
		System.out.print("Enter the prompt:");
		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			line = br.readLine();
		} catch(IOException e){
			e.printStackTrace();
		}
		return line;
	}
	
	public static void main(String[] args) {
		
		TestBlog testBlog= new TestBlog();
		User user = new User("aelayachi");
		Blog myBlog = new Blog(user);
		String prompt = null;
		
		while (!(prompt = testBlog.getInput()).equals("exit")){
			if (prompt.startsWith("list")){
				myBlog.list();
			} else if (prompt.startsWith("post")){
				String content = prompt.substring(5);
				Date date = new Date();
				Post post = new Post(date,content);
				myBlog.post(post);
			} else if (prompt.startsWith("delete")){
				int index = Integer.parseInt(prompt.substring(7));
				myBlog.delete(index);
			}
		}
	}
	
}
