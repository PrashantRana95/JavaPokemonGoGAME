package com.game;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JOptionPane;

public class UserOperations {
	
	
	public static String isUserExist(User userObject) throws ClassNotFoundException, IOException{
		String path = "F:\\Prashant\\Experiments\\JAVA\\GameApp\\users.dat";
		File file = new File(path);
		/*if(!file.exists()){
			return "User DB (File) is Not Exist , so u can't Login";
			//System.exit(0);
		}
		else{*/

			//FileInputStream is used for reading streams of bytes from files
			FileInputStream fs = new FileInputStream(file);
			//ObjectInputStream is used to convert the binary to object
			//it is basically the opposite of serializable
			//it is deserialization
			ObjectInputStream os = new ObjectInputStream(fs);
			//readObject from ObjectInputStream
			User user = (User)os.readObject();
			if(user!=null  && 
					(user.getUserid().equals(userObject.getUserid()) 
					&& user.getPassword().equals(userObject.getPassword()))){
				return "Welcome User "+user.getUserid();
			}
		//}
		return "Invalid Userid or Password ";
	}

	
	public static boolean registerUser(User userObject) throws IOException{
		String path = "F:\\Prashant\\Experiments\\JAVA\\GameApp\\users.dat";
		File file = new File(path);
		/*FileOutputStream is used to write the file in the binary format  
		  it is basically used to write the streams of data(binary data) into the file
		 */
		FileOutputStream fs = new FileOutputStream(file);  // Binary Write in a File
		//ObjectOutputStream only converts the object to the binary
		//Its works is being done by the writeObject method...write object creates the binary file
		/* ObjectOutputStream checks if object's parent is Serializable
		 Serializable is basically a marker interface
		 */
		ObjectOutputStream os = new ObjectOutputStream(fs);  // Convert Object into Binary
		try{
		//it basically do and creates the Binary File
			//This method is present inside the ObjectOutputStream class
			//But the whole work is done by the writeObject
			os.writeObject(userObject);
		}
		finally{
		os.close();
		fs.close();
		}
		return true;
	}

}