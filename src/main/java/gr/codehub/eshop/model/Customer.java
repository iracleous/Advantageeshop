package gr.codehub.eshop.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Data
@Table(name = "customer")
@Entity
public class Customer  extends Person{


    @OneToMany(fetch = javax.persistence.FetchType.LAZY, mappedBy = "customer")
    private List<Cart> carts = new java.util.ArrayList<>();


    @ManyToOne(fetch = javax.persistence.FetchType.LAZY)
    @JoinColumn
    private Employee employee;
}