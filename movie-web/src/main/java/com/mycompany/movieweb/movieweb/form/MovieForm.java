package com.mycompany.movieweb.movieweb.form;

import javax.annotation.sql.DataSourceDefinition;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class MovieForm {
    @NotBlank()
    @Size(max = 20)
    private String titre;
    private int nbreExemplaireDisponible;
    @NotBlank
    private String genre;
    private String acteurPrincipal;
    private long id;

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
}
