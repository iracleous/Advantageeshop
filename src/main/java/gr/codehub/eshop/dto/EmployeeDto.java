package gr.codehub.eshop.dto;

import gr.codehub.eshop.model.Customer;
import gr.codehub.eshop.model.Employee;

import java.time.LocalDate;
import java.util.List;

public class EmployeeDto {

    private Long id;
    private String name;
    private LocalDate regDate;
    private int age;
    private String email;
    private List<String> customersNames;



    public EmployeeDto(Employee employee){
        id = employee.getId();
        name = employee.getName();
        regDate = employee.getRegDate();
        age = employee.getAge();
        email = employee.getEmail();
    }

    public Employee createCustomer(){
        Employee employee = new Employee();
        employee.setId(id);
        employee.setName(name);
        employee.setRegDate(regDate);
        employee.setAge(age);
        employee.setEmail(email);
        return employee;
    }
}
