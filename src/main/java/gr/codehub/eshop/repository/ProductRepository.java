package gr.codehub.eshop.repository;

import gr.codehub.eshop.model.Product;

public interface ProductRepository {

    Product findProduct(Long productId);
}
