package com.mycompany.movieweb.movieweb.controller;

import com.mycompany.movie.core.entity.Movie;
import com.mycompany.movie.core.service.MovieServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private MovieServiceInterface movieService;

    public MovieServiceInterface getMovieService() {
        return movieService;
    }

    public void setMovieService(MovieServiceInterface movieService) {
        this.movieService = movieService;
    }

    @RequestMapping("/dvdstore-home")
    public @ModelAttribute("movies")
    List<? extends Movie> displayHome(){
        return movieService.getMovieList();
    }
}
