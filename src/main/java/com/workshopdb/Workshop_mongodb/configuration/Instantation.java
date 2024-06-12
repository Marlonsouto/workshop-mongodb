package com.workshopdb.Workshop_mongodb.configuration;

import com.workshopdb.Workshop_mongodb.domain.User;
import com.workshopdb.Workshop_mongodb.repository.UserRepoository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import java.util.Arrays;

public class Instantation implements CommandLineRunner {

    @Autowired
    private UserRepoository userRepoository ;

    @Override
    public void run(String... args) throws Exception {

        userRepoository.deleteAll();

        User user1 = new User(null, "maria blue", "mariaBlue@gmail.com" );
        User user2 = new User(null, "jorge Red", "JorgeRed@gmail.com");
        User user3 = new User();

        userRepoository.saveAll(Arrays.asList(user1,user2,user3));

    }


}
