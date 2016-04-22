package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.Dao.MotoDao;
import com.example.model.Motorola;

@Service
@Transactional
public class MotoServiceImpl implements MotoService
{

	
	@Autowired
    private MotoDao MotorolaDAO;

    public long createMotorola(Motorola Motorola) {
        return MotorolaDAO.createMoto(Motorola);
    }
    public Motorola updateMotorola(Motorola Motorola) {
        return MotorolaDAO.updateMoto(Motorola);
    }
    public void deleteMotorola(Integer id) {
        MotorolaDAO.deleteMotorola(id);
    }
    public List<Motorola> getAllMotorolas() {
        return MotorolaDAO.getAllMotorolas();
    }
    public Motorola getMotorola(Integer id) {
        return MotorolaDAO.getMotorola(id);
    }    
  //  @Override
//    public List<Motorola> getAllMotorolas(String MotorolaName) {
//        return MotorolaDAO.getAllMotorolas(MotorolaName);
//    }
}
