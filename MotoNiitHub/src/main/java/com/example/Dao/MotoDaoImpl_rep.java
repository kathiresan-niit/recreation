package com.example.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.model.Motorola;




@Repository
public class MotoDaoImpl_rep implements MotoDao{

	@Autowired(required=true)
	private SessionFactory sf;

	private Session getCurrentSession() 
	{
	
		return sf.openSession();
	}

	@Override
	public void addProd(Motorola team) {
		
		sf.getCurrentSession().save(team);

	}

	@Override
	public void updateProd(Motorola Prod) {
		Motorola updobj = getProd(Prod.getPid());
		
		updobj.setPname(Prod.getPname());
		updobj.setCategory(Prod.getCategory());
		updobj.setDescription(Prod.getDescription());
		updobj.setAvail(Prod.getAvail());
		updobj.setSubcategory(Prod.getSubcategory());
		updobj.setImgpath(Prod.getImgpath());
		        getCurrentSession().update(updobj);
	}

	@Override
	public Motorola getProd(int id) {
		Motorola team = (Motorola) getCurrentSession().get(Motorola.class, id);
		return team;
	}

	@Override
	public void deleteProd(int id) {
		Motorola team = getProd(id);
		      if (team != null)
		             getCurrentSession().delete(team);

	}

	@Override
	public List<Motorola> getAllProd() {
		//Transaction t=getCurrentSession().beginTransaction();
		List<Motorola> l= getCurrentSession().createQuery("from Motorola").list();
		//t.commit();
		System.out.println("---- ga pr"+l.get(0).getDescription());
		return l;
			//System.out.println();
	}

}
