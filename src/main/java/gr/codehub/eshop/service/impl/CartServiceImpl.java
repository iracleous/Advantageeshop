package gr.codehub.eshop.service.impl;


import gr.codehub.eshop.dto.CartDto;
import gr.codehub.eshop.model.Cart;
import gr.codehub.eshop.model.Customer;
import gr.codehub.eshop.repository.CartRepository;
import gr.codehub.eshop.repository.CustomerRepository;
import gr.codehub.eshop.service.CartService;
import lombok.extern.slf4j.Slf4j;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.time.LocalDate;
import java.util.List;

@Slf4j
@Stateless
public class CartServiceImpl  implements CartService {

    @EJB
    private CustomerRepository customerRepository;
    @EJB
    private CartRepository cartReposity;

    public CartDto createCart(long customerId) throws Exception{
        log.info("cart creation for user " + customerId);
        Cart cart = new Cart();
        cart.setDate( LocalDate.now());
        Customer customer = customerRepository.getCustomer(customerId);
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

    public CartDto addProductToCart(long customerId, long cartId, List<Integer> productIds) throws Exception{
            return null;
    }
}
