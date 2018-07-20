package com.game;


//The loginView validation is done here
//means userid should be enter here and like password should be 8 characters each
public class UserValidation {
	//This is used for the Login should not be left blank
	public static boolean isBlank(String value){
		//this if condition is used if value is not null and it is greater than 0 length then returns false otherwise check condition
		if(value!=null && value.trim().length()>0){
			return false;
		}
		return true;
	}
	
	//This is used for password minimum length
	public static boolean checkMinLength(String value, int minLength){
		//this if condition checks that if length is less than min length than returns true..it is of min length
		if(value.length()<minLength){
			return true;
		}
		//else returns the false
		else{
			return false;
		}
	}

}
