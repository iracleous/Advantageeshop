package gr.codehub.eshop.ejb;


import gr.codehub.eshop.model.Customer;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class RepoEjb {

    @PersistenceContext(unitName = "Persistence")
    private EntityManager entityManager;

    public long saveCustomer(String name) throws Exception{
        long id =0;
        Customer customer  =  new Customer();
        customer.setName(name);
        entityManager.persist(customer);
        id = customer.getId();
        return id;
    }

    public Customer getCustomer(long custId) throws Exception{
        return    entityManager.find(Customer.class, custId);
    }


    public List<Customer> getCustomer() throws Exception{
        return    entityManager.createQuery( "Select c from Customer c", Customer.class ).getResultList();
    }
}
