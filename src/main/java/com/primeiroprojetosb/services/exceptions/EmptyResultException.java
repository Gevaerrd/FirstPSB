/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.primeiroprojetosb.services.exceptions;

/**
 *
 * @author Pichau
 */
public class EmptyResultException extends RuntimeException {

    public EmptyResultException(Object id) {
        super("ID " + id + " not found.");
    }

}
