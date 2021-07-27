package com.mycompany.movie.core.repository.database;

import com.mycompany.movie.core.entity.Movie;
import com.mycompany.movie.core.repository.MovieRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository
public class MovieRepository implements MovieRepositoryInterface {

    @Autowired
    JdbcTemplate jdbcTemplate = new JdbcTemplate();

    @Override
    public Movie addMovie(Movie movie) {
        KeyHolder kh = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
                PreparedStatement ps = connection.prepareStatement("INSERT INTO MOVIE (TITLE, GENRE, DESCRIPTION) VALUES(?,?,?)",
                Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, movie.getTitre());
                ps.setString(2, movie.getGenre());
                ps.setString(3, movie.getDescriptions()!=null ? movie.getDescriptions() : "description manquante");
                return ps;
            }, kh);
        movie.setId(kh.getKey().longValue());
        return movie;
    }

    @Override
    public List<Movie> list() {
        return jdbcTemplate.query("SELECT ID,TITLE,GENRE FROM MOVIE",
                (rs, rowNum) -> new Movie(
                        rs.getLong("ID"),
                        rs.getString("TITLE"),
                        rs.getString("GENRE")
                )
        );
    }

    @Override
    public Movie getById(long id) {
        return jdbcTemplate.queryForObject(
                "SELECT ID,TITLE,GENRE,DESCRIPTION FROM MOVIE WHERE ID=?",
                new Object[]{id},
                (rs, rowNum) -> new Movie(
                        rs.getLong("ID"),
                        rs.getString("TITLE"),
                        rs.getString("GENRE"),
                        rs.getString("DESCRIPTION")
                )
        );
    }
}
