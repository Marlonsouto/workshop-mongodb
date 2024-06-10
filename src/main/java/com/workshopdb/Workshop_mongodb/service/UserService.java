package com.workshopdb.Workshop_mongodb.service;

import com.workshopdb.Workshop_mongodb.domain.User;
import com.workshopdb.Workshop_mongodb.repository.UserRepoository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepoository userRepoository;

    public List<User> findAllUsers() {
        List<User> users = userRepoository.findAll();
        return users;
    }
}
