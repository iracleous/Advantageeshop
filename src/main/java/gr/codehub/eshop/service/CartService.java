package gr.codehub.eshop.service;

import gr.codehub.eshop.dto.CartDto;
import gr.codehub.eshop.model.Cart;
import gr.codehub.eshop.model.Customer;

import java.time.LocalDate;

public interface CartService {
      CartDto createCart(long customerId) throws Exception;
      CartDto getCart(long customerId, long cartId) throws Exception ;
}
