package gr.codehub.eshop.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;


@MappedSuperclass
@Data
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;
    private String address;
    private LocalDate regDate;
    private int age;
    private String Email;
    private String password;
}
