package com.mycompany.movie.service;

import com.mycompany.movie.entity.Movie;

import java.util.List;

public interface MovieServiceInterface {
    void registerMovie(Movie movie);
    List<Movie> getMovieList();
}
