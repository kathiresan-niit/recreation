//package com.example.service;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.example.Dao.CartItemDao;
//import com.example.model.cart.Cart;
//import com.example.model.cart.CartItem;
//
//
//
//@Service
//public class CartItemServiceImpl implements CartItemService{
//
//    @Autowired
//    private CartItemDao cartItemDao;
//
//    public void addCartItem(CartItem cartItem) {
//        cartItemDao.addCartItem(cartItem);
//    }
//
//    public void removeCartItem(CartItem cartItem) {
//        cartItemDao.removeCartItem(cartItem);
//    }
//
//    public void removeAllCartItems(Cart cart){
//        cartItemDao.removeAllCartItems(cart);
//    }
//
//    public CartItem getCartItemByItemId (int itemId) {
//        return cartItemDao.getCartItemByItemId(itemId);
//    }
//}
