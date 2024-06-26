package com.workshopdb.workshopmongodb.service;

import com.workshopdb.workshopmongodb.domain.Post;
import com.workshopdb.workshopmongodb.repository.PostRepository;
import com.workshopdb.workshopmongodb.service.exception.ObjectNotFoundException;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService {
    @Autowired
    private  PostRepository postRepository;

    public Post findPostByiId(@NonNull String id) {
        return postRepository.findById(id)
                .orElseThrow( () -> new ObjectNotFoundException("Nao encontrado"));
    }


}
