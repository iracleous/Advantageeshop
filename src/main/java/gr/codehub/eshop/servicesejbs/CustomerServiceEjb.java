package gr.codehub.eshop.ejb;

import gr.codehub.eshop.model.Customer;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class CustomerEjb {
   @EJB
    private RepoEjb repoEjb;

    public long saveCustomer(String name) throws Exception{

        return repoEjb.saveCustomer(name);
    }

    public Customer getCustomer(long custId) throws Exception{
        return   repoEjb.getCustomer(custId);
    }


    public List<Customer> getCustomer() throws Exception{
        return    repoEjb.getCustomer();
    }


}
