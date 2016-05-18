package com.example.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

@Entity(name="users1")
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String uname;
	private boolean enabled;
	@NotNull(message = "Please select a password")
	@Length(min = 5, max = 10, message = "Password should be between 5 - 10 charactes")
	private String pass;

	@NotNull(message="Please select a password")
	@Length(min=5, max=10, message="Password should be between 5 - 10 charactes")
	private String cpassword;

	@Pattern(regexp = ".+@.+\\..+", message = "Wrong email!")
	private String mail;

	private String address;
	private String mobile;
	private String billaddress;
	private int pin;

	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cartId")
	private UserCart ucart;
	
	
	public UserCart getUcart() {
		return new UserCart();
	}

	public void setUcart(UserCart ucart) {
		this.ucart = ucart;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getBilladdress() {
		return billaddress;
	}

	public void setBilladdress(String billaddress) {
		this.billaddress = billaddress;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}
/*
	public UserCart getUcart() {
		return ucart;
	}

	public void setUcart(UserCart ucart) {
		this.ucart = ucart;
	}
*/
	public boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

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
