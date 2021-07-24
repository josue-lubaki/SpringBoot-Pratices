package com.mycompany.movie.core.service;

import com.mycompany.movie.core.entity.Movie;

import java.util.List;

public interface MovieServiceInterface {
    Movie registerMovie(Movie movie);
    List<Movie> getMovieList();
    Movie getMovieById(long id);
}
