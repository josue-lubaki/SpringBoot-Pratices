package com.mycompany.movieweb.movieweb.controller;

import com.mycompany.movie.core.entity.Movie;
import com.mycompany.movie.core.service.MovieServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
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

//    @GetMapping("/dvdstore-home")
//    public ModelAndView displayHome(){
//        ModelAndView mv = new ModelAndView("dvdstore-home");
//        mv.addObject("movies", movieService.getMovieList());
//        return mv;
//    }
//
//    @GetMapping("/add-movie-form")
//    public String displayMovieForm(@Valid @ModelAttribute("movieToCreate") Movie movie){
//        return "add-movie-form";
//    }
}
