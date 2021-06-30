package com.mycompany.movie.repository;

import com.mycompany.movie.entity.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieRepository {
    public List<Movie> movies = new ArrayList<>();

    public void addMovie (Movie movie){
        movies.add(movie);
        System.out.println("The movie "+movie.getTitre()+" has been added.");
    }
}
