/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.primeiroprojetosb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.primeiroprojetosb.entities.Category;
import com.primeiroprojetosb.entities.Product;
import com.primeiroprojetosb.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    ProductRepository pr;

    public List<Product> findAll() {
        List<Product> product = pr.findAll();
        return product;
    }

    public Product findById(Long id) {
        Optional<Product> product = pr.findById(id);
        return product.get(); // Retorna o objeto
    }

}
