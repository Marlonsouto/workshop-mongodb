package com.workshopdb.workshopmongodb.domain;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;


@EqualsAndHashCode @Setter @Getter

@Document

public class User implements Serializable {

    @Id
    private String id;
    @Setter
    private String name;
    @Setter
    private String email;

    @DBRef(lazy = true)
    private List<Post> posts = new LinkedList<>();

    public User(){}

    public User(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
    public User(String id, String name, String email, List<Post> posts) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.posts = posts;
    }

}


