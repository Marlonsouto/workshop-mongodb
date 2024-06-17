package com.workshopdb.Workshop_mongodb.service;

import com.workshopdb.Workshop_mongodb.domain.User;
import com.workshopdb.Workshop_mongodb.repository.UserRepository;
import com.workshopdb.Workshop_mongodb.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> findAllUsers() {
        Optional<List<User>> users = Optional.of(userRepository.findAll());
        users.stream().sorted();
        return users.get();
    }

    public User findUserByiId(String id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isEmpty()) {
            throw new ObjectNotFoundException("Usuario nao encontrado");
        }
        return userOptional.get();
    }


}
