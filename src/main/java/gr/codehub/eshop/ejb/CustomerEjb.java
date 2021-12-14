package gr.codehub.eshop.ejb;

import gr.codehub.eshop.model.Customer;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class CustomerEjb {
    @PersistenceContext(unitName = "Persistence")
    private EntityManager entityManager;

    public long doAction() throws Exception{
        long id =0;
        Customer customer  =  new Customer();
        customer.setName("Dimitris");
        entityManager.persist(customer);
        id = customer.getId();
        return id;
    }
}
