package com.example.rest.service;


import com.example.rest.entity.User;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;

public interface UserService {


    List<User> getAllUsers();

    User getUserById(Long id) throws ChangeSetPersister.NotFoundException;

    User createUser(User user);

    User updateUser(Long id, User user) throws ChangeSetPersister.NotFoundException;

    void deleteUser(Long id);
}

