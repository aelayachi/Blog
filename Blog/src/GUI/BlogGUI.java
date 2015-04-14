package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.*;

import base.Post;
import base.User;
import blog.Blog;

public class BlogGUI {
	
	private Blog blog;
	private JFrame mainFrame;
	private JPanel mainPanel;
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	private JLabel information;
	private JTextArea postTextArea;
	private JTextArea postContent;
	private JButton refresh;
	private JButton post;
	private int sizeX = 600;
	private int sizeY = 600;
	
	public BlogGUI() {
		blog =  new Blog(new User(1,"aelayachi","aelayachi@gmail.com"));
	}
	
	public void setWindow() {
		mainFrame= new JFrame("Amine");
		mainFrame.setSize(sizeX,sizeY);
		
		mainPanel = new JPanel();
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
		information = new JLabel("You can still input 140 characters!");
		postTextArea = new JTextArea("What's on your mind?");
		postContent = new JTextArea("Here is put my posts!");
		refresh = new JButton("refresh");
		refresh.setBackground(Color.CYAN);
		refresh.addActionListener(new refreshListener());
		//refresh.setPreferredSize(new Dimension(250,20));
		post = new JButton("post");
		post.setBackground(Color.ORANGE);
		post.addActionListener(new postListener());
		//post.setPreferredSize(new Dimension(250,20));
		
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS)); 
		panel1.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
		panel3.setLayout(new FlowLayout());
		panel1.add(information);
		panel2.add(postTextArea);
		panel3.add(refresh);
		panel3.add(post);
		
		mainPanel.add(panel1);
		mainPanel.add(panel2);
		mainPanel.add(panel3);
		mainPanel.add(postContent);
		mainFrame.getContentPane().add(mainPanel);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setVisible(true);
	}
	
	class refreshListener implements ActionListener {
		public void actionPerformed(ActionEvent event){
			if (event.getSource() == refresh){
				postContent.setText(blog.listPosts());
			}
		}
	}
	
	class postListener implements ActionListener {
		public void actionPerformed(ActionEvent event){
			if (event.getSource() == post){
				blog.post(new Post(new Date(),postTextArea.getText()));
			}
		}
	}
	
	
	public static void main(String[] args) {
		BlogGUI blogGUi= new BlogGUI();
		blogGUi.setWindow();
	}
}
