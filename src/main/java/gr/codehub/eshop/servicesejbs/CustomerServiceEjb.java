package gr.codehub.eshop.servicesejbs;

import gr.codehub.eshop.dto.CustomerDto;
import gr.codehub.eshop.model.Customer;
import gr.codehub.eshop.repositoryejb.CustomerRepositoryEjb;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class CustomerServiceEjb {
   @EJB
    private CustomerRepositoryEjb customerRepositoryEjb;

    public CustomerDto saveCustomer(CustomerDto customerDto) throws Exception{

        //validation of customerDto

        Customer customer = customerDto.createCustomer();
        customerRepositoryEjb.saveCustomer(customer);
        CustomerDto returnCustomerDto = new CustomerDto(customer);
        return returnCustomerDto;
    }

    public CustomerDto getCustomer(long custId) throws Exception{
        Customer customer = customerRepositoryEjb.getCustomer(custId);

        //validation of the received data from db

        return  new CustomerDto(customer) ;
    }


    public List<CustomerDto> getCustomer() throws Exception{

        return   customerRepositoryEjb
                .getCustomer()
                .stream()
                .map(CustomerDto::new)
                .collect(Collectors.toList());
    }


}
