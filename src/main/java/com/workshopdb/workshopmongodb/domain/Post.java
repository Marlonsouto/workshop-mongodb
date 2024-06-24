package com.workshopdb.workshopmongodb.domain;

import com.workshopdb.workshopmongodb.dto.authorDto;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

@Getter @Setter
@EqualsAndHashCode

@Document
public class Post implements Serializable {
    @Id
    private String id;
    private Date date;
    private String title;
    private String body ;
    private transient authorDto author ;

    public Post() {}

    public Post(String id, Date date, String title, String body, authorDto author) {
        this.id = id;
        this.date = date;
        this.title = title;
        this.body = body;
        this.author = author;
    }
}
