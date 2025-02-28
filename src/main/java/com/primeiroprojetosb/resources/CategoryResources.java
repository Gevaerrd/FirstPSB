/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.primeiroprojetosb.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.primeiroprojetosb.entities.Category;
import com.primeiroprojetosb.services.CategoryService;

/**
 *
 * @author Pichau
 */
@RestController
@RequestMapping(value = "/categories")
public class CategoryResources {

    @Autowired
    CategoryService cs;

    @GetMapping
    public ResponseEntity<List<Category>> findAll() {
        List<Category> categories = cs.findAll();
        return ResponseEntity.ok().body(categories);
    }

    @GetMapping(value = "/{id}")
    public Category findById(@PathVariable Long id) {
        Category category = cs.findById(id);
        return category;
    }

}
