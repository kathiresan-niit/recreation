package com.example.Musiccontroller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.Customer;
import com.example.service.CustomerService;
import com.example.service.MotoService;

/*
 * this is used for holding the data for user/customer
 */

@Controller
public class CustomerController {
	
	@Autowired
	CustomerService cs;
	
	@ModelAttribute("Cust")
	public Customer construct() {
		return new Customer();
	}

	@RequestMapping(value = "/userRegister", method = RequestMethod.GET)
	public String reg() 
	{
		return "userRegister";
	}

	@RequestMapping(value = "/userRegister", method = RequestMethod.POST)
	public ModelAndView addingTeam(@Valid @ModelAttribute("Cust") Customer Cust, BindingResult br) {
		String ret = null;
		ModelAndView mv=null;
		System.out.println("reg add " + br + " " + Cust.getMail() + " --");
		if (br.hasErrors()) {
			System.out.println("br " + br.getErrorCount());
			ret = "userRegister";
			mv=new ModelAndView(ret);
			mv.addObject("msg","errors");
		}
		else{
			cs.addCustomer(Cust);
			ret="index";
			mv=new ModelAndView(ret);
		}
		return mv;
	}
	
}
