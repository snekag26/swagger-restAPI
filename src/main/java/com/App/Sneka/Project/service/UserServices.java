package com.App.Sneka.Project.service;

import java.util.List;

import com.App.Sneka.Project.Entry.UserEntry;

public interface UserServices 
{
	
	public UserEntry getUserDetails(String userId) ;
	
	public List<UserEntry> getAllUserDetails() ;
	
	public String createUserDetails(UserEntry userDetails ) ;
	
	public String  updateUserDetails(UserEntry userDetails, String id) ;

	public String deleteUserDetails(String id);
	

}
