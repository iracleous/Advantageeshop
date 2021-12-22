package gr.codehub.eshop.model;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;
    private double price;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    private List<ProductCart> carts = new java.util.ArrayList<>();




}
