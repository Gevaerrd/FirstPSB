package com.primeiroprojetosb.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.primeiroprojetosb.entities.User;

@RestController // Significa que essa classe vai lidar com requisições, get, post, etc...
@RequestMapping(value = "/users") // Request mapping espeficia qual HTTP/URL a classe vai atender.
public class UserResources {

    // ResponseEntity sempre espera um tipo
    @GetMapping
    public ResponseEntity<User> findAll() {

        User u = new User(1L, "Roger", "Gevaerd@hotmail.com", "048999015761", "gvrrd");
        System.out.println(u);
        return ResponseEntity.ok().body(u); // Responde a requisição com OK passando o usuario

    }
}
