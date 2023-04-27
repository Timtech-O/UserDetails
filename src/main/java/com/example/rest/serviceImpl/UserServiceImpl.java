package com.example.rest.serviceImpl;

import com.example.rest.entity.User;
import com.example.rest.repository.UserRepository;
import com.example.rest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) throws ChangeSetPersister.NotFoundException {
        return userRepository.findById(id)
                .orElseThrow(() ->new ChangeSetPersister.NotFoundException());
    }


    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(Long id, User user) throws ChangeSetPersister.NotFoundException {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new ChangeSetPersister.NotFoundException());
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        return userRepository.save(existingUser);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}

