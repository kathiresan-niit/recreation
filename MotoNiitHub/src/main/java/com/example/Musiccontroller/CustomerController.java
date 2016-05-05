package com.example.Musiccontroller;

import java.util.LinkedHashSet;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
//@RequestMapping(value="/userRegister")
public class CustomerController {
	@ModelAttribute("Cust")
	public Customer construct() {
		return new Customer();
	}
	@RequestMapping("/userRegister")
	public ModelAndView reg(ModelMap m){
		System.out.println("(*(*(*");
		ModelAndView modelAndView = new ModelAndView("userRegister");
		m.addAttribute("Cust", new Customer());
		return modelAndView;
	}
	
	@Autowired
	private MotoService mservice;
	
	@Autowired
	private SessionFactory sf;
	
//	@RequestMapping("/userRegister")
//	public String Register(){
//		return "userRegister";
//	}
	
	@Transactional
	@RequestMapping(value = "/userprocess", method = RequestMethod.POST)	
	public String addingTeam(@Valid  Customer Cust, BindingResult br) {
		String ret=null;
System.out.println("reg add "+br+" "+Cust.getMail()+" --");
		if(br.hasErrors()){
			ret="/userRegister";	
		}
		else{
		Customer c=new Customer();
		c.setUname(Cust.getUname());
		c.setMail(Cust.getMail());
		c.setCpassword(Cust.getCpassword());
		c.setPass(Cust.getPass());
		Integer id=genrandomid();
		c.setId(id);
		System.out.println(id);
		admin a=new admin();
		a.setUserid(genadminrandomid());
		a.setRole("ROLE_USER");
		a.setUserroleid(id);
		sf.getCurrentSession().save(c);
		sf.getCurrentSession().save(a);	
		ret="index";
		}
		
		return ret;
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
	
//	hibvalidcontroller validator = null;
//    public hibvalidcontroller getValidator() {
//    	
//	
//	        return validator;
//	
//	    }
//	 @Autowired
//	 public void setValidator(hibvalidcontroller validator) {
//	
//	        this.validator = validator;
//	
//	    }
//	
//	 
//	
//	    @RequestMapping(method=RequestMethod.GET)
//	
//	    public String showForm(ModelMap model){
//	
//	    	Customer userRegis = new Customer();
//	
//	        model.addAttribute("Registration", userRegis);
//	
//	       return "registration";
//	
//	    }
//	
//	 
//	
//	    @RequestMapping(method=RequestMethod.POST)
//	
//	    public String processForm(@ModelAttribute(value="Registration") @Valid Customer userRegis,BindingResult result){
//	
//		validator.validate(userRegis, result);
//	
//	        if(result.hasErrors()){
//		           return "userRegister";
//	
//	        }else{
//	
//	           return "anonymous";
//	
//	        }
//	
//	    }
//	
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
