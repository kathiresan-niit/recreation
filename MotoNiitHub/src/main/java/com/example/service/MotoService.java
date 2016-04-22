package com.example.service;

import java.util.List;

import com.example.model.Motorola;

public interface MotoService {
	public long createMotorola(Motorola Motorola);
    public Motorola updateMotorola(Motorola Motorola);
    public void deleteMotorola(Integer id);
    public List<Motorola> getAllMotorolas();
    public Motorola getMotorola(Integer id);   
    //public List<Motorola> getAllMotorolas(String MotorolaName);
}
