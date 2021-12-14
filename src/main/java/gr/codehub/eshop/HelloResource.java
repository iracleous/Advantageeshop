package gr.codehub.eshop;

import gr.codehub.eshop.dto.CustomerDto;
import gr.codehub.eshop.ejb.CustomerEjb;
import gr.codehub.eshop.model.Customer;



import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.List;

@Path("/")
public class HelloResource {

    @EJB
    private CustomerEjb customerEjb;



    @Path("/hello-world")
    @GET
    @Produces("text/plain")
    public String hello() {
        return "Hello, World!";
    }


    @Path("/customer")
    @GET
    @Produces("text/json")
    public long getCustomers() {
        try {
            String name = "Dimitris";

            return   customerEjb.saveCustomer(name);
        } catch (Exception e) {
            return 0l;
        }
    }

    @Path("/customer/{customerId}/{secondParam}")
    @GET
    @Produces("text/json")
    public CustomerDto getCustomers(@PathParam("customerId")  long customerId, @PathParam("secondParam")  int secondParam) {
        try {
            Customer customer =  customerEjb.getCustomer(customerId);
            CustomerDto customerDto =  new CustomerDto();
            customerDto.setName(customer.getName());
            return customerDto;
        } catch (Exception e) {
            return null;
        }
    }


}