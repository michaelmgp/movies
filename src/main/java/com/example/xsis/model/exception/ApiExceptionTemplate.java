package com.example.xsis.model.exception;

import org.springframework.http.HttpStatus;

public class ApiExceptionTemplate {
    private final String message;
    private final HttpStatus httpStatus;


    public ApiExceptionTemplate(String message, HttpStatus httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
