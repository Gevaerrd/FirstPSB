/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.primeiroprojetosb.repository;

import javax.persistence.EmbeddedId;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.primeiroprojetosb.entities.OrderItem;

/**
 *
 * @author Pichau
 */
@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, EmbeddedId> {

}
