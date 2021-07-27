package com.mycompany.movie.core.entity;

import javax.persistence.*;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="TITLE")
    private String titre;
    @Column(name="DESCRIPTION")
    private String descriptions;
    private String genre;

    public Movie(long id, String titre, String genre) {
        this.titre = titre;
        this.genre = genre;
        this.id = id;
    }

    public Movie(long id, String titre, String genre, String description) {
        this.titre = titre;
        this.genre = genre;
        this.id = id;
        this.descriptions = description;
    }

    public Movie() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }


    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String description) {
        this.descriptions = description;
    }
}
