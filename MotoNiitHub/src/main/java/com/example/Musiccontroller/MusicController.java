package com.example.Musiccontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.Motorola;
import com.example.service.MotoService;

@Controller
public class MusicController {
	
	@RequestMapping("/")
	public String Landingpage()
	{
		return "index";
	}

	/*
	 * when user clicks reister  
	 */
	@Autowired
    private MotoService motoser;

    @RequestMapping("/createMotorola")
    public ModelAndView createMotorola(@ModelAttribute Motorola m) {
      System.out.println("Creating Motorola. Data: "+m);
        return new ModelAndView("MotorolaForm");
    }
    @RequestMapping("editMotorola")
    public ModelAndView editMotorola(@RequestParam Integer id, @ModelAttribute Motorola m) {
    	System.out.println("Updating the Motorola for the Id "+id);
        m = motoser.getMotorola(id);
        return new ModelAndView("motorolaForm", "motorolaObject", m);
    }
    
    @RequestMapping("saveMotorola")
    public ModelAndView saveMotorola(@ModelAttribute Motorola mo) {
        System.out.println("Saving the Motorola. Data : "+mo);
        if(mo.getPid() == 0){
        	// if Motorola id is 0 then creating the Motorola other updating the Motorola
            motoser.createMotorola(mo);
        } else {
            motoser.updateMotorola(mo);
        }
        return new ModelAndView("redirect:getAllMotorolas");
    }

    @RequestMapping("deleteMotorola")
    public ModelAndView deleteMotorola(@RequestParam Integer id) {
        System.out.println("Deleting the Motorola. Id : "+id);
        motoser.deleteMotorola(id);
        return new ModelAndView("redirect:getAllMotorolas");
    }
    
    @RequestMapping(value = {"getAllMotorolas", "/get"})
    public ModelAndView getAllMotorolas() {
    	 System.out.println("Getting the all Motorola.");
        List<Motorola> MotorolaList = motoser.getAllMotorolas();
        return new ModelAndView("ProductList", "MotorolaList", MotorolaList);
    }
    
//    @RequestMapping("searchMotorola")
//    public ModelAndView searchMotorola(@RequestParam("searchName") String searchName) {  
//    	System.out.println("Searching the Motorola. Motorola Names: "+searchName);
//      //  List<Motorola> motorolaList = motoser.getAllMotorolas(searchName);
//        return new ModelAndView("MotorolaList", "MotorolaList", motorolaList);      
//    }
}
