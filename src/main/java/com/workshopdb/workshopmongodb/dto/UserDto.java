package com.workshopdb.workshopmongodb.dto;

import com.workshopdb.workshopmongodb.domain.User;
import lombok.Getter;

import java.util.Objects;


public final class UserDto {
    private  String id;
    private  String name;
    private final String email;

    public UserDto(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public UserDto(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (UserDto) obj;
        return Objects.equals(this.id, that.id) &&
                Objects.equals(this.name, that.name) &&
                Objects.equals(this.email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email);
    }

    @Override
    public String toString() {
        return "UserDto[" +
                "id=" + id + ", " +
                "name=" + name + ", " +
                "email=" + email + ']';
    }


}
