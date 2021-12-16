package gr.codehub.eshop.dto;


import gr.codehub.eshop.model.Customer;
import gr.codehub.eshop.model.Product;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductDto {

    private Long id;
    private String name;
    private double price;

    public ProductDto(Product product){
        id = product.getId();
        name = product.getName();
        price = product.getPrice();
    }

    public Product createProduct(){
        Product product = new Product();
        product.setId(id);
        product.setName(name);
        product.setPrice(price);
         return product;
    }

}
