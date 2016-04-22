package com.example.Dao;

import java.util.List;

import com.example.model.Motorola;

public interface MotoDao {
	public long createMoto(Motorola moto);
    public Motorola updateMoto(Motorola moto);
    public void deleteMotorola(Integer id);
    public List<Motorola> getAllMotorolas();
    public Motorola getMotorola(Integer id);   
  //  public List<Motorola> getAllMotorolas(String MotorolaName);
}
