package gr.codehub.eshop.service;

import gr.codehub.eshop.dto.CustomerDto;
import java.util.List;

public interface CustomerService {
      CustomerDto saveCustomer(CustomerDto customerDto) throws Exception;
      CustomerDto getCustomer(long custId) throws Exception;
      List<CustomerDto> getCustomer(int pageSize, int pageCount) throws Exception;
      CustomerDto updateCustomer(long customerId, CustomerDto customerDto) throws Exception;
      boolean deleteCustomer(long customerId) throws Exception ;
}
