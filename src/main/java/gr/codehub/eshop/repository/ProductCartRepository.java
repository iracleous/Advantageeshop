package gr.codehub.eshop.repository;

import gr.codehub.eshop.model.Cart;
import gr.codehub.eshop.model.Product;
import gr.codehub.eshop.model.ProductCart;

import java.util.List;

public interface ProductCartRepository {
        void save(ProductCart productCart);
}
