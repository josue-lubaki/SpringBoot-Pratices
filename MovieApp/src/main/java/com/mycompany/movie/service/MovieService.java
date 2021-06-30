package com.mycompany.movie.service;

import com.mycompany.movie.entity.Movie;
import com.mycompany.movie.repository.MovieRepositoryInterface;

public class MovieService implements MovieServiceInterface{
    private MovieRepositoryInterface movieRepository;

    public void registerMovie(Movie movie){
        movieRepository.addMovie(movie);
    }
}
