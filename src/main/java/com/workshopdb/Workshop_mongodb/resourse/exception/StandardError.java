package com.workshopdb.Workshop_mongodb.resourse.exception;

import lombok.*;

import java.io.Serializable;
import java.net.URI;

@Getter @Setter
@AllArgsConstructor
@Builder

public class StandardError implements Serializable {

    private Long timastamp;
    private Integer status;
    private String error;
    private String message;
    private URI path;


    public StandardError(StandardError nao_encntrado) {
    }
}
