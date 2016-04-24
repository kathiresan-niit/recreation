package com.example.Musiccontroller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
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



    @RequestMapping(value="/adminLandingpage")

    public ModelAndView indexPage() {
System.out.println("i n lnd");
        return new ModelAndView("adminLandingpage");

    }
}
