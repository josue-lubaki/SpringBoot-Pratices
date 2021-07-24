package com.mycompany.movie.core.repository.memory;

import com.mycompany.movie.core.entity.Movie;
import com.mycompany.movie.core.repository.MovieRepositoryInterface;

import java.util.ArrayList;
import java.util.List;

//@Repository
public class MemoryMovieRepository implements MovieRepositoryInterface {
    public List<Movie> movies = new ArrayList<>();
    public static long lastMovieId = 0L;

    public Movie addMovie (Movie movie){
        movie.setId(++lastMovieId);
        movies.add(movie);
        System.out.println("The movie "+movie.getTitre()+" has been added.");
        return movie;
    }

    @Override
    public List<Movie> list() {
        return movies;
    }

    @Override
    public Movie getById(long id) {
        return movies.stream().
                filter(m -> m.getId()==id).
                findFirst().get();
    }
}
