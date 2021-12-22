package gr.codehub.eshop.security;

import javax.ejb.EJB;
import javax.security.enterprise.AuthenticationException;
import javax.security.enterprise.AuthenticationStatus;
import javax.security.enterprise.authentication.mechanism.http.HttpAuthenticationMechanism;
import javax.security.enterprise.authentication.mechanism.http.HttpMessageContext;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Set;


public class CustomAuthenticationMechanism  implements HttpAuthenticationMechanism {

    private static final String username = "username";
    private static final String password = "password";

    @EJB
    private Identifier identifier;

    @Override
    public AuthenticationStatus validateRequest(HttpServletRequest httpServletRequest,
                                                HttpServletResponse httpServletResponse,
                                                HttpMessageContext httpMessageContext)
            throws AuthenticationException {

        String givenUsername = httpServletRequest.getHeader(username);
        String givenPassword =  httpServletRequest.getHeader(password);

        if (givenUsername != null && givenPassword != null) {
            UsernamePasswordCredential upc = new UsernamePasswordCredential(username, password);
            String vv= upc.getCaller();
            Set<String> roles = identifier.hasRole(givenUsername,givenPassword );
            if (roles !=null){
                httpServletRequest.setAttribute("user",vv);
            }
        }
        return  AuthenticationStatus.SUCCESS;
     }
}
