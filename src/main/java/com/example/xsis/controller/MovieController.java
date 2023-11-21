package com.example.xsis.controller;

import com.example.xsis.controller.base.BaseController;
import com.example.xsis.model.Movie;
import com.example.xsis.model.dto.MovieDTO;
import com.example.xsis.service.MovieService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/movies")
public class MovieController implements BaseController<Movie> {

    @Autowired
    MovieService movieService;
    @Override
    @PostMapping
    public ResponseEntity<Map> save(@RequestBody @Valid Movie movie) {
        Map result = movieService.save(movie);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map> findById(@PathVariable long id){
        Map result = movieService.getOne(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Map> findAll(){
        Map result = movieService.getAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable long id){
        Map result = movieService.deleteById(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity patchById(@PathVariable long id, @RequestBody MovieDTO movieDTO){
        Map result = movieService.update(id, movieDTO);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
