package com.example.Musiccontroller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.Motorola;
import com.example.service.MotoService;
import com.example.service.MotoServiceImpl;

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
	public @ResponseBody ModelAndView addingTeam(@ModelAttribute Motorola team,HttpServletRequest request) {
		
		/*
		 * adding image path and image
		 * 
		 * */
		String filename=null;
        System.out.println("in processs img");
        ServletContext context=request.getServletContext();
        String path=context.getRealPath("./resources/upload.jpg");
        System.out.println("Path = "+path);
        System.out.println("File name = "+team.getF().getOriginalFilename());
        File f=new File(path);
       String ret="";
       String message = "";
        if (!team.getF().isEmpty()) {
            try {
                filename = team.getF().getOriginalFilename();
                byte[] bytes = team.getF().getBytes();
                BufferedOutputStream buffStream =new BufferedOutputStream(new FileOutputStream(f));
                buffStream.write(bytes);
                buffStream.close();
                team.setImgpath(path);
                mservice.addProd(team);
                message="Team was successfully added.";
                ret ="adminLandingpage";
            } catch (Exception e) {
            	ret ="error";
                message="excep";
            }
        } else {
        	ret ="error";
        	message="error uploading";
            //return "Unable to upload. File is empty.";
        }
		ModelAndView modelAndView = new ModelAndView(ret);
		modelAndView.addObject("message", message);
		return modelAndView;
	}

	@RequestMapping(value="/team/list")
	public ModelAndView listOfTeams() {
		ModelAndView modelAndView = new ModelAndView("ListProducts");
		SendEmail("n.kathiresan@niit.com","n.kathiresan@niit.com","hi","hello");
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
	@Autowired
	private static MailSender cm; // MailSender interface defines a strategy
	// for sending simple mails

public static void  SendEmail(String toAddress, String fromAddress, String subject, String msgBody) {
System.out.println("mail "+cm);
SimpleMailMessage mail= new SimpleMailMessage();
mail.setFrom(fromAddress);
mail.setTo(toAddress);
mail.setSubject(subject);
mail.setText(msgBody);
cm.send(mail);
}
}

