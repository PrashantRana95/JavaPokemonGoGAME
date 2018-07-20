package com.game;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.border.LineBorder;

import org.apache.log4j.Logger;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.awt.event.ActionEvent;

public class LoginScreen extends JFrame {

	Logger logger = Logger.getLogger(LoginScreen.class);
	private JPanel contentPane;
	private JTextField useridTxt;
	private JPasswordField passwordField;
	JLabel useriderror = new JLabel("");
	JLabel pwderror = new JLabel("");
	
	private GameMainMenuScreen mainScreenObject;


	/**
	 * Create the frame.
	 */
	public LoginScreen(GameMainMenuScreen mainScreenObject) {
		
		//this is used to call the mainscreenobject created outside the constructor
		this.mainScreenObject = mainScreenObject;
		//this is set to false because we don't want to increase its frame size
		setResizable(false);
		//This will set to comments because we don't want to display the exit menu on Login frame
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//set bounds it is x,y,width,height
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogin = new JLabel("");
		lblLogin.setIcon(new ImageIcon(LoginScreen.class.getResource("/com/images/Staff-Login.png")));
		lblLogin.setFont(new Font("Bodoni MT Condensed", Font.BOLD, 18));
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setBounds(116, 0, 217, 74);
		contentPane.add(lblLogin);
		
		JLabel lblUserid = new JLabel("User ID");
		lblUserid.setFont(new Font("Bodoni MT Condensed", Font.BOLD, 17));
		lblUserid.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserid.setBounds(65, 85, 67, 23);
		contentPane.add(lblUserid);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Bodoni MT Condensed", Font.BOLD, 17));
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setBounds(65, 136, 67, 24);
		contentPane.add(lblPassword);
		
		useridTxt = new JTextField();
		useridTxt.setBounds(183, 91, 135, 20);
		contentPane.add(useridTxt);
		useridTxt.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(183, 136, 135, 20);
		contentPane.add(passwordField);
		useriderror.setForeground(Color.RED);
		
		useriderror.setBounds(182, 74, 136, 14);
		contentPane.add(useriderror);
		pwderror.setForeground(Color.RED);
		
		pwderror.setBounds(183, 119, 210, 14);
		contentPane.add(pwderror);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//checkLogin Method will be performed here
				checkLogin();
			}
		});
		btnNewButton.setIcon(new ImageIcon(LoginScreen.class.getResource("/com/images/access_key-512.png")));
		btnNewButton.setBounds(78, 191, 135, 52);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Reset");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkReset();
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(LoginScreen.class.getResource("/com/images/resetB.png")));
		btnNewButton_1.setBounds(245, 191, 135, 52);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(LoginScreen.class.getResource("/com/images/People.png")));
		lblNewLabel.setBounds(126, 80, 35, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(LoginScreen.class.getResource("/com/images/pass.png")));
		lblNewLabel_1.setBounds(127, 125, 35, 35);
		contentPane.add(lblNewLabel_1);
	}

	private void checkLogin(){
		//this string will take the userid in string and getText will returns the text returns in the textfield
		String userid=useridTxt.getText();		
		//This will now returns the password field and getText will returns the text in textfield 
		String password = passwordField.getText();
		logger.debug("Check login Call Userid "+userid +" Password "+password);
		//User class obj created
		User user = new User();
		//Used to retrieve the id and password using setters and getters
		user.setUserid(userid);
		user.setPassword(password);
		//This isValidationFail will tell us weather or not validation checks or not
		boolean isValidationFail = false;
		String message="";
		try {
			message = UserOperations.isUserExist(user);
		} catch (ClassNotFoundException e) {
			//This is all for writing into the logger file
			// TODO Auto-generated catch block
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			logger.error(sw.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e);
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			logger.error(sw.toString());
		}
		
		
		//Here all the Validation Works about min characters and all with password things
		
		
		//This will take the isBlank method from the UserValidation class..as for static method they do not require the object creation
				if(UserValidation.isBlank(userid)){
					//We would then print this in the useriderror label
					useriderror.setText("UserID Can't be Blank");
					isValidationFail = true;
				}
				//else condition checks that if above fails then login must have some data so false then blank field
				else{
					useriderror.setText("");
				}
				if(UserValidation.checkMinLength(password, 8)){
					pwderror.setText("Password must be 8 characters each");
					isValidationFail = true;
				}
				else
				{
					pwderror.setText("");
				}
				if(isValidationFail){
					return ;
				}
				
		
		
				
				
		
			//This if will checks the both userid and password if both matches then there will be successful login
			
				//if(userid.equals(password)){
			//int ch= JOptionPane.showConfirmDialog(this, "Welcome "+userid,"Login",JOptionPane.YES_NO_OPTION);
			
			//JOptionPane this is used to pop the message in the screen..this welcome user will be displayed only on a successful login
			if(message.startsWith("Welcome")){
			
			JOptionPane.showMessageDialog(this,message);
			//This will be displayed on the title screen on the mainmenuscreen 
			mainScreenObject.setTitle("Welcome " +userid);
			//This will be done at prepareTitle method in main menu screen
			mainScreenObject.prepareTitle();
			//This doTitle animation will add the revolving animation in title in main menu screen
			mainScreenObject.doTitleAnimation();
			//if(ch==JOptionPane.YES_OPTION){
			//The main menu screen will be enabled then..when on a successful login
			GameMainMenuScreen.mnGames.setEnabled(true);
			//This will set to false on a successful login..the login screen will then be disabled false
			this.setVisible(false);
			//the dispose will destroy the running login program from background after the successful login
			this.dispose();
			}
			else
			{
				JOptionPane.showMessageDialog(this, message);
				return ;
			}
			
			
			
			//}
//		}
//		else{
			//But if the login id and password will not matches then this message will be displayed 
//			JOptionPane.showMessageDialog(this, "Invalid Userid or Password");
//		}
	}
	
	
	
	
	//This is used to as this will reset the complete box 
	private void checkReset(){
		
	}
	
	
	
}	
	
