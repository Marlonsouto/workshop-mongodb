package com.workshopdb.workshopmongodb.dto;

import com.workshopdb.workshopmongodb.domain.User;
import lombok.*;
import org.springframework.data.annotation.Id;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter @EqualsAndHashCode
public class AuthorDto {

    @Id
    private String id;
    private String name;

    public AuthorDto(User user) {
        this.id = user.getId();
        this.name = user.getName();
    }

}
