package gr.codehub.eshop.resources;


import gr.codehub.eshop.dto.ApiResult;
import gr.codehub.eshop.dto.CartDto;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

@Path("/")
public class Login {

    @Path("/login")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ApiResult<String> login(@Context  HttpServletRequest resp ) {
        String cc = resp.getAttribute("user").toString();

        if (cc.equals("dimitris"))
            return new ApiResult<>("data","authenticated", 200) ;
        else
            return new ApiResult<>("data","unauthenticated", 500) ;

    }
}
