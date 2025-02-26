package com.primeiroprojetosb.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.primeiroprojetosb.entities.Order;
import com.primeiroprojetosb.repository.OrderRepository;
import com.primeiroprojetosb.services.OrderService;

@RestController
@RequestMapping(value = "/orders")
public class OrderResources {

    @Autowired
    OrderRepository or;
    @Autowired
    OrderService os;

    @GetMapping
    public ResponseEntity<List<Order>> findAll() {
        List<Order> orders = or.findAll();
        return ResponseEntity.ok().body(orders);

    }

}
