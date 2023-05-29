package com.example.demo.Controllers;

import com.example.demo.Models.Orders;
import com.example.demo.Repositories.OrdersRepository;
import com.example.demo.Service.OrdersService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/order")
public class OrdersController {

    private final RestTemplate restTemplate = new RestTemplate();

    private final OrdersService service;

    OrdersController(OrdersService service) {
        this.service = service;
    }

    @GetMapping
    public List<Orders> getAllOrders() {
        return service.getOrders();
    }

    @GetMapping("/{id}")
    public Orders getOrderById(@PathVariable Long id) {
        return service.getOrderById(id);
    }

    @PostMapping
    public String addOrderWithCurl(@RequestBody Orders order) {
        return service.addNewOrder(order);

    }

    @GetMapping("/customer/{id}")
    public @ResponseBody String getCustomerNameByOrderId(@PathVariable Long id){
        String userServiceBaseUrl = "http://customerapiservice:8080/api/v1/customers/";
        Orders order = service.getOrderById(id);
        String userResourceUrlGetExists = userServiceBaseUrl + "exists/" + order.getCustomerId();
        boolean exists = restTemplate.getForObject(userResourceUrlGetExists,boolean.class);
        if(exists){
            return "Customer med id: " + order.getCustomerId() + " har köpt order med id: " + order.getId();
        }
        return "Den kunden finns inte.";
    }
}