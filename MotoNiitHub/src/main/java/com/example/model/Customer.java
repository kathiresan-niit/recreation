package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String uname;

	//@NotNull(message = "Please select a password")
	//@Length(min = 5, max = 10, message = "Password should be between 5 - 10 charactes")
	private String pass;

	//@NotNull(message="Please select a password")
	//@Length(min=5, max=10, message="Password should be between 5 - 10 charactes")
	private String cpassword;

	//@Pattern(regexp = ".+@.+\\..+", message = "Wrong email!")
	private String mail;

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getCpassword() {
		return cpassword;
	}

	public void setCpassword(String cpassword) {
		this.cpassword = cpassword;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getId() {
		return id;
	}
	public Customer() {
		// TODO Auto-generated constructor stub
	}
	
}
