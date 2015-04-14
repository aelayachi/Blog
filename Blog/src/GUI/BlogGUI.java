package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
	private String filepath = "./okok";
	
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
		postTextArea = new JTextArea("");
		postTextArea.addKeyListener(new lengthListener());
		postContent = new JTextArea("Here is put my posts!");
		refresh = new JButton("refresh");
		refresh.setBackground(new Color(135,206,250));
		refresh.addActionListener(new refreshListener());
		post = new JButton("post");
		post.setBackground(Color.ORANGE);
		post.addActionListener(new postListener());
		
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
				blog.load(filepath);
				postContent.setText(blog.listPosts());
			}
		}
	}
	
	class postListener implements ActionListener {
		public void actionPerformed(ActionEvent event){
			if (event.getSource() == post){
				if (!postTextArea.getText().isEmpty() && (postTextArea.getText().length() <= 140)) {
					blog.load(filepath);
					Post p = new Post(new Date(),postTextArea.getText());
					blog.post(p);
					postContent.setText(p.toString());
					blog.save(filepath);
					postTextArea.setText("");
					information.setText("You can still input 140 characters!");
				}			
			}
		}
	}
	
	class lengthListener implements KeyListener {
		public void keyTyped(KeyEvent e){
		}
		
		public void keyPressed(KeyEvent e){
		}
		
		public void keyReleased(KeyEvent e){
			int lengthText = postTextArea.getText().length();
			if (lengthText <= 140){
				information.setText("You can still input "+ (140-lengthText) +" characters!");
			} else {
				information.setText("Your post length has exceeded 140!");
			}
		}
	}
	
	
	public static void main(String[] args) {
		BlogGUI blogGUi= new BlogGUI();
		blogGUi.setWindow();
	}
}
