package com.workshopdb.Workshop_mongodb.resourse;

import com.workshopdb.Workshop_mongodb.domain.User;
import com.workshopdb.Workshop_mongodb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        var listUsers = userService.findAllUsers();
        return ResponseEntity.ok(listUsers);
    }


}
