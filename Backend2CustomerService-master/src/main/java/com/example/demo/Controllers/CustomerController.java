package com.example.demo.Controllers;

import com.example.demo.Models.Customer;
import com.example.demo.Repositories.CustomerRepository;
import com.example.demo.Service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @GetMapping("{id}")
    public Customer getCustomer(@PathVariable("id") Long id){
        return customerService.getCustomer(id);
    }
    @GetMapping("exists/{id}")
    public boolean customerExsists(@PathVariable("id") Long id){
        return customerService.customerExistsById(id);
    }
    @PostMapping
    public String addCustomer(@Valid @RequestBody Customer c){return customerService.addNewCustomer(c);}

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
