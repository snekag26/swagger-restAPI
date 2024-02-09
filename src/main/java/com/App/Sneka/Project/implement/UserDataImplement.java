package com.App.Sneka.Project.implement;
import java.util.HashMap;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.App.Sneka.Project.Entry.UserEntry;
import com.App.Sneka.Project.Response.ResponseHandle;
import com.App.Sneka.Project.RestConstant.RestApiConstants;
import com.App.Sneka.Project.service.UserServices;

@RestController
@RequestMapping("/Userdetails")
public class UserDataImplement 
{
	UserServices userService;

	public UserDataImplement(UserServices userService) {
		super();
		this.userService = userService;
	}

	@GetMapping("{id}")
	public HashMap<String, Object> getUserDetails(@PathVariable("id") String id) 
	{
		return ResponseHandle.responseHandler(RestApiConstants.message, RestApiConstants.httpStatus, userService.getUserDetails(id));
	}
	
	@PostMapping
	public HashMap<String, Object> createUserDetails(@RequestBody UserEntry userDetails) 
	{
		String response =  userService.createUserDetails(userDetails);
		return ResponseHandle.createResponseHandler(response, response.contains("Please")? RestApiConstants.httpFailStatus : RestApiConstants.httpStatus );
	}
	
	@GetMapping
	public HashMap<String, Object> getAllUserDetails() 
	{
		return ResponseHandle.getAllResponseHandler(RestApiConstants.message, RestApiConstants.httpStatus, userService.getAllUserDetails());
	}
	
	@PutMapping("{id}")
	public HashMap<String, Object> UpdateUserDetails(@RequestBody UserEntry userDetails, @PathVariable("id") String id)
	{
		String object = userService.updateUserDetails(userDetails, id);
		return ResponseHandle.updateResponseHandler(object, object.contains("Please")? RestApiConstants.httpFailStatus : RestApiConstants.httpStatus );
		
	}
	
	@DeleteMapping("{id}")
	public HashMap<String, Object> deleteUserDetails(@PathVariable("id") String id)
	{
		String object = userService.deleteUserDetails(id);
		return ResponseHandle.deleteResponseHandler(object, RestApiConstants.httpStatus);
		
	}

}
