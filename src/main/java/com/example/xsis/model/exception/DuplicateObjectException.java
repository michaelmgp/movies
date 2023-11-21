package com.example.xsis.model.exception;

import org.springframework.http.HttpStatus;

public class DuplicateObjectException extends GenericException{

    private static final HttpStatus httpStatus = HttpStatus.CONFLICT;


    public DuplicateObjectException(String message) {
        super(message, httpStatus);
    }
}
