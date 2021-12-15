package gr.codehub.eshop.repository;


import gr.codehub.eshop.dto.CartDto;
import gr.codehub.eshop.model.Cart;
import gr.codehub.eshop.model.Customer;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class CartRepository {

    @PersistenceContext(unitName = "Persistence")
    private EntityManager entityManager;

    public void saveCart(Cart cart) throws Exception{
        entityManager.persist(cart);
    }

    public Cart getCart(long cartId) throws Exception {
        return entityManager.find(Cart.class, cartId);
    }

    public List<Cart> getCustomerCarts(long customerId) throws Exception {
        //to
        //paging the results
        return entityManager
                .createQuery("Select c from Cart c where c.customer.id= :customerId", Cart.class)
                .setParameter("customerId", customerId)
                .getResultList();
    }

    public boolean deleteCart(Cart cart) throws Exception {
        entityManager.remove(cart);
        return true;
    }

    public Cart findCart(long cartId) {
       return entityManager.find(Cart.class, cartId);
     }
}
