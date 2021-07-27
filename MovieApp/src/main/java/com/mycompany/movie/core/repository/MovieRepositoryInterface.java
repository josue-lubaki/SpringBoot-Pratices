package com.mycompany.movie.core.repository;

import com.mycompany.movie.core.entity.Movie;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MovieRepositoryInterface extends CrudRepository<Movie, Long> {
    /*Movie addMovie(Movie movie);
    List<Movie> list();
    Movie getById(long id);*/
}
