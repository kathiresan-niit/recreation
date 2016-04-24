package com.example.Musiccontroller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LinkController 
{

	@RequestMapping(value="index")
	public String Landingpage2()
	{
		return "index";
	}
	@RequestMapping(value="/")
	public String Landingpage()
	{
		return "index";
	}
	@RequestMapping(value="/adminLogin")
	public String gett(){
		return "adminLogin";
	}
	  @RequestMapping(value="/login")
	  public String login(@RequestParam (value="error", required = false) String error,
	                       @RequestParam (value="logout", required = false) String logout, Model model
	                       ) {
		  String ret="";
		  System.out.println("in admin login");
	       if(error != null) {
	    	   ret="error";
	    	   System.out.println("errrr");
	           model.addAttribute("error", "Invalid username and password!");
	       }
	       else if(error==null){
	    	   System.out.println("succ");
	    	   ret="adminLandingpage";
	    	   model.addAttribute("error", "Success!");
	       }
	       if(logout!= null) {
	    	   
	           model.addAttribute("msg", "You have been logged out successfully.");
	       }

	       return ret;
	   }

    @RequestMapping(value="/adminLandingpage")
    public ModelAndView indexPage() {
System.out.println("i n lnd");
        return new ModelAndView("adminLandingpage");
    }
    @RequestMapping(value="/error")
    public String errgen(){
    	return "error";
    }
}
