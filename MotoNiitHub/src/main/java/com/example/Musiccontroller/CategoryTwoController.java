package com.example.Musiccontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.Motorola;
import com.example.service.MotoService;

@RestController
public class CategoryTwoController {

	@Autowired
	private MotoService mservice;
	
	 //@RequestMapping(value = "/cat2", method = RequestMethod.GET,headers="Accept=application/json")
		@RequestMapping(value = "/cat2/{name}", method = RequestMethod.GET)
		public List getCat2(@PathVariable String name) {			
			//ModelAndView modelAndView = new ModelAndView("n");
			List<Motorola> teams = mservice.getAllProd(name);
			//System.out.println("in list meth"+teams.size() + " " + teams.get(0).getCategory());
			//modelAndView.addObject("team", teams);
			System.out.println(teams);
			 return teams;
	 
	 }
//	 public List  listOfTeams(@RequestParam("cat") String catog) {
//		ModelAndView modelAndView = new ModelAndView("n");
//		List<Motorola> teams = mservice.getAllProd(catog);
//		//System.out.println("in list meth"+teams.size() + " " + teams.get(0).getCategory());
//		//modelAndView.addObject("team", teams);
//		System.out.println(teams);
//		 return teams;
//	}
	 
	
}
