package gr.codehub.eshop.service;


import gr.codehub.eshop.dto.CartDto;
import gr.codehub.eshop.model.Cart;
import gr.codehub.eshop.model.Customer;
import gr.codehub.eshop.repository.CartRepository;
import gr.codehub.eshop.repository.CustomerRepository;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.time.LocalDate;

@Stateless
public class CartService {

    @EJB
    private CustomerRepository customerRepositoryEjb;
    @EJB
    private CartRepository cartReposity;



    public CartDto createCart(long customerId) throws Exception{
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
