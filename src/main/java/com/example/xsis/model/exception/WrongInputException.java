package com.example.xsis.model.exception;

import org.springframework.http.HttpStatus;

public class WrongInputException extends GenericException{

    private static final HttpStatus httpStatus= HttpStatus.BAD_REQUEST;
    public WrongInputException(String message) {
        super(message, httpStatus);
    }
}
