package com.mycompany.movie.core.repository.file;

import com.mycompany.movie.core.entity.Movie;
import com.mycompany.movie.core.repository.MovieRepositoryInterface;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

//@Repository
public class FileMovieRepository implements MovieRepositoryInterface {

    @Value("${movieFile.path}")
    private File file;

    public Movie save(Movie movie){
        FileWriter writer;
        try{
            writer=new FileWriter(file,true);
            long lastMovieId = StreamSupport.stream(findAll().spliterator(), false).map(Movie::getId).max(Long::compare).orElse(0L);
            movie.setId(++lastMovieId);
            writer.write(movie.getId() + ";" + movie.getTitre() + ";" + movie.getGenre() + ";" + movie.getDescriptions() + "\n");
            writer.close();
            return movie;
        }
        catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public <S extends Movie> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Movie> findById(Long id) {
        final Movie movie = new Movie();
        movie.setId(id);
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            for(String line; (line = br.readLine()) != null; ) {

                final String[] allProperties = line.split(";");
                final long nextMovieId = Long.parseLong(allProperties[0]);
                if (nextMovieId == id) {
                    movie.setTitre(allProperties[1]);
                    movie.setGenre(allProperties[2]);
                    movie.setDescriptions(allProperties[3]);
                    return Optional.of(movie);
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
        movie.setDescriptions("UNKNOWN");
        return Optional.of(movie);
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public List<Movie> findAll() {
        List<Movie> movies =new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            for(String line; (line = br.readLine()) != null; ){
                final Movie movie = new Movie();
                final String[] titreEtGenre = line.split(";");
                movie.setId(Long.parseLong(titreEtGenre[0]));
                movie.setTitre(titreEtGenre[1]);
                movie.setGenre(titreEtGenre[2]);
                movie.setDescriptions(titreEtGenre[3]);
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
    public Iterable<Movie> findAllById(Iterable<Long> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void delete(Movie movie) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteAll(Iterable<? extends Movie> iterable) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteAll() {
        throw new UnsupportedOperationException();
    }


    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
}
