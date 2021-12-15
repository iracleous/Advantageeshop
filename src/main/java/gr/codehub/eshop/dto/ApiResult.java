package gr.codehub.eshop.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiResult <T>{

    T data;
    String description;
    int statusCode;
}
