package com.example.xsis.utils;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ResponseGlobal {
    public Map success(Object obj){
        Map map = new HashMap();
        map.put("data", obj);
        map.put("code", 200);
        map.put("status", "success");
        return map;
    }

    public Map error(Object obj, Object code){
        Map map = new HashMap();
        map.put("code", code);
        map.put("status", obj);
        return map;
    }

    public Map created(Object obj){
        Map map = new HashMap<>();
        map.put("data", obj);
        map.put("code", 201);
        map.put("status", "Successfully Created");
        return map;
    }

}
