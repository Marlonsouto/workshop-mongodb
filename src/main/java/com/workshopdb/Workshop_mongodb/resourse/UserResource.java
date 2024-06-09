package com.workshopdb.Workshop_mongodb.resourse;

import com.workshopdb.Workshop_mongodb.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        User maria = new User("1", "maria blue", "mariaBlue@gmail.com" );
        User jorge = new User("2", "jorge red", "jorgeRed@gmail.com" );
        return ResponseEntity.ok(new ArrayList<>(Arrays.asList(maria, jorge)));
    }


}
