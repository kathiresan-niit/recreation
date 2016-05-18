package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="user_authorize")
public class admin {

	
	private Integer user_id;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer user_role_id;
	
	private String role;

	public Integer getUserid() {
		return user_id;
	}

	public void setUserid(Integer userid) {
		this.user_id = userid;
	}

	public Integer getUserroleid() {
		return user_role_id;
	}

	public void setUserroleid(Integer userroleid) {
		this.user_role_id = userroleid;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
	
}
