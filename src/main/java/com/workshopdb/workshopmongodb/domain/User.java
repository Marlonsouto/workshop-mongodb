package com.workshopdb.workshopmongodb.domain;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

@Getter @EqualsAndHashCode
@Document
public class User implements Serializable {

    @Id
    private String id;
    private String name;
    private String email;

    @DBRef(lazy = true)
    private final List<Post> posts = new LinkedList<>();

    public User(){}

    public User(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}


