package com.mycompany.movie.core.repository;

import com.mycompany.movie.core.entity.Movie;

import java.util.List;

public interface MovieRepositoryInterface {
    Movie addMovie(Movie movie);
    List<Movie> list();
    Movie getById(long id);
}
