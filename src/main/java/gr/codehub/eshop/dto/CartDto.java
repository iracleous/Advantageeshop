package gr.codehub.eshop.dto;


import gr.codehub.eshop.model.Customer;
import lombok.Data;

import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import java.time.LocalDate;
import java.util.List;

@Data
public class CartDto {
    private Long id;
    private LocalDate date;

    private String customerName;
    private Long customerId;

    private List<Integer> productIds;
 }
