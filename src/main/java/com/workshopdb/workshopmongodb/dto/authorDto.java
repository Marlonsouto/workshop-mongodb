package com.workshopdb.workshopmongodb.dto;

import com.workshopdb.workshopmongodb.domain.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter @Setter
public final class authorDto {

    @Id
    private String id;
    private String name;

    public authorDto(User user) {
        this.id = user.getId();
        this.name = user.getName();
    }

}
