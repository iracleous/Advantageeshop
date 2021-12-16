package gr.codehub.eshop.resources;


import gr.codehub.eshop.dto.ApiResult;
import gr.codehub.eshop.dto.CartDto;
import gr.codehub.eshop.service.CartService;
import gr.codehub.eshop.service.impl.CartServiceImpl;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/")
public class CartResource {
/*
POST customer/{id}/cart
GET customer/{customerId}/cart/{cartId}
POST customer/{customerId}/cart/{cartId}
 */

    @EJB
    private CartServiceImpl cartService;

    @Path("/customer/{customerId}/cart")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ApiResult<CartDto> createCart(@PathParam("customerId") long customerId) {
        try {
            return new ApiResult<>(cartService.createCart(customerId),"success", 200)   ;
        } catch (Exception e) {
            return new ApiResult<>(null,e.getMessage(), 500) ;
        }
    }

    @Path("customer/{customerId}/cart/{cartId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ApiResult<CartDto> getCart(@PathParam("customerId") long customerId, @PathParam("cartId") long cartId) {
        try {
            return new ApiResult<>(cartService.getCart(customerId, cartId),"success", 200)   ;
        } catch (Exception e) {
            return new ApiResult<>(null,e.getMessage(), 500) ;
        }
    }


}
