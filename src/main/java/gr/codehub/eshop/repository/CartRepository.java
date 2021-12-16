package gr.codehub.eshop.repository;

import gr.codehub.eshop.model.Cart;

import java.util.List;

public interface CartRepository {
     void saveCart(Cart cart) throws Exception;
     Cart getCart(long cartId) throws Exception ;
     List<Cart> getCustomerCarts(long customerId) throws Exception ;
     boolean deleteCart(Cart cart) throws Exception;
     Cart findCart(long cartId);
}
