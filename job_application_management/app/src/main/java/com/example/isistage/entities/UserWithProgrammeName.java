package com.example.isistage.entities;

public class UserWithProgrammeName {
    int id;
    String nom;
    String prenom;
    String nom_programme;

    public UserWithProgrammeName(){

    }

    public UserWithProgrammeName(int id, String nom, String prenom, String nom_programme) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.nom_programme = nom_programme;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom_programme() {
        return nom_programme;
    }

    public void setNom_programme(String nom_programme) {
        this.nom_programme = nom_programme;
    }
}
