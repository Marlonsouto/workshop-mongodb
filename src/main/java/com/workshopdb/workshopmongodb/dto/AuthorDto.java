package com.workshopdb.workshopmongodb.dto;

import com.workshopdb.workshopmongodb.domain.User;
import jdk.jfr.Name;
import org.springframework.data.annotation.Id;

import java.util.Objects;


public final class AuthorDto {
    @Id
    private final String id;
    private final String name;

    public AuthorDto(String id,
                     String name) {
        this.id = id;
        this.name = name;
    }

    public AuthorDto(User user) {
        this.id = user.getId();
        this.name = user.getName();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (AuthorDto) obj;
        return Objects.equals(this.id, that.id) &&
                Objects.equals(this.name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "AuthorDto[" +
                "id=" + id + ", " +
                "name=" + name + ']';
    }


}
