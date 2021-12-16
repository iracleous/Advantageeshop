package gr.codehub.eshop.repository.impl;


import gr.codehub.eshop.model.Customer;
import gr.codehub.eshop.repository.CustomerRepository;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class CustomerRepositoryImpl  implements  CustomerRepository{

    @PersistenceContext(unitName = "Persistence")
    private EntityManager entityManager;

    public Customer saveCustomer(Customer customer) throws Exception {
        entityManager.persist(customer);
        return customer;
    }

    public Customer getCustomer(long custId) throws Exception {
        return entityManager.find(Customer.class, custId);
    }

    public List<Customer> getCustomer(int pageSize,  int pageCount) throws Exception {
        if (pageCount<=0 ) pageCount=1;
        if (pageSize<=0 || pageSize>50) pageSize=10;

       return  entityManager
               .createQuery("Select c from Customer c ", Customer.class)
               .setFirstResult((pageCount-1)*pageSize)
               .setMaxResults(pageSize)
               .getResultList();
    }

    public boolean deleteCustomer(Customer customer) throws Exception {
        entityManager.remove(customer);
        return true;
    }
}
