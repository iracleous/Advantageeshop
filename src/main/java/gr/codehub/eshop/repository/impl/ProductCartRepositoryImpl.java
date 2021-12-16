package gr.codehub.eshop.repository.impl;

import gr.codehub.eshop.model.ProductCart;
import gr.codehub.eshop.repository.ProductCartRepository;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ProductCartRepositoryImpl implements ProductCartRepository {
    @PersistenceContext(unitName = "Persistence")
    private EntityManager entityManager;

    @Override
    public void save(ProductCart productCart) {
        entityManager.persist(productCart);
    }
}
