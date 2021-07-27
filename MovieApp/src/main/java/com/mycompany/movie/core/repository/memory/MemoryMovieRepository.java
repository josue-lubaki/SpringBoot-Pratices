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
        movie.setId(++lastMovieId);
        movies.add(movie);
        System.out.println("The movie "+movie.getTitre()+" has been added.");
        return movie;
    }

    @Override
    public <S extends Movie> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Movie> findById(Long id) {
        return movies.stream().
                filter(m -> m.getId()==id).
                findFirst();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public List<Movie> findAll() {
        return movies;
    }

    @Override
    public Iterable<Movie> findAllById(Iterable<Long> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void delete(Movie movie) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteAll(Iterable<? extends Movie> iterable) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteAll() {
        throw new UnsupportedOperationException();
    }


}
