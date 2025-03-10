package com.primeiroprojetosb.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.primeiroprojetosb.entities.User;
import com.primeiroprojetosb.repository.UserRepository;
import com.primeiroprojetosb.services.UserService;

@RestController // Significa que essa classe vai lidar com requisições, get, post, etc...
@RequestMapping(value = "/users") // Request mapping espeficia qual HTTP/URL a classe vai atender.
public class UserResources {

    @Autowired // Injeta a dependencia pra não precisar instanciar
    private UserService service;
    @Autowired
    private UserRepository repository;

    // ResponseEntity sempre espera um tipo
    @GetMapping
    public ResponseEntity<List<User>> findAll() {

        // User u = new User(1L, "Roger", "Gevaerd@hotmail.com", "048999015761",
        // "gvrrd");
        List<User> users = service.findAll();
        return ResponseEntity.ok().body(users); // Responde a requisição com OK passando o usuario

    }

    @GetMapping(value = "/{id}") // o / vem depois do users
    public ResponseEntity<User> findById(@PathVariable Long id) {
        User u = service.findById(id);
        return ResponseEntity.ok().body(u);

    }

    // @GetMapping(value = "/{id}") // Argumento depois do users do requestmapping
    // public ResponseEntity<User> findById(@PathVariable Long id) { // Path
    // variable mostra que vai receber argumento
    // Optional<User> user = repository.findById(id);
    // return ResponseEntity.ok().body(user.get()); // get transforma o Optional no
    // objeto dele

}
