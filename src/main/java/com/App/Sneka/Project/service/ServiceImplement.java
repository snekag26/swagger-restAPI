package com.App.Sneka.Project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.App.Sneka.Project.Entry.UserEntry;
import com.App.Sneka.Project.Exception.UserDetailsException;
import com.App.Sneka.Project.Repository.UserDataRepo;
import com.App.Sneka.Project.RestConstant.RestApiConstants;

@Service
public class ServiceImplement implements UserServices{
	
	UserDataRepo userDataRepository;

	validateUserDetails validateUser = new validateUserDetails();
	
	public ServiceImplement(UserDataRepo userDataRepository) {
		this.userDataRepository = userDataRepository;
	}

	@Override
	public UserEntry getUserDetails(String userId) {
		Optional<UserEntry> user_ID = userDataRepository.findById(userId);
		if(user_ID.isEmpty()) {
			throw new UserDetailsException("Request User does not exist");
		}
		return user_ID.get();
	}

	@Override
	public List<UserEntry> getAllUserDetails() {
		return 	userDataRepository.findAll();
	}

	@Override
	public String createUserDetails(UserEntry userDetails) {
		String error = validateUser.validateEmailAddress(userDetails.getEmailId());
		//error = validateUser.validateDate(userDetails.getLoginDate().toString(), error );
		error += validateUser.validateName(userDetails.getFullName());
		error += validateUser.validateUserId(userDetails.getId());
		
		if(error.isEmpty())
		{
			String id = userDetails.getId();
			String emailId = userDetails.getEmailId();
			Optional<UserEntry> user_Detail = userDataRepository.findById(id);
			if(user_Detail.isEmpty()) {
		    	userDataRepository.save(userDetails);
			}		
			else
			{
				String user_ID = user_Detail.get().getId();
				String email_Id = user_Detail.get().getEmailId();
			    if(user_ID.equals(id) || email_Id.equals(emailId)) 
			    {
				return "Please give a unique Id Or emailId..Once check with GetUserDetails RestAPi......";
			    }
			    else
			    {
			    	userDataRepository.save(userDetails);
			    }
			}
			return "UserDetails Created SuccessFully";
		}
		return error;
	}

	@Override
	public String updateUserDetails(UserEntry userDetails, String id) {
		Optional<UserEntry> user_detail = userDataRepository.findById(id);
		String userId = null;
		String error = validateUser.validateEmailAddress(userDetails.getEmailId());
		//error = validateUser.validateDate(userDetails.getLoginDate(), error );
		error += validateUser.validateName(userDetails.getFullName());
		error += validateUser.validateUserId(userDetails.getId());
		
		if(error.isEmpty())
		{
			if(!user_detail.isEmpty())
			{
				userId = user_detail.get().getId();
			}
			else 
			{
				return RestApiConstants.updateFailMessage ;
			}
			if(id.equals(userId) && id.equals(userDetails.getId()))
			{
				userDataRepository.save(userDetails);
			}
			else
			{
				return RestApiConstants.updateFailMessage ;
			}
		}
		else {
			return error ;
		}
		return RestApiConstants.updateMessage;
	}

	@Override
	public String deleteUserDetails(String id) {
		Optional<UserEntry> user_ID = userDataRepository.findById(id);
		if(user_ID.isEmpty())
		{
			return "Requested UserDetails does not exist";
		}
		userDataRepository.deleteById(id);
		return "UserDetails are deleted successfully";
	}

}
