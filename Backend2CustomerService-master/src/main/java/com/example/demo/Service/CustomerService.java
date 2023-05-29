package com.example.demo.Service;

import com.example.demo.Models.Customer;
import com.example.demo.Repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    public List<Customer> getCustomers(){
        return customerRepository.findAll();
    }
    public Customer getCustomer(Long id){
        return customerRepository.findById(id).get();
    }
    public String addNewCustomer(Customer customer){
        Optional<Customer> c = customerRepository.findCustomerByName(customer.getName());
        if(c.isPresent()){
            throw new IllegalStateException("Name already taken");
        }
        customerRepository.save(customer);
        return "kunden "+customer.getName()+" har lagts till";
    }

    public boolean customerExistsById(Long id){
        return customerRepository.existsById(id);
    }
}
