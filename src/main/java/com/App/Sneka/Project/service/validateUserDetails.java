package com.App.Sneka.Project.service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class validateUserDetails {
	
	public String validateEmailAddress(String email)
	{
		boolean result = false;

		if( email != null && !email.equals(""))
		{
		String regex ="^[a-z_0-9_.-]+@(.+com)$";
		Pattern pattern = Pattern.compile(regex);
		Matcher macher = pattern.matcher(email);
		result = macher.matches();
		}
		else 
		{
			return "Please enter the EmailId.....";
		}
		if(result != false) 
		{
			return "";
		}
		else 
		{
			return "Please Enter the valide EmailId.....";
		}
		
	}
	
	public String validateDate(String date, String error) {
			boolean result = false;

			if(date != null && !date.isEmpty()) 
			{
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH-mm:ss.SSSH");
				try
				{
					format.parse(date);
					result = true;
				}
				catch(Exception e) {
					error +=  e.getMessage();
				}
			}
			else
			{
				return "Please enter the LoginDate....";

			}
			if(error.isEmpty() && result != false)
			{
				return "";
			}
			else
			{
				return error;
			}
			
		}
		
	public String validateName(String fullName) {
		boolean result = false;

		if(fullName !=null && !fullName.equals("")) {
			String regex = "^[a-zA-Z]*$";
			Pattern pattern = Pattern.compile(regex);
			Matcher macher = pattern.matcher(fullName);
			result = macher.matches();
		}
		else 
		{
			return "Please enter the FullName.....";
		}
		if(result != false) {
			return "";
		}
		else {
			return "Please! Enter the valide FullName.....";
		}
	}
	
	public String validateUserId(String id) {
		boolean result = false;

		if(id !=null && !id.equals("")) {
			String regex = "^[0-9]*$";
			Pattern pattern = Pattern.compile(regex);
			Matcher macher = pattern.matcher(id);
			result = macher.matches();
		}
		else 
		{
			return "Please enter the Id.....";
		}
		if(result != false) {
			return "";
		}
		else {
			return "Please! Enter the valide numerical Id.....";
		}
	}

	}
