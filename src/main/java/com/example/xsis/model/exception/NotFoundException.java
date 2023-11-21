package com.example.xsis.model.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Setter
@Getter
public class NotFoundException extends GenericException{

    private static final HttpStatus httpStatus = HttpStatus.NOT_FOUND;
    public NotFoundException(String message) {
        super(message, httpStatus);
    }
}
