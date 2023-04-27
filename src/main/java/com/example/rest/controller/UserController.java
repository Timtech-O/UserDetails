package com.example.rest.controller;

import com.example.rest.entity.User;
import com.example.rest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")

public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("")

    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")

    public User getUser(@PathVariable Long id) throws ChangeSetPersister.NotFoundException {
        return userService.getUserById(id);
    }

    @PostMapping("")

    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping("/{id}")

    public User updateUser(@PathVariable Long id, @RequestBody User user) throws ChangeSetPersister.NotFoundException {
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/{id}")

    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}

