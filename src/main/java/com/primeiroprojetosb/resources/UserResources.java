package com.primeiroprojetosb.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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

    public UserResources() {
    }

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

    @PostMapping(value = "/create")
    // RequestBody faz o JSON ser convertido em um objeto
    public ResponseEntity<User> createUser(@RequestBody User user) {
        service.insertUser(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
        // Esse URI inclui o novo ID do objeto na pesquisa
        return ResponseEntity.created(uri).body(user);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.ok().body("Aeee deu bom");

    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Long id, @RequestBody User user) {
        service.updateUser(user);
        return ResponseEntity.ok().body("Atualizado");
    }

    // @GetMapping(value = "/{id}") // Argumento depois do users do requestmapping
    // public ResponseEntity<User> findById(@PathVariable Long id) {
    // PVariable é a sigla pra receber argumentos e usar eles em pesquisar
    // Optional<User> user = repository.findById(id);
    // return ResponseEntity.ok().body(user.get()); // get transforma o Optional no
    // objeto dele

}
