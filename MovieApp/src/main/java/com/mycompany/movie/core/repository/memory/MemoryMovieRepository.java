package com.mycompany.movie.core.repository.memory;

import com.mycompany.movie.core.entity.Movie;
import com.mycompany.movie.core.repository.MovieRepositoryInterface;

import java.util.ArrayList;
import java.util.List;

//@Repository
public class MemoryMovieRepository implements MovieRepositoryInterface {
    public List<Movie> movies = new ArrayList<>();

    public void addMovie (Movie movie){
        movies.add(movie);
        System.out.println("The movie "+movie.getTitre()+" has been added.");
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
