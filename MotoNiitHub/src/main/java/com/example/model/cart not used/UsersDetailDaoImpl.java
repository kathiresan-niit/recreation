//package com.example.Dao;
//
//
//import org.hibernate.Query;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.example.model.Customer;
//import com.example.model.admin;
//import com.example.model.cart.Cart;
//import com.example.model.cart.UsersDetail;
//
//import java.util.List;
//
//
//
//@Repository
//@Transactional
//public class UsersDetailDaoImpl implements UsersDetailDao{
//
//    @Autowired
//    private SessionFactory sessionFactory;
//
//    public void addUser(UsersDetail usersDetail) {
//        Session session = sessionFactory.getCurrentSession();
//
//        usersDetail.getBillingAddress().setUsersDetail(usersDetail);
//        usersDetail.getShippingAddress().setUsersDetail(usersDetail);
//
//        session.saveOrUpdate(usersDetail);
//        session.saveOrUpdate(usersDetail.getBillingAddress());
//        session.saveOrUpdate(usersDetail.getShippingAddress());
//
//        Customer newUser = new Customer();
//        newUser.setUname(usersDetail.getUsername());
//        newUser.setPass(usersDetail.getPassword());
//        newUser.setEnabled(true);
//        newUser.setId(usersDetail.getUserId());
//
//        admin newUserRole = new admin();
//        newUserRole.setUserroleid(4);
//        newUserRole.setRole("ROLE_USER");
//        session.saveOrUpdate(newUser);
//        session.saveOrUpdate(newUserRole);
//
//        Cart newCart = new Cart();
//        newCart.setUsersDetail(usersDetail);
//        usersDetail.setCart(newCart);
//        session.saveOrUpdate(usersDetail);
//        session.saveOrUpdate(newCart);
//
//        session.flush();
//    }
//
//    public UsersDetail getUserById (int userId) {
//        Session session = sessionFactory.getCurrentSession();
//        return (UsersDetail) session.get(UsersDetail.class, userId);
//    }
//
//    public List<UsersDetail> getAllUsers() {
//        Session session = sessionFactory.getCurrentSession();
//        Query query = session.createQuery("from UsersDetail");
//        List<UsersDetail> usersDetail = query.list();
//
//        return usersDetail;
//    }
//
//    public UsersDetail getUserByUsername (String username) {
//        Session session = sessionFactory.getCurrentSession();
//        Query query = session.createQuery("from UsersDetail where username = ?");
//        query.setString(0, username);
//
//        return (UsersDetail) query.uniqueResult();
//    }
//}
