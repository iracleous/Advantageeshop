package gr.codehub.eshop.model;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
public class Employee  extends Person {



    @OneToMany(mappedBy = "employee")
private List<Customer> customers;
}
