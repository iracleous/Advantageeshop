package gr.codehub.eshop.service.impl;


import gr.codehub.eshop.dto.CartDto;
import gr.codehub.eshop.dto.ProductDto;
import gr.codehub.eshop.model.Cart;
import gr.codehub.eshop.model.Customer;
import gr.codehub.eshop.model.Product;
import gr.codehub.eshop.model.ProductCart;
import gr.codehub.eshop.repository.CartRepository;
import gr.codehub.eshop.repository.CustomerRepository;
import gr.codehub.eshop.repository.ProductCartRepository;
import gr.codehub.eshop.repository.ProductRepository;
import gr.codehub.eshop.service.CartService;
import lombok.extern.slf4j.Slf4j;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Stateless
public class CartServiceImpl  implements CartService {

    @EJB
    private CustomerRepository customerRepository;
    @EJB
    private CartRepository cartRepository;
    @EJB
    private ProductCartRepository productCartRepository;
    @EJB
    private ProductRepository productRepository;



    public CartDto createCart(long customerId) throws Exception{
        log.info("cart creation for user " + customerId);
        Cart cart = new Cart();
        cart.setDate( LocalDate.now());
        Customer customer = customerRepository.getCustomer(customerId);
        cart.setCustomer(customer);
        cartRepository.saveCart(cart);
        return null;
    }


    public CartDto getCart(long customerId, long cartId) throws Exception {
        CartDto cartDto = new CartDto();
        Cart cart = cartRepository.findCart(  cartId);

        cartDto.setId(cart.getId());
        cartDto.setDate(cart.getDate());
        cartDto.setCustomerId(cart.getCustomer().getId());
        List<ProductDto> products = new ArrayList<>();
        cartDto.setProducts(products);

         for (ProductCart productCart:cart.getProducts()){
            ProductDto productDto = new ProductDto();
            productDto.setName(productCart.getProduct().getName());
            products.add(productDto);
        }

        return cartDto;
    }

    public CartDto addProductToCart(long customerId, long cartId, List<Long> productIds) throws Exception{

        Cart cart = cartRepository.getCart(cartId);

        for(Long productId :productIds){
            Product product = productRepository.findProduct(productId) ;

            ProductCart productCart = new ProductCart();
            productCart.setCart(cart);
            productCart.setProduct(product);
            productCartRepository.save(productCart);
         }
            return null;
    }
}
