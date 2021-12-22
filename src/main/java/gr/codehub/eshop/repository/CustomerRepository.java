package gr.codehub.eshop.repository;

import gr.codehub.eshop.model.Customer;

import java.util.List;

public interface CustomerRepository {

     Customer saveCustomer(Customer customer) throws Exception ;
     Customer getCustomer(long custId) throws Exception ;
     List<Customer> getCustomer(int pageSize, int pageCount) throws Exception ;
     boolean deleteCustomer(Customer customer) throws Exception ;

    Customer login(String email, String password)  throws Exception;

}
