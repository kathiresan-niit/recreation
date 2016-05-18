//package com.example.service;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.example.Dao.OrderDao;
//import com.example.model.cart.Cart;
//import com.example.model.cart.CartItem;
//import com.example.model.cart.UserOrder;
//
//import java.util.List;
//
//
//
//@Service
//public class OrderServiceImpl implements OrderService {
//
//    @Autowired
//    private OrderDao orderDao;
//
//    @Autowired
//    private CartService cartService;
//
//    public void addOrder(UserOrder userOrder) {
//    	orderDao.addOrder(userOrder);
//    }
//
//    public double getOrderGrandTotal(int cartId) {
//        double grandTotal=0;
//        Cart cart = cartService.getCartById(cartId);
//        List<CartItem> cartItems = cart.getCartItems();
//
//        for (CartItem item : cartItems) {
//            grandTotal+=item.getTotalPrice();
//        }
//
//        return grandTotal;
//    }
//}
