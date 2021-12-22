package gr.codehub.eshop.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private LocalDate date;

    @Transient
    private double cost;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Customer customer;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cart")
    private List<ProductCart> products = new java.util.ArrayList<>();


}
