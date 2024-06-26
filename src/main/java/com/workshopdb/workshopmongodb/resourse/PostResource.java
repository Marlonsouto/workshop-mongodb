package com.workshopdb.workshopmongodb.resourse;

import com.workshopdb.workshopmongodb.domain.Post;
import com.workshopdb.workshopmongodb.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
@Validated
@RestController
@RequestMapping(value = "/posts")
public class PostResource {
    @Autowired
    PostService postService;

    @GetMapping("/{id}")
    public ResponseEntity<Post> findByid( @PathVariable String id) {
        var post = postService.findPostByiId(id);
        return ResponseEntity.ok().body(post);
    }

}
