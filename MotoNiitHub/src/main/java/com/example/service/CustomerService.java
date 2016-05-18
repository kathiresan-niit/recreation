package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.Dao.CustomerDao;
import com.example.model.Customer;

@Service
@Transactional
public class CustomerService {

	@Autowired
	private CustomerDao mdao;

	public void addCustomer(Customer team) {
		mdao.addCustomer(team);
	}

	public Customer getProd(int id) {

		return mdao.getProd(id);

	}

}
