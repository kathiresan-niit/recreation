package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.Dao.MotoDao;
import com.example.model.Motorola;

@Service
@Transactional
public class MotoServiceImpl implements MotoService
{
	@Autowired	
	    private MotoDao mdao;
	
	@Override
	public void addProd(Motorola team) {
		mdao.addProd(team);
	}
	
	@Override
	public void updateProd(Motorola Prod) {
		mdao.updateProd(Prod);
		
	}
	
	@Override
	public Motorola getProd(int id) {
		
		return mdao.getProd(id);
		
	}
	
	@Override
	public void deleteProd(int id) {
		mdao.deleteProd(id);

		
	}
	
	@Override
	public List<Motorola> getAllProd() {
		System.out.println("serv impl "+mdao);
		System.out.println(mdao.getAllProd().get(0).getPrice()+"in serv");
		return mdao.getAllProd();

	}
	
	

}

