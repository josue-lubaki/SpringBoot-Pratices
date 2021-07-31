package com.mycompany.movieweb.movieweb.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class MovieForm {
    @NotBlank(message = "Veuillez entrer un titre")
    @Size(max = 20, message = "Entrez un titre de 20 caractères au plus")
    private String titre;

    @NotBlank(message = "Veuillez choisir un genre")
    private String genre;
    private long id;
    private String descriptions;

    @NotBlank
    @Size(max = 20, message = "Entrez un titre de 20 caractères au plus")
    private String firstNameActor;

    @Size(max = 20, message = "Entrez un titre de 20 caractères au plus")
    private String lastNameActor;

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

    public String getFirstNameActor() {
        return firstNameActor;
    }

    public void setFirstNameActor(String firstNameActor) {
        this.firstNameActor = firstNameActor;
    }

    public String getLastNameActor() {
        return lastNameActor;
    }

    public void setLastNameActor(String lastNameActor) {
        this.lastNameActor = lastNameActor;
    }
}
