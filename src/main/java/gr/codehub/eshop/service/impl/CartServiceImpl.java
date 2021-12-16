package gr.codehub.eshop.service.impl;


import gr.codehub.eshop.dto.CartDto;
import gr.codehub.eshop.model.Cart;
import gr.codehub.eshop.model.Customer;
import gr.codehub.eshop.repository.impl.CartRepositoryImpl;
import gr.codehub.eshop.repository.impl.CustomerRepositoryImpl;
import gr.codehub.eshop.service.CartService;
import lombok.extern.slf4j.Slf4j;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.time.LocalDate;

@Slf4j
@Stateless
public class CartServiceImpl   {

    @EJB
    private CustomerRepositoryImpl customerRepositoryEjb;
    @EJB
    private CartRepositoryImpl cartReposity;

    public CartDto createCart(long customerId) throws Exception{
        log.info("cart creation for user " + customerId);
        Cart cart = new Cart();
        cart.setDate( LocalDate.now());
        Customer customer = customerRepositoryEjb.getCustomer(customerId);
        cart.setCustomer(customer);
        cartReposity.saveCart(cart);
        return null;
    }


    public CartDto getCart(long customerId, long cartId) throws Exception {
        CartDto cartDto = new CartDto();
        Cart cart = cartReposity.findCart(  cartId);

        cartDto.setId(cart.getId());
        cartDto.setDate(cart.getDate());
        cartDto.setCustomerId(cart.getCustomer().getId());
        return cartDto;
    }
}
