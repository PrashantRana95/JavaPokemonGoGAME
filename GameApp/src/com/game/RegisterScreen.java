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
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.TextArea;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegisterScreen extends JFrame {

	private JPanel contentPane;
	private JTextField useridtxt;
	private JPasswordField passwordField;
	//Used for password weak or strong 
	JLabel weakStronglbl = new JLabel("");
	//maxChars should be only 50
	int maxChars = 50;
	JTextArea textArea = new JTextArea();
	//and the value of leftChar sets to 50
	int leftChar = maxChars;
	JLabel leftChars = new JLabel("50");
	JRadioButton rdbtnMale = new JRadioButton("Male");
	JRadioButton rdbtnFemale = new JRadioButton("Female");
	JComboBox comboBox = new JComboBox();
	JLabel useriderror = new JLabel("");
	JLabel pwderror = new JLabel("");
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	
		RegisterScreen frame = new RegisterScreen();
		frame.setVisible(true);

	}

	/**
	 * Create the frame.
	 */
	public RegisterScreen() {
		setLocationRelativeTo(null);
		
		//It is set to false now it will not be maximize
		setResizable(false);
		setTitle("Register Screen");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 510, 648);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		JLabel lblUserId = new JLabel("User ID");
		lblUserId.setFont(new Font("Bodoni MT Condensed", Font.BOLD, 17));
		lblUserId.setBounds(82, 128, 46, 27);
		contentPane.add(lblUserId);
		
		JLabel lblRegister = new JLabel("");
		lblRegister.setIcon(new ImageIcon(RegisterScreen.class.getResource("/com/images/Register-Button-PNG-Photos.png")));
		lblRegister.setFont(new Font("Bodoni MT Condensed", Font.BOLD, 22));
		lblRegister.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegister.setBounds(107, 11, 305, 63);
		contentPane.add(lblRegister);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Bodoni MT Condensed", Font.BOLD, 17));
		lblPassword.setBounds(65, 195, 67, 14);
		contentPane.add(lblPassword);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(RegisterScreen.class.getResource("/com/images/People.png")));
		label.setBounds(140, 120, 35, 35);
		contentPane.add(label);
		
		useridtxt = new JTextField();
		useridtxt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER){
					passwordField.requestFocus();
				}
			}
		});
		useridtxt.setBounds(212, 125, 139, 28);
		contentPane.add(useridtxt);
		useridtxt.setColumns(10);
		
		useriderror.setForeground(Color.RED);
		useriderror.setBounds(212, 107, 139, 14);
		contentPane.add(useriderror);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(RegisterScreen.class.getResource("/com/images/pass.png")));
		label_2.setBounds(142, 183, 35, 35);
		contentPane.add(label_2);
		
		passwordField = new JPasswordField();
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				weakStrongPasswordCheck();
			}
		});
		passwordField.setBounds(212, 190, 139, 28);
		contentPane.add(passwordField);
		
		
		pwderror.setForeground(Color.RED);
		pwderror.setBounds(214, 171, 173, 14);
		contentPane.add(pwderror);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setHorizontalAlignment(SwingConstants.CENTER);
		lblGender.setFont(new Font("Bodoni MT Condensed", Font.BOLD, 17));
		lblGender.setBounds(65, 246, 63, 20);
		contentPane.add(lblGender);
		
		//RadioButton is set here
		
		rdbtnMale.setBounds(179, 247, 67, 23);
		contentPane.add(rdbtnMale);
		
		rdbtnFemale.setBounds(302, 247, 85, 23);
		contentPane.add(rdbtnFemale);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(RegisterScreen.class.getResource("/com/images/People.png")));
		label_3.setBounds(140, 240, 35, 35);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(RegisterScreen.class.getResource("/com/images/female.png")));
		label_4.setBounds(261, 240, 35, 35);
		contentPane.add(label_4);
		
		JLabel lblCountry = new JLabel("Country");
		lblCountry.setFont(new Font("Bodoni MT Condensed", Font.BOLD, 17));
		lblCountry.setHorizontalAlignment(SwingConstants.CENTER);
		lblCountry.setBounds(65, 293, 63, 27);
		contentPane.add(lblCountry);
		
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"India", "SriLanka", "Nepal"}));
		comboBox.setBounds(192, 298, 118, 20);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(RegisterScreen.class.getResource("/com/images/earth.png")));
		lblNewLabel_1.setBounds(140, 291, 35, 35);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddress.setFont(new Font("Bodoni MT Condensed", Font.BOLD, 17));
		lblAddress.setBounds(65, 348, 63, 27);
		contentPane.add(lblAddress);
		
		JLabel label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon(RegisterScreen.class.getResource("/com/images/location.png")));
		label_5.setBounds(140, 341, 35, 35);
		contentPane.add(label_5);
		
		weakStronglbl.setForeground(Color.GREEN);
		weakStronglbl.setBounds(361, 197, 107, 14);
		contentPane.add(weakStronglbl);
		
		JLabel lblNoOfCharacters = new JLabel("No. Of Characters");
		lblNoOfCharacters.setBounds(243, 525, 101, 14);
		contentPane.add(lblNoOfCharacters);
		
		leftChars.setBounds(366, 525, 46, 14);
		contentPane.add(leftChars);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doRegister();
			}
		});
		btnRegister.setIcon(new ImageIcon(RegisterScreen.class.getResource("/com/images/Register.png")));
		btnRegister.setBounds(82, 550, 139, 58);
		contentPane.add(btnRegister);
		
		JButton btnNewButton = new JButton("Clear");
		btnNewButton.setIcon(new ImageIcon(RegisterScreen.class.getResource("/com/images/077427-black-inlay-crystal-clear-bubble-icon-business-trashcan3.png")));
		btnNewButton.setBounds(302, 550, 139, 58);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(185, 351, 256, 160);
		contentPane.add(scrollPane);
		
		
		textArea.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				computeNoOfCharLeft();
			}
		});

		
		//For scrollpane and textarea we have to manually write this code
		scrollPane.setViewportView(textArea);
		
		
		//textArea.setBounds(185, 351, 256, 160);
		//contentPane.add(textArea);
	}
	
	
	//This method is used for counting no of characters
	private void computeNoOfCharLeft(){
		if(leftChar>0){
		 leftChar = maxChars - textArea.getText().length();
		 leftChars.setText(String.valueOf(leftChar));
		}
		if(leftChar==0){
			textArea.setEnabled(false);
		}
		
	}
	
	//This method is used to check the strong weak password
	private void weakStrongPasswordCheck(){
		//using this we will get passwordfield data
		String data = passwordField.getText();
		//This will check the length of data
		if(data.length()<5){
			weakStronglbl.setText("Weak");
		}
		if(data.length()>=5 && data.length()<=10){
			weakStronglbl.setText("Average");
		}
		if(data.length()>10){
			weakStronglbl.setText("Strong");
		}
	}
	
	//Register button will perform this functionality
	private void doRegister(){
		
		//This isValidationFail will tell us weather or not validation checks or not
		boolean isValidationFail = false;
				
		
		
		String userid = useridtxt.getText();
		String password = passwordField.getText();
		String gender ="";
		//this will show gender = male else female
		if(rdbtnMale.isSelected()){
			gender = "Male";
		}
		else
		if(rdbtnFemale.isSelected()){
			gender = "Female";
		}
		String country = (String)comboBox.getSelectedItem();
		String address = textArea.getText();
		
		User user = new User(userid, password, gender, address,country);
		try {
			boolean isRegister = UserOperations.registerUser(user);
			if(isRegister){
				JOptionPane.showMessageDialog(this, "U Register SuccessFully");
				this.setVisible(false);
				this.dispose();
				GameMainMenuScreen.mntmRegister.setVisible(false);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this, "Can't Register Error in File Creation...");
			e.printStackTrace();
		}
		
		
		
//		//Here all the Validation Works about min characters and all with password things
//		
//		
//				//This will take the isBlank method from the UserValidation class..as for static method they do not require the object creation
//		if(UserValidation.isBlank(userid)){
//			//We would then print this in the useriderror label
//			useriderror.setText("UserID Can't be Blank");
//			isValidationFail = true;
//		}
//		//else condition checks that if above fails then login must have some data so false then blank field
//		else{
//			useriderror.setText("");
//		}
//		if(UserValidation.checkMinLength(password, 8)){
//			pwderror.setText("Password must be 8 characters each");
//			isValidationFail = true;
//		}
//		else
//		{
//			pwderror.setText("");
//		}
//		if(isValidationFail){
//			return ;
//		}
						
		
		
		
	}
	
	
}
