package com.mycompany.movie.repository;

import com.mycompany.movie.entity.Movie;

import java.util.List;

public interface MovieRepositoryInterface {
    void addMovie(Movie movie);
    List<Movie> list();
}
