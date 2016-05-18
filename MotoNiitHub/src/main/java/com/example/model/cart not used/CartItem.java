//package com.example.model.cart;
//
//import com.example.model.Motorola;
//import com.fasterxml.jackson.annotation.JsonIgnore;
//
//import javax.persistence.*;
//import java.io.Serializable;
//
//
//@Entity(name="CartItem1")
//public class CartItem implements Serializable{
//
//    private static final long serialVersionUID = 14L;
//
//    @Id
//    @GeneratedValue
//    private int cartItemId;
//
//    @ManyToOne
//    @JoinColumn(name = "cartId")
//    @JsonIgnore
//    private Cart cart;
//
//    @ManyToOne
//    @JoinColumn(name = "itemId")
//    private Motorola item;
//
//    private int quantity;
//    private double totalPrice;
//
//    public int getCartItemId() {
//        return cartItemId;
//    }
//
//    public void setCartItemId(int cartItemId) {
//        this.cartItemId = cartItemId;
//    }
//
//    public Cart getCart() {
//        return cart;
//    }
//
//    public void setCart(Cart cart) {
//        this.cart = cart;
//    }
//
//    public Motorola getItem() {
//        return item;
//    }
//
//    public void setItem(Motorola item) {
//        this.item = item;
//    }
//
//    public int getQuantity() {
//        return quantity;
//    }
//
//    public void setQuantity(int quantity) {
//        this.quantity = quantity;
//    }
//
//    public double getTotalPrice() {
//        return totalPrice;
//    }
//
//    public void setTotalPrice(double totalPrice) {
//        this.totalPrice = totalPrice;
//    }
//}
