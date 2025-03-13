package com.primeiroprojetosb.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.primeiroprojetosb.entities.User;
import com.primeiroprojetosb.repository.CategoryRepository;
import com.primeiroprojetosb.repository.UserRepository;
import com.primeiroprojetosb.resources.CategoryResources;
import com.primeiroprojetosb.services.exceptions.DataIntegrityException;
import com.primeiroprojetosb.services.exceptions.EmptyResultException;
import com.primeiroprojetosb.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {

    private final CategoryService categoryService;

    private final CategoryResources categoryResources;

    private final CategoryRepository categoryRepository;

    @Autowired // Injeta a dependencia pra não precisar instanciar
    private UserRepository ur;

    UserService(CategoryRepository categoryRepository, CategoryResources categoryResources,
            CategoryService categoryService) {
        this.categoryRepository = categoryRepository;
        this.categoryResources = categoryResources;
        this.categoryService = categoryService;
    }

    public List<User> findAll() {
        List<User> users = ur.findAll();
        List<User> filtredUsers = users.stream().filter(x -> x.getName().charAt(0) == 'A').collect(Collectors.toList());
        return users;

    }

    public User findById(Long id) {
        try {

            Optional<User> user = ur.findById(id);
            return user.get();
        }

        catch (NoSuchElementException e) {
            throw new ResourceNotFoundException(id);
        }

        // return user.orElseThrow(() -> new ResourceNotFoundException(id));
        // Tenta fazer o . get, caso contrario chama a exceção, dava pra fazer assim

    }

    public User insertUser(User user) {
        return ur.save(user);
    }

    public void deleteById(Long id) {
        // Pra descobrir o nome das classes de exceção, fazer RunTimeException
        // e dar e.printstracktrace pra ver o nome
        try {
            ur.deleteById(id);
        }

        catch (EmptyResultDataAccessException e) {
            throw new EmptyResultException(id);
        }

        catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException(e.getMessage());
        }
    }

    public void updateData(User user, User obj) {
        user.setName(obj.getName());
        user.setEmail(obj.getEmail());
        user.setPhone(obj.getPhone());
    }

    public User updateUser(Long id, User obj) {
        try {

            User user = ur.getOne(id);
            updateData(user, obj);
            ur.save(user);
            return user;

        }

        catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }
}
