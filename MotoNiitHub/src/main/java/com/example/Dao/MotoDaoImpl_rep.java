package com.example.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.Util.Hibutil;
import com.example.model.Motorola;

@Repository
public class MotoDaoImpl_rep implements MotoDao{

	@Autowired
    private Hibutil hibernateUtil;

	public long createMoto(Motorola moto) {
		       
	        return (Long) hibernateUtil.create(moto);
	    }
	

	public Motorola updateMoto(Motorola moto) {
			return hibernateUtil.update(moto);
	}

	public void deleteMotorola(Integer id) {
		
		 Motorola Motorola = new Motorola();
	        Motorola.setPid(id);
	        hibernateUtil.delete(Motorola);
		
	}

	public List<Motorola> getAllMotorolas() {
		return hibernateUtil.fetchAll(Motorola.class);
	}

	public Motorola getMotorola(Integer id) {
		
		return hibernateUtil.fetchById(id, Motorola.class);
	}
/*
	@Override
	public List<Motorola> getAllMotorolas(String MotorolaName) {
		String query = "SELECT e.* FROM Motorola e WHERE e.name like '%"+ MotorolaName +"%'";
        List<Object[]> MotorolaObjects = hibernateUtil.fetchAll(query);
        List<Motorola> Motorolas = new ArrayList<Motorola>();
        for(Object[] MotorolaObject: MotorolaObjects) {
            Motorola Motorola = new Motorola();
            Integer id = ((Integer) MotorolaObject[0]).intValue();         
            Integer age = (Integer) MotorolaObject[1];
            String name = (String) MotorolaObject[2];
            Integer price = (Integer) MotorolaObject[3];
            Motorola.setPid(id);
            Motorola.setPname(name);
            Motorola.setCategory("moto");
            Motorola.setAvail(5);
            Motorolas.add(Motorola);
        }
        System.out.println(Motorolas);
        return Motorolas;
	}
*/
}
