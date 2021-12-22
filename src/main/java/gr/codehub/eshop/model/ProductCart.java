package gr.codehub.eshop.model;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class ProductCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private int quantity;
    private double discount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Cart cart;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Product product;


}
