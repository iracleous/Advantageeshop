package gr.codehub.eshop.resources;

import gr.codehub.eshop.dto.CustomerDto;
import gr.codehub.eshop.servicesejbs.CustomerServiceEjb;


import javax.ejb.EJB;
import javax.ws.rs.*;
import java.util.List;

@Path("/")
public class HelloResource {

    @EJB
    private CustomerServiceEjb customerEjb;



    @Path("/ping")
    @GET
    @Produces("text/plain")
    public String hello() {
        return "Hello, World!";
    }


    @Path("/customer")
    @GET
    @Produces("text/json")
    public List<CustomerDto> getCustomer() {
        try {
            List<CustomerDto> customers =   customerEjb.getCustomer();
             return   customers;
        } catch (Exception e) {
            return null;
        }
    }

    @Path("/customer")
    @POST
    @Consumes("text/json")
    @Produces("text/json")
    public CustomerDto getCustomers(CustomerDto customer) {
        try {
               return   customerEjb.saveCustomer(customer);
        } catch (Exception e) {
            return null;
        }
    }

    @Path("/customer/{customerId}")
    @GET
    @Produces("text/json")//
    public CustomerDto getCustomers(@PathParam("customerId")  long customerId) {
        try {

            CustomerDto customerDto =  customerEjb.getCustomer(customerId);
              return customerDto;
        } catch (Exception e) {
            return null;
        }
    }


}