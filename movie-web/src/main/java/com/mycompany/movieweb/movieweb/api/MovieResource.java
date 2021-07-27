package com.mycompany.movieweb.movieweb.api;

import com.mycompany.movie.core.entity.Movie;
import com.mycompany.movie.core.service.MovieServiceInterface;
import com.mycompany.movieweb.movieweb.form.MovieForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieResource {

    @Autowired
    private MovieServiceInterface movieService;

    public MovieServiceInterface getMovieService() {
        return movieService;
    }

    public void setMovieService(MovieServiceInterface movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public Iterable<Movie> list(){
        return movieService.getMovieList();
    }

    @GetMapping("/{id}")
    public Movie get(@PathVariable("id") long id){
        return movieService.getMovieById(id);
    }

    /**
     * Methode qui permet de créer un film
     * */
    @PostMapping()
    public Movie add(@RequestBody Movie movie){
        return movieService.registerMovie(movie);
    }



}
