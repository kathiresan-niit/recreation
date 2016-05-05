//package com.example.Musiccontroller;
//
//import org.springframework.stereotype.Controller;
//
//import org.springframework.stereotype.Component;
//
//import org.springframework.validation.Errors;
//
//import org.springframework.validation.Validator;
//
//import com.example.model.Customer;
//
//
//
//
//@Component
//public class hibvalidcontroller implements Validator {
//
//		    @Override
//	
//	    public boolean supports(Class c) {
//	
//	        return Customer.class.isAssignableFrom(c);
//	
//	    }
//	
//	 
//	
//	    @Override
//	
//	    public void validate(Object command, Errors errors) {
//	
//	    	Customer regBean = (Customer)command;
//	
//	        if(!regBean.getPass().equals(regBean.getCpassword()))
//	
//	            errors.rejectValue("rePassword","password.notmatch");
//	
//	        }
//	
//	}
//
