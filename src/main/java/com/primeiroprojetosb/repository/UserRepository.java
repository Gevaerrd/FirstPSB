/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.primeiroprojetosb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.primeiroprojetosb.entities.User;

// Passa objeto e chave primaria no JPARepository
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // O JPARepository já implementa operações padrões

}
