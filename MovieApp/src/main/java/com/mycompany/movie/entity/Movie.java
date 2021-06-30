package com.mycompany.movie.entity;

public class Movie {
    private String titre;
    private int nbreExemplaireDisponible;
    private String genre;
    private String acteurPrincipal;

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
}
