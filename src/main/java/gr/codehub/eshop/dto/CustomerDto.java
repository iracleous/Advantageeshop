package gr.codehub.eshop.dto;


import gr.codehub.eshop.model.Customer;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class CustomerDto {

    private Long id;
    private String name;
    private LocalDate regDate;
    private Integer age;
    private String email;



    public CustomerDto(Customer customer){
        id = customer.getId();
        name = customer.getName();
        regDate = customer.getRegDate();
        age = customer.getAge();
        email = customer.getEmail();
    }

    public Customer createCustomer(){
        Customer customer = new Customer();
        customer.setId(id);
        customer.setName(name);
        customer.setRegDate(regDate);
        customer.setAge(age);
        customer.setEmail(email);
        return customer;
    }

}
