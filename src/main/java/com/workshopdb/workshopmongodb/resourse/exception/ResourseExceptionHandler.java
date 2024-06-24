package com.workshopdb.workshopmongodb.resourse.exception;


import com.workshopdb.workshopmongodb.service.exception.ObjectNotFoundException;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice()
public class ResourseExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException exception, HttpRequest httpRequest) {
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        StandardError standardError =
                new StandardError(StandardError.builder()
                        .status(httpStatus.value())
                        .path(httpRequest.getURI())
                        .error("nao encntrado")
                        .timastamp(System.currentTimeMillis())
                        .message(exception.getMessage()).build());

        return ResponseEntity.status(httpStatus).body(standardError);
    }
}
