package com.example.isistage.entities;

import java.sql.Date;

public class User {
    int id;
    long telephone;
    String nom;
    String prenom;
    int programme_id;
    String email;
    String password;
    String date_naissance;
    int id_privilge;
    Boolean status;
    String image_name;


    public User(){
    }

    public User(int id, long telephone, String nom, String prenom, int programme_id, String email, String password, String date_naissance, int id_privilge, Boolean status, String image_name) {
        this.id = id;
        this.telephone = telephone;
        this.nom = nom;
        this.prenom = prenom;
        this.programme_id = programme_id;
        this.email = email;
        this.password = password;
        this.date_naissance = date_naissance;
        this.id_privilge = id_privilge;
        this.status = status;
        this.image_name = image_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getTelephone() {
        return telephone;
    }

    public void setTelephone(long telephone) {
        this.telephone = telephone;
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

    public int getProgramme_id() {
        return programme_id;
    }

    public void setProgramme_id(int programme_id) {
        this.programme_id = programme_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDate_naissance() {
        return date_naissance;
    }

    public void setDate_naissance(String date_naissance) {
        this.date_naissance = date_naissance;
    }

    public int getId_privilge() {
        return id_privilge;
    }

    public void setId_privilge(int id_privilge) {
        this.id_privilge = id_privilge;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getImage_name() {
        return image_name;
    }

    public void setImage_name(String image_name) {
        this.image_name = image_name;
    }
}
