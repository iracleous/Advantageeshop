package gr.codehub.eshop.service.impl;

import gr.codehub.eshop.dto.CustomerDto;
import gr.codehub.eshop.exception.CustomerException;
import gr.codehub.eshop.model.Customer;
import gr.codehub.eshop.repository.CustomerRepository;
import gr.codehub.eshop.service.CustomerService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class CustomerServiceImpl implements CustomerService {
   @EJB
    private CustomerRepository customerRepository;

    public CustomerDto saveCustomer(CustomerDto customerDto) throws Exception{

        //validation of customerDto
        if (customerDto == null){
            throw new CustomerException("null customerDto");
        }
         customerDto.setRegDate(LocalDate.now());
        Customer customer = customerDto.createCustomer();
        customerRepository.saveCustomer(customer);
        CustomerDto returnCustomerDto = new CustomerDto(customer);
        return returnCustomerDto;
    }

    public CustomerDto getCustomer(long custId) throws Exception{
        Customer customer = customerRepository.getCustomer(custId);

        //validation of the received data from db

        return  new CustomerDto(customer) ;
    }


    public List<CustomerDto> getCustomer(int pageSize,  int pageCount) throws Exception{

        return   customerRepository
                .getCustomer( pageSize,  pageCount)
                .stream()
                .map(CustomerDto::new)
                .collect(Collectors.toList());
    }


    public CustomerDto updateCustomer(long customerId, CustomerDto customerDto) throws Exception{
        Customer customer = customerRepository.getCustomer(customerId);
        customer.setEmail(customerDto.getEmail());
        return new CustomerDto(customerRepository.saveCustomer( customer));
    }

    public boolean deleteCustomer(long customerId) throws Exception {
        Customer customer = customerRepository.getCustomer(customerId);

        return customerRepository.deleteCustomer(customer);
    }
}
