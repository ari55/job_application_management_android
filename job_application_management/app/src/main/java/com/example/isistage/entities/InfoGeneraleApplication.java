package com.example.isistage.entities;

public class InfoGeneraleApplication {
    int id;
    String commentaire;
    boolean etat_suivie;
    //
    int id_doc_achemine;
    boolean cv;
    boolean letre_motivation;
    boolean releve_note;
    boolean autres;
    boolean lesreferences;
    //
    int id_info_generale_application;
    String date_application;
    String nom_de_lentreprise;
    String nom_contact_de_lentreprise;
    long telephone;
    String email;
    String linkedin;
    String addresse;

    public InfoGeneraleApplication(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public boolean isEtat_suivie() {
        return etat_suivie;
    }

    public void setEtat_suivie(boolean etat_suivie) {
        this.etat_suivie = etat_suivie;
    }

    public int getId_doc_achemine() {
        return id_doc_achemine;
    }

    public void setId_doc_achemine(int id_doc_achemine) {
        this.id_doc_achemine = id_doc_achemine;
    }

    public boolean isCv() {
        return cv;
    }

    public void setCv(boolean cv) {
        this.cv = cv;
    }

    public boolean isLetre_motivation() {
        return letre_motivation;
    }

    public void setLetre_motivation(boolean letre_motivation) {
        this.letre_motivation = letre_motivation;
    }

    public boolean isReleve_note() {
        return releve_note;
    }

    public void setReleve_note(boolean releve_note) {
        this.releve_note = releve_note;
    }

    public boolean isAutres() {
        return autres;
    }

    public void setAutres(boolean autres) {
        this.autres = autres;
    }

    public boolean isLesreferences() {
        return lesreferences;
    }

    public void setLesreferences(boolean lesreferences) {
        this.lesreferences = lesreferences;
    }

    public int getId_info_generale_application() {
        return id_info_generale_application;
    }

    public void setId_info_generale_application(int id_info_generale_application) {
        this.id_info_generale_application = id_info_generale_application;
    }

    public String getDate_application() {
        return date_application;
    }

    public void setDate_application(String date_application) {
        this.date_application = date_application;
    }

    public String getNom_de_lentreprise() {
        return nom_de_lentreprise;
    }

    public void setNom_de_lentreprise(String nom_de_lentreprise) {
        this.nom_de_lentreprise = nom_de_lentreprise;
    }

    public String getNom_contact_de_lentreprise() {
        return nom_contact_de_lentreprise;
    }

    public void setNom_contact_de_lentreprise(String nom_contact_de_lentreprise) {
        this.nom_contact_de_lentreprise = nom_contact_de_lentreprise;
    }

    public long getTelephone() {
        return telephone;
    }

    public void setTelephone(long telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }

    public String getAddresse() {
        return addresse;
    }

    public void setAddresse(String addresse) {
        this.addresse = addresse;
    }
}
