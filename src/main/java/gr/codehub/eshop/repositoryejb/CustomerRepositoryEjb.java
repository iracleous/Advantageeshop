package gr.codehub.eshop.repositoryejb;


import gr.codehub.eshop.dto.CustomerDto;
import gr.codehub.eshop.model.Customer;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class CustomerRepositoryEjb {

    @PersistenceContext(unitName = "Persistence")
    private EntityManager entityManager;

    public Customer saveCustomer(Customer customer) throws Exception {
        entityManager.persist(customer);
        return customer;
    }

    public Customer getCustomer(long custId) throws Exception {
        return entityManager.find(Customer.class, custId);
    }

    public List<Customer> getCustomer() throws Exception {

        //to
        //paging the results
        return entityManager
                .createQuery("Select c from Customer c ", Customer.class)
                .getResultList();
    }

    public boolean deleteCustomer(Customer customer) throws Exception {
        entityManager.remove(customer);
        return true;
    }
}
