package com.workshopdb.Workshop_mongodb.dto;

import com.workshopdb.Workshop_mongodb.domain.User;
import lombok.EqualsAndHashCode;

import java.io.Serial;

@EqualsAndHashCode

public class UserDto {

    String id;
    String name;
    String email;

    public UserDto() {
    }

    public UserDto(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
