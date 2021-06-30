package com.mycompany.movie.service;

import com.mycompany.movie.entity.Movie;
import com.mycompany.movie.repository.GoLiveMovieRepository;
import com.mycompany.movie.repository.MovieRepository;

public class MovieService {
    GoLiveMovieRepository movieRepository = new GoLiveMovieRepository();

    public void registerMovie(Movie movie){
        movieRepository.addMovie(movie);
    }
}
