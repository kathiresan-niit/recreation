package com.example.Musiccontroller;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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

	@RequestMapping(value = "/team/add/process")
	public @ResponseBody ModelAndView addingTeam(@ModelAttribute Motorola team, HttpServletRequest request) {

		/*
		 * adding image path and image
		 * 
		 */
		String filename = null;
		System.out.println("in processs img");
		ServletContext context = request.getServletContext();
		String path = context.getRealPath("./resources/upload.jpg");
		System.out.println("Path = " + path);
		System.out.println("File name = " + team.getF().getOriginalFilename());
		File f = new File(path);
		String ret = "";
		String message = "";
		if (!team.getF().isEmpty()) {
			try {
				filename = team.getF().getOriginalFilename();
				byte[] bytes = team.getF().getBytes();
				BufferedOutputStream buffStream = new BufferedOutputStream(new FileOutputStream(f));
				buffStream.write(bytes);
				buffStream.close();
				team.setImgpath(path);
				mservice.addProd(team);
				message = "Team was successfully added.";
				ret = "adminLandingpage";
			} catch (Exception e) {
				ret = "error";
				message = "excep";
			}
		} else {
			ret = "error";
			message = "error uploading";
			// return "Unable to upload. File is empty.";
		}
		ModelAndView modelAndView = new ModelAndView(ret);
		modelAndView.addObject("message", message);
		return modelAndView;
	}

	@RequestMapping(value = "/team/list")
	public ModelAndView listOfTeams(@RequestParam("cat") String catog) {
		ModelAndView modelAndView = new ModelAndView("ListProducts");
		// SendEmail("n.kathiresan@niit.com", "n.kathiresan@niit.com", "hi",
		// "hello");
		List<Motorola> teams = mservice.getAllProd(catog);
		System.out.println(teams.size() + " " + teams.get(0).getCategory());
		modelAndView.addObject("team", teams);

		return modelAndView;
	}

	@RequestMapping(value = "/team/list/all")
	public ModelAndView listOfTeams() {
		ModelAndView modelAndView = new ModelAndView("ListProducts");
		// SendEmail("n.kathiresan@niit.com", "n.kathiresan@niit.com", "hi",
		// "hello");
		List<Motorola> teams = mservice.getAllProd();
		System.out.println(teams.size() + " " + teams.get(0).getCategory());
		modelAndView.addObject("team", teams);

		return modelAndView;
	}

	@RequestMapping(value = "/team/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editTeamPage(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("editProduct");
		Motorola team = mservice.getProd(id);
		System.out.println("in msctlr edit get" + team.getCategory());
		modelAndView.addObject("team", team);
		return modelAndView;
	}

	@RequestMapping(value = "/team/edit/{id}", method = RequestMethod.POST)
	public ModelAndView edditingTeam(@ModelAttribute Motorola team, @PathVariable Integer id) {

		ModelAndView modelAndView = new ModelAndView("anonymous");
		System.out.println("uuu "+team.getPrice());
		mservice.updateProd(team);

		String message = "Team was successfully edited.";
		modelAndView.addObject("message", message);

		return modelAndView;
	}

	@RequestMapping(value = "/team/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteTeam(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("anonymous");
		mservice.deleteProd(id);
		String message = "Team was successfully deleted.";
		modelAndView.addObject("message", message);
		return modelAndView;
	}

	/*
	 * 
	 * send mail the pwd to user dynamic pwd
	 */
	@Autowired
	private MailSender cm; // MailSender interface defines a strategy
	// for sending simple mails

	@RequestMapping("/sendmail")
	public ModelAndView SendEmail(@RequestParam("mailid") String m) {
		ModelAndView mv = new ModelAndView("anonymous");
		System.out.println("mail " + cm);
		String toAddress = m;
		String fromAddress = "kathirkathir2006@gmail.com";
		String subject = "hi";
		String msgBody = "hi hello";
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setFrom(fromAddress);
		mail.setTo(toAddress);
		mail.setSubject(subject);
		mail.setText(msgBody);
		cm.send(mail);

		// ModelAndView modelAndView = new ModelAndView("header");
		mv.addObject("message1", "subscribed ");

		return mv;
	}

	@RequestMapping("/generateQr")
	public ModelAndView generateQR() {
		ModelAndView mv = new ModelAndView("anonymous");
		String myCodeText = "Welcome to my world";
		String filePath = "C:/Users/Kathir/Desktop/kk/CrunchifyQR.png";
		int size = 250;
		String fileType = "png";
		File myFile = new File(filePath);
		try {

			Map<EncodeHintType, Object> hintMap = new EnumMap<EncodeHintType, Object>(EncodeHintType.class);
			hintMap.put(EncodeHintType.CHARACTER_SET, "UTF-8");

			// Now with zxing version 3.2.1 you could change border size (white
			// border size to just 1)
			hintMap.put(EncodeHintType.MARGIN, 1); /* default = 4 */
			hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);

			QRCodeWriter qrCodeWriter = new QRCodeWriter();
			BitMatrix byteMatrix = qrCodeWriter.encode(myCodeText, BarcodeFormat.QR_CODE, size, size, hintMap);
			int CrunchifyWidth = byteMatrix.getWidth();
			BufferedImage image = new BufferedImage(CrunchifyWidth, CrunchifyWidth, BufferedImage.TYPE_INT_RGB);
			image.createGraphics();

			Graphics2D graphics = (Graphics2D) image.getGraphics();
			graphics.setColor(Color.WHITE);
			graphics.fillRect(0, 0, CrunchifyWidth, CrunchifyWidth);
			graphics.setColor(Color.BLACK);

			for (int i = 0; i < CrunchifyWidth; i++) {
				for (int j = 0; j < CrunchifyWidth; j++) {
					if (byteMatrix.get(i, j)) {
						graphics.fillRect(i, j, 1, 1);
					}
				}
			}
			ImageIO.write(image, fileType, myFile);
		} catch (WriterException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		mv.addObject("message2", "QR CODE SCAN GOT ,USE it to view MY gallery");
		System.out.println("\n\nYou have successfully created QR Code.");
		return mv;
	}

}
