package com.game;

import java.io.Serializable;

//To convert the object into the binary file it is Serializable 
public class User implements Serializable{

	/*
	 SerialVersionUID is used here because Whenever we want to write in a file in serialization it gives a serial no to the class
	 But if we make changes to its parent class then it will gives us error when we do the deserilizable
	 
	 */
	private static final long serialVersionUID = 1L;
	
	//For User Registration and all
	private String userid;
	private String password;
	private String gender;
	private String address;
	private String country;
	int age;
	
	//transient is used here because by using this word it would be never store in a file
	//This is done because we want some data to not store in the file so make it transient 
	//Now this would be store in a string format
	private transient String pinCode="110034";
	//This would also be transient because we do not want to store in the file..calculations part would also be transient
	private transient int calc;
		
	private String status;


	//Constructor for user is being made
	public User(){
		
	}
	
	public User(String userid, String password, String gender, String address, String country){
		this.userid = userid;
		this.password = password;
		this.gender = gender;
		this.address = address;
		this.country = country;
	}
	
	
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	
}
