package com.primeiroprojetosb.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.primeiroprojetosb.entities.User;
import com.primeiroprojetosb.repository.UserRepository;

@Service
public class UserService {

    @Autowired // Injeta a dependencia pra não precisar instanciar
    private UserRepository ur;

    public List<User> findAll() {
        List<User> users = ur.findAll();
        List<User> filtredUsers = users.stream().filter(x -> x.getName().charAt(0) == 'A').collect(Collectors.toList());
        return users;

    }

    public User findById(Long id) {
        Optional<User> user = ur.findById(id);
        return user.get(); // Retorna o objeto dentro do optional

    }
}
