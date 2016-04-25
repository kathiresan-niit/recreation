package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="user_authorization")
public class admin {

	@Id
	@GeneratedValue
	private Integer userid;
	
	private Integer userroleid;
	
	private String role;

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public Integer getUserroleid() {
		return userroleid;
	}

	public void setUserroleid(Integer userroleid) {
		this.userroleid = userroleid;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
	
}
