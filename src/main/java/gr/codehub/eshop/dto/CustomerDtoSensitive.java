package gr.codehub.eshop.dto;

import gr.codehub.eshop.model.Customer;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CustomerDtoSensitive extends CustomerDto{

    private String password;

    public CustomerDtoSensitive (Customer customer){
        super(customer);
    }

     @Override
    public Customer createCustomer() {
        Customer customer = super.createCustomer();
        customer.setPassword(password);
        return customer;
     }

}
