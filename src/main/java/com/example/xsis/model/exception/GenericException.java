package com.example.xsis.model.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class GenericException extends RuntimeException{

    private HttpStatus httpStatus;

    public GenericException(String message, HttpStatus httpStatus){
        super(message);
        this.httpStatus=httpStatus;
    }

    public GenericException(String message, Throwable cause){
        super(message,cause);
    }
}
