package com.workshopdb.workshopmongodb.configuration;

import com.workshopdb.workshopmongodb.domain.Post;
import com.workshopdb.workshopmongodb.domain.User;
import com.workshopdb.workshopmongodb.dto.AuthorDto;
import com.workshopdb.workshopmongodb.repository.PostRepository;
import com.workshopdb.workshopmongodb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.TimeZone;
@Configuration
public class Instantation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();
        postRepository.deleteAll();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        User user = new User(null, "maria blue", "mariaBlue@gmail.com" );
        User user2 = new User(null, "jorge Red", "JorgeRed@gmail.com");
        User user3 = new User(null, "Bob green","Bob22@gmail.com");

        userRepository.saveAll(Arrays.asList(user,user2,user3));

        Post post = new Post(null, sdf.parse("28/01/1995"),"hoje é dia de praia","nada melhor que um descanco",
                new AuthorDto(user));
        Post post1 = new Post(null, sdf.parse("12/07/2000"),"Bom dia ","Acordei feliz hoje!! ", new AuthorDto(user2));

        postRepository.saveAll(List.of(post,post1));

        user.getPosts().addAll(Arrays.asList(post,post1));

        userRepository.save(user);

    }



}
