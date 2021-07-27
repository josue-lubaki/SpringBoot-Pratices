package com.mycompany.movie.core.repository.memory;

import com.mycompany.movie.core.entity.Movie;
import com.mycompany.movie.core.repository.MovieRepositoryInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//@Repository
public class MemoryMovieRepository implements MovieRepositoryInterface {
    public List<Movie> movies = new ArrayList<>();
    public static long lastMovieId = 0L;

    public Movie save (Movie movie){
        movies.add(movie);
        System.out.println("The movie "+movie.getTitre()+" has been added.");
        return movie;
    }

    @Override
    public <S extends Movie> Iterable<S> saveAll(Iterable<S> iterable) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Optional<Movie> findById(Long id) {
        return movies.stream().
                filter(m -> m.getId()==id).
                findFirst();
    }

    @Override
    public boolean existsById(Long aLong) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Movie> findAll() {
        return movies;
    }

    @Override
    public Iterable<Movie> findAllById(Iterable<Long> iterable) {
        throw new UnsupportedOperationException();
    }

    @Override
    public long count() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteById(Long aLong) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void delete(Movie movie) {

    }

    @Override
    public void deleteAll(Iterable<? extends Movie> iterable) {

    }

    @Override
    public void deleteAll() {

    }

}
