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
import com.primeiroprojetosb.repository.CategoryRepository;

/**
 *
 * @author Pichau
 */
@Service
public class CategoryService {

    @Autowired
    CategoryRepository cr;

    public Category findById(Long id) {

        Optional<Category> category = cr.findById(id);
        return category.get();

    }

    public List<Category> findAll() {
        List<Category> categories = cr.findAll();
        return categories;
    }

}
