package com.App.Sneka.Project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.App.Sneka.Project.Entry.UserEntry;

public interface UserDataRepo extends JpaRepository<UserEntry, String>{
	  


}
