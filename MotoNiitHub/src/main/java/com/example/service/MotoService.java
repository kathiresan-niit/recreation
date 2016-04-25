package com.example.service;

import java.util.List;


import com.example.model.Motorola;

public interface MotoService {
	public void addProd(Motorola team);
	public void updateProd(Motorola Prod);
	public Motorola getProd(int id);
    public void deleteProd(int id);
	public List<Motorola> getAllProd(String cat);
	public List<Motorola> getAllProd();

}
