package com.App.Sneka.Project.Response;

import java.util.HashMap;

public class ResponseHandle {
	
	public static   HashMap<String, Object> responseHandler(String message, String httpStatus, Object responseObject)
	{
		HashMap<String, Object> responseData = new HashMap<>();
		responseData.put("data", responseObject);
		responseData.put("Message", message);
		responseData.put("HttpStatus", httpStatus);
		
		return responseData;
	}
	
	public static   HashMap<String, Object> getAllResponseHandler(String message, String httpStatus, Object responseObject)
	{
		HashMap<String, Object> responseData = new HashMap<>();
		responseData.put("data", responseObject);
		responseData.put("Message", message);
		responseData.put("HttpStatus", httpStatus);
		
		return responseData;
	}
	
	public static   HashMap<String, Object> createResponseHandler(String message, String httpStatus)
	{
		HashMap<String, Object> responseData = new HashMap<>();
		responseData.put("Message", message);
		responseData.put("HttpStatus", httpStatus);
		
		return responseData;
	}
	
	
	public static   HashMap<String, Object> updateResponseHandler(String message, String httpStatus)
	{
		HashMap<String, Object> responseData = new HashMap<>();
		responseData.put("Message", message);
		responseData.put("HttpStatus", httpStatus);
		
		return responseData;
	}
	
	public static   HashMap<String, Object> deleteResponseHandler(String message, String httpStatus)
	{
		HashMap<String, Object> responseData = new HashMap<>();
		responseData.put("Message", message);
		responseData.put("HttpStatus", httpStatus);
		return responseData;
	}


}
