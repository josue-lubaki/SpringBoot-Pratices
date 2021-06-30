package com.mycompany.movie.repository;

import com.mycompany.movie.entity.Movie;

import java.io.FileWriter;
import java.io.IOException;

public class GoLiveMovieRepository {

    public void addMovie(Movie movie){
        FileWriter writer;
        try{
            writer=new FileWriter("movies.txt",true);

            writer.write(movie.getTitre() + ";" + movie.getGenre() + "\n");
            writer.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
