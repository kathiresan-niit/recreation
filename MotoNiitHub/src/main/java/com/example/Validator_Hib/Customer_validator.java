package com.example.Validator_Hib;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.model.Customer;

@Controller
@RequestMapping("/userRegister")
public class Customer_validator {
	
	@RequestMapping(method = RequestMethod.GET)
		public String initForm(Model model) {
		System.out.println("in user reg");
			Customer c = new Customer();
			model.addAttribute("form", c);
			return "userRegister";
		}

		@RequestMapping(method = RequestMethod.POST)
		public String submitForm(@Valid Customer form, BindingResult result) {
			String returnVal = "anonymous";
			if(result.hasErrors()) {
				returnVal = "userRegister";
			}
			return returnVal;
		}

}


