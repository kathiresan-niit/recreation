package com.example.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
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
		System.out.println("update  "+Prod.getPid());
		Motorola updobj = getProd(Prod.getPid());
		System.out.println("update  "+Prod.getCategory());
		updobj.setPname(Prod.getPname());
		updobj.setCategory(Prod.getCategory());
		updobj.setDescription(Prod.getDescription());
		updobj.setAvail(Prod.getAvail());
		updobj.setSubcategory(Prod.getSubcategory());
		updobj.setImgpath(Prod.getImgpath());
		updobj.setPrice(Prod.getPrice());
		Session session = sf.openSession();
		session.saveOrUpdate(updobj);
		session.flush();
	}

	@Override
	public Motorola getProd(int id) {
		Motorola team = (Motorola) getCurrentSession().get(Motorola.class, id);
		System.out.println("in get - id "+team.getCategory());
		return team;
	}

	@Override
	public void deleteProd(int id) {
		Motorola team = getProd(id);
		      if (team != null)
		      {
		    	  Session session = sf.openSession();
		    	  System.out.println("in del-mserv");
		    	  session.delete(team);
		    	  session.flush();
		    	     
		      }

	}
	
	/*
	 * 
	 * for specfific file sub category retrieval
	 * */
	@Override
	public List<Motorola> getAllProd(String cat) {
		//Transaction t=getCurrentSession().beginTransaction();
		System.out.println("in get all"+cat);
		@SuppressWarnings("unchecked")
		List<Motorola> l= getCurrentSession().createQuery("from Motorola where subcategory='"+cat+"'").list();
		//t.commit();
		System.out.println("---- ga pr"+l);
		return l;
			//System.out.println();
	}
	
	public List<Motorola> getAllProd() {
		//Transaction t=getCurrentSession().beginTransaction();
		@SuppressWarnings("unchecked")
		List<Motorola> l= getCurrentSession().createQuery("from Motorola").list();
		//t.commit();
		System.out.println("---- in all prod"+l.get(0).getDescription());
		return l;
			//System.out.println();
	}

}
