package com.workshopdb.workshopmongodb.resourse;

import com.workshopdb.workshopmongodb.dto.UserDto;
import com.workshopdb.workshopmongodb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> findByid(@Validated @PathVariable String id) {
        final var user = userService.findUserByiId(id);
        return ResponseEntity.ok().body(new UserDto(user));
    }

    @PostMapping()
    public ResponseEntity<Void> save(@Validated @RequestBody UserDto userDto){
        var user = userService.fromDto(userDto);
        userService.saveUser(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/id").buildAndExpand(userDto.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserById(@Validated @PathVariable String id){
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }



}
