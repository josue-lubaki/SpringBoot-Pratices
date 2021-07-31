package com.mycompany.movie.core.repository;

import com.mycompany.movie.core.entity.Movie;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface MovieRepositoryInterface extends CrudRepository<Movie, Long> {
    @EntityGraph(value = "movie.actor-and-reviews", type = EntityGraph.EntityGraphType.FETCH)
    Optional<Movie> findById(long id);
}
