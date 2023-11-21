package com.example.xsis.advice;

import com.example.xsis.model.exception.ApiExceptionTemplate;
import com.example.xsis.model.exception.GenericException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApiExceptionHandle {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleInvalidArgument(MethodArgumentNotValidException exception){
        Map<String, String> errorMap = new HashMap<>();
        exception.getBindingResult().getFieldErrors().forEach( fieldError -> {
            errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
        });

        return errorMap;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpClientErrorException.class)
    public Map<String, String> handleClientErrorException(HttpClientErrorException exception){
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("Cause", exception.getCause().toString());
        errorMap.put("Message ", exception.getMessage());

        return  errorMap;
    }

    @ExceptionHandler(GenericException.class)
    public ResponseEntity<Object> generalException(GenericException generalException){

        ApiExceptionTemplate apiException = new ApiExceptionTemplate(generalException.getMessage(),generalException.getHttpStatus());
        return new ResponseEntity<>(apiException, generalException.getHttpStatus());
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentException.class)
    public Map<String, String> illegalArgument(IllegalArgumentException exception){
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("Cause", exception.getCause().toString());
        errorMap.put("Message ", exception.getMessage());

        return  errorMap;
    }





}
