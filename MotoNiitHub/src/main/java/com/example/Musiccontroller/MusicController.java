package com.example.Musiccontroller;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.Customer;
import com.example.model.Motorola;
import com.example.service.MotoService;
import com.example.service.MotoServiceImpl;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

@Controller
public class MusicController {

	@Autowired
	private MotoService mservice;

	/*
	 * adding below method to perform insert logic
	 */

	@ModelAttribute("team")
	public Motorola construct() {
		return new Motorola();
	}

	@RequestMapping(value = "/team/add")
	public ModelAndView addTeamPage() {
		ModelAndView modelAndView = new ModelAndView("addProduct");
		modelAndView.addObject("team", new Motorola());
		return modelAndView;
	}

	@RequestMapping(value = "/process")
	public @ResponseBody ModelAndView addingTeam(@ModelAttribute Motorola team, HttpServletRequest request) {

		/*
		 * adding image path and image system 
		 * 		 * 
		 */

		String ctxpath,rp,path="";
		rp=request.getRealPath("/");
		File f = new File(path);
		String ret = "";
		String message = "";
		if (!team.getF().isEmpty()) {
			try {
				String filename = team.getF().getOriginalFilename();
				byte[] bytes = team.getF().getBytes();
				BufferedOutputStream buffStream = new BufferedOutputStream(new FileOutputStream(f));
				buffStream.write(bytes);
				buffStream.close();
				team.setImgpath(path);
				mservice.addProd(team);
				message = "product was successfully added.";
				System.out.println("in add if");
				ret = "adminLandingpage";
			} catch (Exception e) {
				System.out.println("in add else -  catch"+e);
				ret = "error";
				message = "excep";
			}
		} else {
			System.out.println("in add else");
			ret = "error";
			message = "error uploading";
			// return "Unable to upload. File is empty.";
		}
		ModelAndView modelAndView = new ModelAndView(ret);
		System.out.println("return val "+ret);
		modelAndView.addObject("message", message);
		return modelAndView;
	}
	@RequestMapping("/n")
	 public String disp(){
		 return "n";
	 }
	@RequestMapping(value = "/list")
	public ModelAndView listOfTeams(@RequestParam("cat") String catog) {
		ModelAndView modelAndView = new ModelAndView("ListProducts");
		// SendEmail("n.kathiresan@niit.com", "n.kathiresan@niit.com", "hi",
		// "hello");
		List<Motorola> teams = mservice.getAllProd(catog);
		System.out.println("in list meth"+teams.size() + " " + teams.get(2	).getCategory());
		modelAndView.addObject("team", teams);

		return modelAndView;
	}

	@RequestMapping(value = "/listall")
	public ModelAndView listOfTeams() {
		ModelAndView modelAndView = new ModelAndView("ListProducts");
		// SendEmail("n.kathiresan@niit.com", "n.kathiresan@niit.com", "hi",
		// "hello");
		List<Motorola> teams = mservice.getAllProd();
		System.out.println(teams.size() + " " + teams.get(2).getImgpath());
		modelAndView.addObject("team", teams);

		return modelAndView;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editTeamPage(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("editProduct");
		Motorola team = mservice.getProd(id);
		System.out.println("in msctlr edit get" + team.getCategory());
		modelAndView.addObject("team", team);
		return modelAndView;
	}
	
	/*
	 * this method is to handle the post request from edit page 
	 * @path variable is used to get values from url
	 * */

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public String edditingTeam(@ModelAttribute Motorola team, @PathVariable Integer id) {

		//ModelAndView modelAndView = new ModelAndView("redirect:ListProducts");
		System.out.println("uuu " + team.getPrice());
		mservice.updateProd(team);

		String message = "product was successfully edited.";
		new ModelMap().addAttribute("message", message);

		return "redirect:ListProducts";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteTeam(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("anonymous");
		mservice.deleteProd(id);
		//List<Motorola> teams = mservice.getAllProd();
		System.out.println("in del");
		String message = "Team was successfully deleted.";
		modelAndView.addObject("message", message);
		//modelAndView.addObject("team", teams);
		return modelAndView;
	}

	@RequestMapping("home")
	public String home(){
		return "index";
	}
}
