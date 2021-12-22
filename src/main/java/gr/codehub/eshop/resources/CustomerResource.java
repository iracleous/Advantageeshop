package gr.codehub.eshop.resources;

import gr.codehub.eshop.dto.ApiResult;
import gr.codehub.eshop.dto.CustomerDto;
import gr.codehub.eshop.security.Identifier;
import gr.codehub.eshop.service.CustomerService;


import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.security.auth.message.MessageInfo;
import javax.security.enterprise.authentication.mechanism.http.HttpMessageContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/")
public class CustomerResource {

    @EJB
    private CustomerService customerService;

    @Path("/ping")
    @GET
    @Produces("text/plain")
    public String hello(@Context HttpServletRequest req) {

        if (req.isUserInRole("user")) {
            return "Hello user";
        }
        return "Hello, World!";
    }

    @Path("/customer")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ApiResult<List<CustomerDto>> getCustomer(@QueryParam("pageSize")   Integer pageSize,  @QueryParam("pageCount")  Integer pageCount) {
        try {
            if (pageSize== null) pageSize=10;
            if (pageCount== null) pageCount=1;
             List<CustomerDto> customers =   customerService.getCustomer(pageSize, pageCount);
             return  new ApiResult<>(customers,"success", 200) ;
        } catch (Exception e) {
            return new ApiResult<>(null,e.getMessage(), 500) ;
        }
    }

@Resource
private HttpMessageContext req;

    @Path("/customer")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ApiResult<CustomerDto> getCustomers(CustomerDto customer ) {
    MessageInfo mi = req
            .getMessageInfo();

    String   value =    mi .getMap()
            .get("k1")
            .toString();
        if ( value!=null && value.equals("v1")) {
               return new ApiResult<>(null,"authenticated", 200) ;
        }


        try {
            return new ApiResult<>(customerService.saveCustomer(customer),"success", 200)   ;
        } catch (Exception e) {
            return new ApiResult<>(null,e.getMessage(), 500) ;
        }
    }

    @Path("/customer/{customerId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ApiResult<CustomerDto> getCustomers(@PathParam("customerId")  long customerId) {
        try {

            CustomerDto customerDto =  customerService.getCustomer(customerId);
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
            CustomerDto customerDtoReturn =  customerService.updateCustomer(customerId, customerDto);
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
            boolean success =  customerService.deleteCustomer(customerId);
            return new ApiResult<>(true,"success", 200) ;
        } catch (Exception e) {
            return new ApiResult<>(false,e.getMessage(), 500) ;
        }
    }

}