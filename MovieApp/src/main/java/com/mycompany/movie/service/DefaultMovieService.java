package com.mycompany.movie.service;

import com.mycompany.movie.entity.Movie;
import com.mycompany.movie.repository.MovieRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;

public class DefaultMovieService implements MovieServiceInterface{

    @Autowired
    private MovieRepositoryInterface movieRepository;

    public MovieRepositoryInterface getMovieRepository() {
        return movieRepository;
    }

    public void setMovieRepository(MovieRepositoryInterface movieRepository) {
        this.movieRepository = movieRepository;
    }

    public void registerMovie(Movie movie){
        movieRepository.addMovie(movie);
    }
}