package com.mycompany.movie.repository.file;

import com.mycompany.movie.entity.Movie;
import com.mycompany.movie.repository.MovieRepositoryInterface;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Repository
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
