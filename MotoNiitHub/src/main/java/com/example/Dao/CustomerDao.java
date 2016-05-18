package com.example.Dao;

import java.util.LinkedHashSet;
import java.util.Random;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.Customer;
import com.example.model.admin;

@Repository
@Transactional
public class CustomerDao {
	@Autowired(required = true)

	private SessionFactory sf;

	private Session getCurrentSession() {

		return sf.openSession();
	}

	public void addCustomer(Customer team) {
		team.setEnabled(true);
		sf.getCurrentSession().save(team);
		admin a = new admin();
		a.setRole("ROLE_USER");
		a.setUserroleid(genadminrandomid());
		Query query = sf.getCurrentSession()
				.createQuery("from  " + Customer.class.getName() + " where uname = :username ");
		query.setParameter("username", team.getUname());
		team = (Customer) query.uniqueResult();
		System.out.println("add cust id - ad" + team.getId());
		a.setUserid(team.getId());
		sf.getCurrentSession().save(a);
	}

	public Customer getProd(int id) {
		Customer team = (Customer) getCurrentSession().get(Customer.class, id);
		System.out.println("in get - id cust ");
		return team;
	}

	public Integer genadminrandomid() {
		Random rng = new Random(); // Ideally just create one instance globally
		// Note: use LinkedHashSet to maintain insertion order
		LinkedHashSet<Integer> generated = new LinkedHashSet<Integer>();
		while (generated.size() < 10000) {
			Integer next = rng.nextInt(20000) + 1;
			// As we're adding to a set, this will automatically do a
			// containment check
			generated.add(next);
		}
		System.out.println("in gen random pwd " + generated.iterator().next());
		return generated.iterator().next();

	}

	public Customer getCustomerByName(String n) {
		Query query = sf.getCurrentSession()
				.createQuery("from  " + Customer.class.getName() + " where uname = :username ");
		query.setParameter("username", n);
		Customer c = (Customer) query.uniqueResult();
		//= (Customer) getCurrentSession().createQuery("from users1 where uname='"+n+"'").list();
		return c;
	}
	/*
	 * public Integer genrandomid() { Random rng = new Random(); // Ideally just
	 * create one instance globally // Note: use LinkedHashSet to maintain
	 * insertion order LinkedHashSet<Integer> generated = new
	 * LinkedHashSet<Integer>(); while (generated.size() < 10000) { Integer next
	 * = rng.nextInt(20000) + 1; // As we're adding to a set, this will
	 * automatically do a // containment check generated.add(next); }
	 * System.out.println("in gen random pwd " + generated.iterator().next());
	 * return generated.iterator().next();
	 * 
	 * }
	 * 
	 */
}
