package com.game;

import java.io.PrintWriter;
import java.io.StringWriter;

//This is basically used for Logger class

public interface CommonUtils {
	public static String getPrintStackTrace(Exception e){
		//StringWriter writes upon the string
		StringWriter sw = new StringWriter();
		//PrintWriter integrates with StringWriter
		PrintWriter pw = new PrintWriter(sw);
		//This line used to write in catch block then it will writes in the console prints upon the console
		//Basically prints the data upon the console
		e.printStackTrace(pw);
		//it will converts to tostring method into some meaningful data
		return sw.toString();
	}
}
