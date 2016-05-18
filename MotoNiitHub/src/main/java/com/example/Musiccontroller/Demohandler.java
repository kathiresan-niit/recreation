package com.example.Musiccontroller;

import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.stereotype.Component;

import com.example.model.Motorola;


@Component
public class Demohandler {

	public Motorola initFlow(){
		return new Motorola();
	}

	public String validateDetails(Motorola userBean,MessageContext messageContext){
		String status = "success";
		if(userBean.getPname().isEmpty()){
			messageContext.addMessage(new MessageBuilder().error().source(
					"pname").defaultText("pname cannot be Empty").build());
			status = "failure";
		}
		
		return status;
	}
}