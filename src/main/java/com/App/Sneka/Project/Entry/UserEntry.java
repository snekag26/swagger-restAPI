package com.App.Sneka.Project.Entry;

import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name ="login")

public class UserEntry {
	
    @Id
    private String id;
	
	private String fullName;
	
	private String emailId;
	
	private Date loginDate;
    
	public UserEntry(String fullName, String emailId, Date loginDate) {
		super();
		this.fullName = fullName;
		this.emailId = emailId;
		this.loginDate = loginDate;
	}
	
	public UserEntry() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

 	public Date getLoginDate() {
		return loginDate;
	}

	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserEntry other = (UserEntry) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "UserEntry [id=" + id + "]";
	}
	
	
}
