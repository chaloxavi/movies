package com.unir.movies.service;

import com.unir.movies.model.MovieModel;
import com.unir.movies.repository.IMovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MovieService {

    @Autowired
    IMovieRepository movieRepository;

    public ArrayList<MovieModel> getAllMovies(){
        return (ArrayList<MovieModel>) movieRepository.findAll();
    }

    public MovieModel saveMovie(MovieModel movieModel){
        return movieRepository.save(movieModel);
    }

    public MovieModel getMovieById(Long id){
        return movieRepository.findById(id).get();
    }

    public MovieModel updateMovieById(MovieModel request, Long id){
        MovieModel movie = getMovieById(id);

        movie.setTitle(request.getTitle());
        movie.setCover(request.getCover());
        movie.setDirector(request.getDirector());
        movie.setSynopsis(request.getSynopsis());
        movie.setTrailer(request.getTrailer());
        movie.setYear(request.getYear());
        movie.setStatus(request.getStatus());

       return movieRepository.save(movie);
    }

    public boolean deleteMovieById(Long id){
        try {
            movieRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

}
