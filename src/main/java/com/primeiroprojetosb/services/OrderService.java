package com.primeiroprojetosb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.primeiroprojetosb.entities.Order;
import com.primeiroprojetosb.repository.OrderRepository;

@Service
public class OrderService {

    @Autowired
    OrderRepository or;

    public List<Order> findAll() {
        List<Order> orders = or.findAll();
        return orders;
    }

    public Order findById(Long id) {
        Optional<Order> order = or.findById(id);
        return order.get();
    }

}
