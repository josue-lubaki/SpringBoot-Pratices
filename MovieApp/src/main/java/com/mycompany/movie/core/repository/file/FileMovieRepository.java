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

    public Movie addMovie(Movie movie){
        FileWriter writer;
        try{
            writer=new FileWriter(file,true);
            long lastMovieId = list().stream().map(Movie::getId).max(Long::compare).orElse(0L);
            movie.setId(++lastMovieId);
            writer.write(movie.getId() + ";" + movie.getTitre() + ";" + movie.getGenre() + "\n");
            writer.close();
            return movie;
        }
        catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Movie> list() {
        List<Movie> movies =new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            for(String line; (line = br.readLine()) != null; ){
                final Movie movie = new Movie();
                final String[] titreEtGenre = line.split(";");
                movie.setId(Long.parseLong(titreEtGenre[0]));
                movie.setTitre(titreEtGenre[1]);
                movie.setGenre(titreEtGenre[2]);
                movies.add(movie);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return movies;
    }

    @Override
    public Movie getById(long id) {
        final Movie movie = new Movie();
        movie.setId(id);
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            for(String line; (line = br.readLine()) != null; ) {

                final String[] allProperties = line.split(";");
                final long nextMovieId = Long.parseLong(allProperties[0]);
                if (nextMovieId == id) {
                    movie.setTitre(allProperties[1]);
                    movie.setGenre(allProperties[2]);
                    return movie;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.err.println("A movie from the file does not have a proper id");
            e.printStackTrace();
        }
        movie.setTitre("UNKNOWN");
        movie.setGenre("UNKNOWN");
        return movie;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
}
