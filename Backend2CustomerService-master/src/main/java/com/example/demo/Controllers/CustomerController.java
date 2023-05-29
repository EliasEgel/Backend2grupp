package com.example.demo.Controllers;

import com.example.demo.Models.Customer;
import com.example.demo.Repositories.CustomerRepository;
import com.example.demo.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/customers")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> getAllCostumers(){
        return customerService.getCustomers();
    }

    @RequestMapping("{id}")
    public Customer getCustomer(@PathVariable("id") Long id){
        return customerService.getCustomer(id);
    }
    @RequestMapping("exists/{id}")
    public boolean customerExsists(@PathVariable("id") Long id){
        return customerService.customerExistsById(id);
    }
    @PostMapping
    public void addCustomer(@RequestBody Customer c){
        customerService.addNewCustomer(c);
    }
}
