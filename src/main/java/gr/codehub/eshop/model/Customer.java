package gr.codehub.eshop.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;


@Data
@Table(name = "customer")
@Entity
public class Customer  extends Person{


    @OneToMany(mappedBy = "customer")
    private List<Cart> carts = new java.util.ArrayList<>();


    @ManyToOne
    private Employee employee;
}