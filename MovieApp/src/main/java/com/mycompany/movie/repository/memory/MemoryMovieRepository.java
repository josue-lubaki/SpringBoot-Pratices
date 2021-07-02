package com.mycompany.movie.repository.memory;

import com.mycompany.movie.entity.Movie;
import com.mycompany.movie.repository.MovieRepositoryInterface;
import org.springframework.stereotype.Repository;

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
}
