package com.example.Musiccontroller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.LinkedHashSet;
import java.util.Random;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.hibernate.SessionFactory;
import org.hibernate.mapping.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.Customer;
import com.example.model.Motorola;
import com.example.model.admin;
import com.example.service.MotoService;


/*
 * this is used for holding the data for user/customer
 */
@Controller
public class CustomerController {
	@Autowired
	private MotoService mservice;
	
	@Autowired
	private SessionFactory sf;
	
	@RequestMapping("/userRegister")
	public String Register(){
		return "userRegister";
	}
	@Transactional
	@RequestMapping("/team/userprocess")
	public String Register1(@RequestParam("uname") String name,@RequestParam("pass") String pass,@RequestParam("cpassword") String cpass,@RequestParam("mail") String email){
		Customer c=new Customer();
		c.setUname(name);
		c.setMail(email);
		c.setCpassword(cpass);
		c.setPass(pass);
		Integer id=genrandomid();
		c.setId(id);
		System.out.println(id);
		admin a=new admin();
		a.setUserid(genadminrandomid());
		a.setRole("ROLE_USER");
		a.setUserroleid(id);
		sf.getCurrentSession().save(c);
		sf.getCurrentSession().save(a);		
		return "userRegister";
	}
	/*
	 * 
	 * generates random numbers that can be generated for userid
	 * */
	public Integer genrandomid(){
		Random rng = new Random(); // Ideally just create one instance globally
		// Note: use LinkedHashSet to maintain insertion order
		LinkedHashSet<Integer> generated = new LinkedHashSet<Integer>();
		while (generated.size() < 10000)
		{
		    Integer next = rng.nextInt(20000) + 1;
		    // As we're adding to a set, this will automatically do a containment check
		    generated.add(next);
		}
		System.out.println("in gen random pwd "+generated.iterator().next());
		return generated.iterator().next();
		
		
	}
	/*
	 * 
	 * generates the id for admin
	 * */
	public Integer genadminrandomid(){
		Random rng = new Random(); // Ideally just create one instance globally
		// Note: use LinkedHashSet to maintain insertion order
		LinkedHashSet<Integer> generated = new LinkedHashSet<Integer>();
		while (generated.size() < 10000)
		{
		    Integer next = rng.nextInt(20000) + 1;
		    // As we're adding to a set, this will automatically do a containment check
		    generated.add(next);
		}
		System.out.println("in gen random pwd "+generated.iterator().next());
		return generated.iterator().next();
		
		
	}
	
}
	//@Autowired
//	private MotoService mservice;
//	@Autowired
//	private SessionFactory sf;
//	
//	@ModelAttribute("Customer")
//	public Customer construct() {
//		return new Customer();
//	}
//	
//	@RequestMapping("/userRegister")
//	public @ResponseBody ModelAndView Register(@ModelAttribute Customer team){
//		System.out.println("in user reg");
//		ModelAndView modelAndView = new ModelAndView("userRegister");
//		modelAndView.addObject("Customer", new Customer());
//		return modelAndView;
//		
//	}
//	
//	@RequestMapping(value = "/team/userprocess")
//	public @ResponseBody ModelAndView addingUser(@ModelAttribute Customer team) {
//		
//		sf.getCurrentSession().save(team);
//				String message = "Team was successfully added.";
//		ModelAndView modelAndView = new ModelAndView("index	");
//		modelAndView.addObject("message", message);
//		return modelAndView;
//	}
//}
