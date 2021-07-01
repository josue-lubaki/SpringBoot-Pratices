package com.mycompany.movie.repository;

import com.mycompany.movie.entity.Movie;
import org.springframework.beans.factory.annotation.Value;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileMovieRepository implements MovieRepositoryInterface {

    @Value("${movieFile.path}")
    private File file;

    public void addMovie(Movie movie){
        FileWriter writer;
        try{
            writer=new FileWriter(file,true);

            writer.write(movie.getTitre() + ";" + movie.getGenre() + "\n");
            writer.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
}
