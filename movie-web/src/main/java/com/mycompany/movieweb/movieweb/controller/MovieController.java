package com.mycompany.movieweb.movieweb.controller;

import com.mycompany.movie.core.entity.Movie;
import com.mycompany.movie.core.service.MovieServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Scanner;

@Controller
public class MovieController {

    private MovieServiceInterface movieService;

    public MovieServiceInterface getMovieService() {
        return movieService;
    }

    public void setMovieService(MovieServiceInterface movieService) {
        this.movieService = movieService;
    }

    public void addUsingConsole(){
        System.out.println( "Entrer le Titre et le genre du film" );
        Scanner scan = new Scanner(System.in);
        String titre = scan.nextLine();
        String genre = scan.nextLine();

        // instancier le movie
        Movie movie = new Movie();
        movie.setTitre(titre);
        movie.setGenre(genre);

        // appel de la methode du service
        movieService.registerMovie(movie);
    }

}
