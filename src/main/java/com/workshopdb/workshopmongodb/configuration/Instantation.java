package com.workshopdb.workshopmongodb.configuration;

import com.workshopdb.workshopmongodb.domain.User;
import com.workshopdb.workshopmongodb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import java.util.Arrays;

public class Instantation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();

        User user1 = new User(null, "maria blue", "mariaBlue@gmail.com" );
        User user2 = new User(null, "jorge Red", "JorgeRed@gmail.com");
        User user3 = new User();

        userRepository.saveAll(Arrays.asList(user1,user2,user3));

    }


}
