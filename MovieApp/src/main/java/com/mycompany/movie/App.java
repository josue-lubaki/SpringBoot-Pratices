package com.mycompany.movie;

import com.mycompany.movie.controller.MovieController;
import com.mycompany.movie.repository.FileMovieRepository;
import com.mycompany.movie.service.DefaultMovieService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        MovieController movieController = new MovieController();
        FileMovieRepository movieRepository = new FileMovieRepository();
        DefaultMovieService movieService = new DefaultMovieService();
        movieService.setMovieRepository(movieRepository);
        movieController.setMovieService(movieService);
        movieController.addUsingConsole();
    }
}
