package com.mycompany.movieweb.movieweb.form;

import javax.annotation.sql.DataSourceDefinition;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class MovieForm {
    @NotBlank(message = "Veuillez entrer un titre")
    @Size(max = 20, message = "Entrez un titre de 20 caractères au plus")
    private String titre;
    private int nbreExemplaireDisponible;
    @NotBlank(message = "Veuillez choisir un genre")
    private String genre;
    private String acteurPrincipal;
    private String descriptions;
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

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String description) {
        this.descriptions = description;
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
