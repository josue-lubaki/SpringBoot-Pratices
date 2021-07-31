package com.mycompany.movie.core.service;

import com.mycompany.movie.core.entity.Movie;
import com.mycompany.movie.core.repository.ActorRepositoryInterface;
import com.mycompany.movie.core.repository.MovieRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class DefaultMovieService implements MovieServiceInterface{

    @Autowired
    private MovieRepositoryInterface movieRepository;

    @Autowired
    private ActorRepositoryInterface actorRepository;

    public MovieRepositoryInterface getMovieRepository() {
        return movieRepository;
    }

    public void setMovieRepository(MovieRepositoryInterface movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Transactional
    public Movie registerMovie(Movie movie){
        // Sauvegarder d'abord l'acteur avant le film
        actorRepository.save(movie.getMainActor());
        return movieRepository.save(movie);
    }

    @Override
    public Iterable<Movie> getMovieList() {
        return movieRepository.findAll();
    }

    @Override
    public Movie getMovieById(long id) {
        Optional<Movie> optionalMovie=movieRepository.findById(id);
        if (optionalMovie.isEmpty()){
            throw new NoSuchElementException();
        }
        // on ne déproxifie pas, on met juste null à la relation inverse de Review vers Movie
        Movie movie = optionalMovie.get();

        movie.getReviews().forEach(review -> {
            review.setMovie(null);
        });

        return movie;
    }
}
