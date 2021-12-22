package gr.codehub.eshop.security.impl;

import gr.codehub.eshop.model.Customer;
import gr.codehub.eshop.repository.CustomerRepository;
import gr.codehub.eshop.security.Identifier;

import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import java.util.HashSet;
import java.util.Set;


@Stateful
public class IdentifierImpl implements Identifier {
@EJB
    private CustomerRepository customerRepository;

    private Boolean logged;
    private Set<String> roles;
    @Override
    public  Set<String> hasRole(String username, String password) {

        if (logged ==null)
        {
            logged = false;
        }

       if (logged==true) {

           return roles;
       }
        else {

           Customer customer = null;
            try {
                  customer = customerRepository.login(username, password);
            }
            catch(Exception e){

            }

           if (customer == null) return new HashSet<>();

           logged =true;
           roles = new HashSet<>();;
           roles.add("user") ;
           return roles;
       }
    }

    @Override
    public Boolean getLogged(){
        return logged;
    }
}
