package com.workshopdb.workshopmongodb.service;

import com.workshopdb.workshopmongodb.domain.User;
import com.workshopdb.workshopmongodb.dto.UserDto;
import com.workshopdb.workshopmongodb.repository.UserRepository;
import com.workshopdb.workshopmongodb.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> findAllUsers() {
        Optional<List<User>> users = Optional.of(userRepository.findAll());
        return users.get();
    }

    public User findUserByiId(String id) {
        return userRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Nao encontrado"));
    }

    public User saveUser(User user) {
        if (userRepository.existsById(user.getId())) {
            throw new RuntimeException("usuario ja existe");
        }
        return userRepository.insert(user);
    }

    private void updateData(User objUser, User newUser) {
        newUser.setName(objUser.getName());
        newUser.setEmail(objUser.getEmail());
    }

    public void delete(String id) {
        findUserByiId(id);
        userRepository.deleteById(id);
    }

    public void update(User objUser, String id) {
        Optional<User> userOptional = Optional.ofNullable(userRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Id nao encontrado")));
        User user = userOptional.get();

        updateData(objUser, user);
        userRepository.save(user);
    }

    public User fromDto(UserDto userDto) {
        return new User(userDto.getId(), userDto.getName(), userDto.getEmail());
    }


}
