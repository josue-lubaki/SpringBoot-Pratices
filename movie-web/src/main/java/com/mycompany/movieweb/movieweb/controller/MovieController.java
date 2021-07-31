package com.mycompany.movieweb.movieweb.controller;

import com.mycompany.movie.core.entity.Actor;
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
import java.util.Scanner;

@Controller
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private MovieServiceInterface movieService;

    public MovieServiceInterface getMovieService() {
        return movieService;
    }

    public void setMovieService(MovieServiceInterface movieService) {
        this.movieService = movieService;
    }

    /*@GetMapping("/{id}")
    public String displayMovieCard(@PathVariable("id") long id, Model model){
        model.addAttribute("movieInfo",movieService.getMovieById(id));
        return "movie-details";
    }*/

    @GetMapping("/dvdstore-home")
    public ModelAndView displayHome(){
        ModelAndView mv = new ModelAndView("dvdstore-home");
        mv.addObject("movies", movieService.getMovieList());
        return mv;
    }


    @GetMapping("/add-movie-form")
    public String displayMovieForm(@ModelAttribute("movieToCreate") MovieForm movie){
        return "add-movie-form";
    }


    /**
     * Methode qui permet de créer un film
     * */
    @PostMapping("/add")
    public String addMovie(@Valid @ModelAttribute("movieToCreate") MovieForm movieForm, BindingResult result){
        if(result.hasErrors()){
            return "add-movie-form";
        }

        Movie movie = new Movie();
        movie.setTitre(movieForm.getTitre());
        movie.setGenre(movieForm.getGenre());
        movie.setDescriptions(movieForm.getDescriptions());
        Actor acteur = new Actor(movieForm.getFirstNameActor(), movieForm.getLastNameActor());
        movie.setMainActor(acteur);
        movieService.registerMovie(movie);
        return "movie-added";
    }



}
