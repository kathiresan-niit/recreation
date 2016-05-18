package com.example.Musiccontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.example.Dao.CartItemDao;
import com.example.Dao.CustomerDao;
import com.example.model.Customer;
import com.example.model.Motorola;
import com.example.model.UserCart;
import com.example.service.MotoService;

import com.example.model.*;

@Controller
public class CartController {

	@Autowired
	private MotoService mservice;
	@Autowired
	private CustomerDao cd;
	@Autowired
	private CartItemDao citem;
	
	@RequestMapping(value = "/view/{id}")
	public String disp(@PathVariable Integer id,Model model){
		
		Motorola teams =mservice.getProd(id);
		//ModelAndView mv=new ModelAndView("viewsingleproduct");
		model.addAttribute("team", teams);
		return "viewsingleproduct";
		
	}
	@RequestMapping("/viewsingleproduct")
	public String disp(){
		 //ModelAndView mv=new ModelAndView("viewsingleproduct");
		 return "viewsingleproduct";
	}
	
	// rest services for add and remove cart
	
		
}
