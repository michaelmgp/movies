package com.example.xsis.service;

import com.example.xsis.model.Movie;
import com.example.xsis.model.dto.MovieDTO;
import com.example.xsis.model.exception.NotFoundException;
import com.example.xsis.repository.MovieRepository;
import com.example.xsis.service.base.BaseService;
import com.example.xsis.utils.ResponseGlobal;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@Transactional
public class MovieService implements BaseService<Movie> {
    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private ResponseGlobal response;
    @Override
    public Map save(Movie movie) {
        Movie movieSaved = movieRepository.save(movie);
        return response.created(movieSaved);
    }

    public Map deleteById(Long id){
        if(!movieRepository.existsById(id)){
            throw new NotFoundException("Movie corresponding id " + id + " didn't exist");
        }

        movieRepository.deleteById(id);
        return response.success(null);
    }

    public Map getOne(Long id){
        if(!movieRepository.existsById(id)){
            throw new NotFoundException("Movie with corresponding id " + id + " did not exist ");
        }
        return response.success(movieRepository.findById(id));
    }

    public Map getAll(){
        List<Movie> movieList = movieRepository.findAll();
        return response.success(movieList);
    }

    public Map update(long id, MovieDTO movieDTO){

        Optional<Movie> movieOptional = movieRepository.findById(id);
        if(!movieOptional.isPresent()){
            throw new NotFoundException("Movie with corresponding id " + id + " did not exist ");
        }

        Movie movie = movieOptional.get().builder().image(movieDTO.getImage())
                                                    .title(movieDTO.getTitle())
                                                    .rating(movieDTO.getRating())
                .description(movieDTO.getDescription()).build();
        movieRepository.save(movie);

        return response.success(movie);
    }
}
