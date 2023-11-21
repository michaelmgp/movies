package com.example.xsis.controller.base;

import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface BaseController <T>{
    ResponseEntity<Map>save (T t);
}
