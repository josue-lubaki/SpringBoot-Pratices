package com.mycompany.movie.core.entity;

public class Movie {
    private String titre;
    private int nbreExemplaireDisponible;
    private String genre;
    private String acteurPrincipal;
    private long id;
    private String descriptions;

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

    public int getNbreExemplaireDisponible() {
        return nbreExemplaireDisponible;
    }

    public void setNbreExemplaireDisponible(int nbreExemplaireDisponible) {
        this.nbreExemplaireDisponible = nbreExemplaireDisponible;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getActeurPrincipal() {
        return acteurPrincipal;
    }

    public void setActeurPrincipal(String acteurPrincipal) {
        this.acteurPrincipal = acteurPrincipal;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String description) {
        this.descriptions = description;
    }
}
