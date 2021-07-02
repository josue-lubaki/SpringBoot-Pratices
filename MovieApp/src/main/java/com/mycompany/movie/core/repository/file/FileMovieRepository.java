package com.mycompany.movie.core.repository.file;

import com.mycompany.movie.core.entity.Movie;
import com.mycompany.movie.core.repository.MovieRepositoryInterface;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<Movie> list() {
        List<Movie> movies =new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            for(String line; (line = br.readLine()) != null; ){
                final Movie movie = new Movie();
                final String[] titreEtGenre = line.split(";");
                movie.setTitre(titreEtGenre[0]);
                movie.setGenre(titreEtGenre[1]);
                movies.add(movie);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return movies;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
}
