package com.unir.movies.controller;


import com.unir.movies.model.MovieModel;
import com.unir.movies.service.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(value = "/movie")
@Slf4j
public class ModelController {

    @Autowired
    private MovieService movieService;

    @PostMapping
    public ResponseEntity<MovieModel> saveMovie(@RequestBody MovieModel movieModel){
        try {
            MovieModel savedMovie = movieService.saveMovie(movieModel);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedMovie);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<MovieModel> getMovieById(@PathVariable Long id) {
        return ResponseEntity.ok( movieService.getMovieById(id));
    }

    @GetMapping
    public ResponseEntity<ArrayList<MovieModel>> getAllMovies(){
        return ResponseEntity.ok( movieService.getAllMovies());
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<MovieModel> updateMovieById(@RequestBody MovieModel request, @PathVariable Long id) {
        return ResponseEntity.ok( movieService.updateMovieById(request, id));
    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Boolean> deleteMovieById(@PathVariable Long id) {
        return ResponseEntity.ok( movieService.deleteMovieById(id));
    }
}
