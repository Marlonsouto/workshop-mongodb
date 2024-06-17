package com.workshopdb.Workshop_mongodb.resourse;

import com.workshopdb.Workshop_mongodb.dto.UserDto;
import com.workshopdb.Workshop_mongodb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDto>> findAll() {
        final var listUsers = userService.findAllUsers();
        final List<UserDto> list = listUsers.stream().map(UserDto::new).collect(Collectors.toList());
        return ResponseEntity.ok(list);
    }

    @GetMapping({"id"})
    public ResponseEntity<UserDto> findByid(@Validated @PathVariable String id) {
        final var user = userService.findUserByiId(id);
        return ResponseEntity.ok().body(new UserDto(user));
    }


}
