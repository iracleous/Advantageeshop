package gr.codehub.eshop.resources;

import gr.codehub.eshop.dto.ApiResult;
import gr.codehub.eshop.dto.CustomerDto;
import gr.codehub.eshop.servicesejbs.CustomerServiceEjb;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/")
public class CustomerResource {

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
    @Produces(MediaType.APPLICATION_JSON)
    public ApiResult<List<CustomerDto>> getCustomer() {
        try {
            List<CustomerDto> customers =   customerEjb.getCustomer();
             return  new ApiResult<>(customers,"success", 200) ;
        } catch (Exception e) {
            return new ApiResult<>(null,e.getMessage(), 500) ;
        }
    }

    @Path("/customer")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ApiResult<CustomerDto> getCustomers(CustomerDto customer) {
        try {
            return new ApiResult<>(customerEjb.saveCustomer(customer),"success", 200)   ;
        } catch (Exception e) {
            return new ApiResult<>(null,e.getMessage(), 500) ;
        }
    }

    @Path("/customer/{customerId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ApiResult<CustomerDto> getCustomers(@PathParam("customerId")  long customerId) {
        try {

            CustomerDto customerDto =  customerEjb.getCustomer(customerId);
            return new ApiResult<>(customerDto,"success", 200) ;
        } catch (Exception e) {
            return new ApiResult<>(null,e.getMessage(), 500) ;
        }
    }


    @Path("/customer/{customerId}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)//
    public ApiResult<CustomerDto> updateCustomers(@PathParam("customerId") long customerId, CustomerDto customerDto ) {
        try {
            CustomerDto customerDtoReturn =  customerEjb.updateCustomer(customerId, customerDto);
            return new ApiResult<>(customerDtoReturn,"success", 200) ;
        } catch (Exception e) {
            return new ApiResult<>(null,e.getMessage(), 500) ;
        }
    }

    @Path("/customer/{customerId}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)//
    public ApiResult<Boolean> deleteCustomers(@PathParam("customerId") long customerId) {
         try {
            boolean success =  customerEjb.deleteCustomer(customerId);
            return new ApiResult<>(true,"success", 200) ;
        } catch (Exception e) {
            return new ApiResult<>(false,e.getMessage(), 500) ;
        }
    }

}