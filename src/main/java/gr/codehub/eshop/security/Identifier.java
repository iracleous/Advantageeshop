package gr.codehub.eshop.security;

import java.util.Set;

public interface Identifier {

    Set<String> hasRole(String username, String password);
    Boolean getLogged();
}
