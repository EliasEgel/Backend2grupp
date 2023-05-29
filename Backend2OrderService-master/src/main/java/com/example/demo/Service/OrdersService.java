package com.example.demo.Service;

import com.example.demo.Models.Orders;
import com.example.demo.Repositories.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrdersService {

    private final OrdersRepository repository;

    @Autowired
    public OrdersService(OrdersRepository repository){
        this.repository = repository;
    }

    public List<Orders> getOrders(){
        return repository.findAll();
    }

    public Orders getOrderById(Long id){
        return repository.findById(id).get();
    }

    public String addNewOrder(Orders order){
        Optional<Orders> o = repository.findById(order.getId());
        if(o.isPresent()){
            return "Order med samma id finns redan.";
        }
        repository.save(order);
        return "Order med id: " + order.getId() + " sparad.";
    }

}
