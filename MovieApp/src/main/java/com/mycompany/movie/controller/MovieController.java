package com.mycompany.movie.controller;

import com.mycompany.movie.entity.Movie;
import com.mycompany.movie.service.MovieService;

import java.util.Scanner;

public class MovieController {
    private final MovieService movieService = new MovieService();

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
