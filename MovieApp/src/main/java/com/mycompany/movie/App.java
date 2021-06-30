package com.mycompany.movie;

import com.mycompany.movie.controller.MovieController;
import com.mycompany.movie.entity.Movie;
import com.mycompany.movie.service.MovieService;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        MovieController movieController = new MovieController();
        movieController.addUsingConsole();
    }
}
