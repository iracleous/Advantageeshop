package gr.codehub.eshop.repository.impl;

import gr.codehub.eshop.model.Product;
import gr.codehub.eshop.repository.ProductRepository;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ProductRepositoryImpl implements ProductRepository {


    @PersistenceContext(unitName = "Persistence")
    private EntityManager entityManager;

    @Override
    public Product findProduct(Long productId) {
        return entityManager.find(Product.class,productId );
    }
}
