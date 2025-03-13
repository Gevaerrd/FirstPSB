/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.primeiroprojetosb.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.primeiroprojetosb.repository.CategoryRepository;
import com.primeiroprojetosb.services.exceptions.DataIntegrityException;
import com.primeiroprojetosb.services.exceptions.EmptyResultException;
import com.primeiroprojetosb.services.exceptions.ResourceNotFoundException;

@ControllerAdvice // Registra que essa classe é responsavel pelo tratamento de exceções
public class ResourceExceptionHandler {

    private final CategoryRepository categoryRepository;

    ResourceExceptionHandler(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @ExceptionHandler(ResourceNotFoundException.class) // O ExceptionHandler faz o Spring jogar essa exceção pra esse
                                                       // tratamento aqui caso exista.
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
        String error = "Resource not found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError se = new StandardError(Instant.now(), status.value(), error, e.getMessage(),
                request.getRequestURI());

        return ResponseEntity.status(status).body(se);

    }

    @ExceptionHandler(EmptyResultException.class)
    public ResponseEntity<StandardError> emptyResult(EmptyResultException er, HttpServletRequest request) {
        String error = "Empty result, we can't return what you want";
        HttpStatus https = HttpStatus.NOT_FOUND;
        StandardError se = new StandardError(Instant.now(), https.value(), error, er.getMessage(),
                request.getRequestURI());
        return ResponseEntity.status(https).body(se);

    }

    @ExceptionHandler(DataIntegrityException.class)
    public ResponseEntity<StandardError> dataIntegrity(DataIntegrityException di, HttpServletRequest request) {
        String error = "Data integrity, we cant delete this object";
        HttpStatus https = HttpStatus.BAD_REQUEST;
        StandardError se = new StandardError(Instant.now(), https.value(), error, di.getMessage(),
                request.getRequestURI());
        return ResponseEntity.status(https).body(se);

    }
}
