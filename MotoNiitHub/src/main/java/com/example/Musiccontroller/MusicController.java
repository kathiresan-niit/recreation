package com.example.Musiccontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.Motorola;
import com.example.service.MotoService;

@Controller
public class MusicController {
	
	@Autowired
	private MotoService mservice;

	/*
	 * adding below method to perform insert logic
	 */
	@ModelAttribute("team")
	public Motorola construct(){
		return new Motorola();
	}
	@RequestMapping(value="/team/add")
	public ModelAndView addTeamPage() {
		ModelAndView modelAndView = new ModelAndView("addProduct");
		modelAndView.addObject("team", new Motorola());
		return modelAndView;
	}
	@RequestMapping(value="/team/add/process")
	public ModelAndView addingTeam(@ModelAttribute Motorola team) {

		ModelAndView modelAndView = new ModelAndView("adminLandingpage");
		mservice.addProd(team); 

		String message = "Team was successfully added.";
		modelAndView.addObject("message", message);

		return modelAndView;
	}

	@RequestMapping(value="/team/list")
	public ModelAndView listOfTeams() {
		ModelAndView modelAndView = new ModelAndView("ListProducts");

		List<Motorola> teams = mservice.getAllProd();
System.out.println(teams.size()+" "+teams.get(0).getCategory());
		modelAndView.addObject("team", teams);

		return modelAndView;
	}

	@RequestMapping(value="/team/edit/{id}", method=RequestMethod.GET)
	public ModelAndView editTeamPage(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("ListProducts");
		Motorola team = mservice.getProd(id);
		modelAndView.addObject("team",team);
		return modelAndView;
	}

	@RequestMapping(value="/team/edit/{id}", method=RequestMethod.POST)
	public ModelAndView edditingTeam(@ModelAttribute Motorola team, @PathVariable Integer id) {

		ModelAndView modelAndView = new ModelAndView("home");

		mservice.updateProd(team);

		String message = "Team was successfully edited.";
		modelAndView.addObject("message", message);

		return modelAndView;
	}
	@RequestMapping(value="/team/delete/{id}", method=RequestMethod.GET)
	public ModelAndView deleteTeam(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("home");
		mservice.deleteProd(id);
		String message = "Team was successfully deleted.";
		modelAndView.addObject("message", message);
		return modelAndView;
	}
}

