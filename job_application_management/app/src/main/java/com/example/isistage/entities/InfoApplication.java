package com.example.isistage.entities;

public class InfoApplication {
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
    //
    int id_info_specifique;
    String titre_du_poste;
    String description_poste;
    String language_utilise;
    String numero_reference;
    double remuneration;
    String date_fin_affichage;
    String source_poste;
    String match_poste;
    //
    int id_suivie_application;
    String date_suivie_telephonique;
    String date_suivie_en_personne;
    String relance_interet;
    //
    int id_suivie_en_personne;
    String date_entrevue;
    String courriel_remerciement;
    String invitation_linkedin;
    String courriel_ouappel_suivie;
    //
    int id_suivie_telephonique;
    String date_entretien;
    String courriel_remerciement_st;
    String invitation_linkedin_st;
    String courriel_ouappel_suivie_st;
    //


    public InfoApplication(){

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

    public int getId_info_specifique() {
        return id_info_specifique;
    }

    public void setId_info_specifique(int id_info_specifique) {
        this.id_info_specifique = id_info_specifique;
    }

    public String getTitre_du_poste() {
        return titre_du_poste;
    }

    public void setTitre_du_poste(String titre_du_poste) {
        this.titre_du_poste = titre_du_poste;
    }

    public String getDescription_poste() {
        return description_poste;
    }

    public void setDescription_poste(String description_poste) {
        this.description_poste = description_poste;
    }

    public String getLanguage_utilise() {
        return language_utilise;
    }

    public void setLanguage_utilise(String language_utilise) {
        this.language_utilise = language_utilise;
    }

    public String getNumero_reference() {
        return numero_reference;
    }

    public void setNumero_reference(String numero_reference) {
        this.numero_reference = numero_reference;
    }

    public double getRemuneration() {
        return remuneration;
    }

    public void setRemuneration(double remuneration) {
        this.remuneration = remuneration;
    }

    public String getDate_fin_affichage() {
        return date_fin_affichage;
    }

    public void setDate_fin_affichage(String date_fin_affichage) {
        this.date_fin_affichage = date_fin_affichage;
    }

    public String getSource_poste() {
        return source_poste;
    }

    public void setSource_poste(String source_poste) {
        this.source_poste = source_poste;
    }

    public String getMatch_poste() {
        return match_poste;
    }

    public void setMatch_poste(String match_poste) {
        this.match_poste = match_poste;
    }

    public int getId_suivie_application() {
        return id_suivie_application;
    }

    public void setId_suivie_application(int id_suivie_application) {
        this.id_suivie_application = id_suivie_application;
    }

    public String getDate_suivie_telephonique() {
        return date_suivie_telephonique;
    }

    public void setDate_suivie_telephonique(String date_suivie_telephonique) {
        this.date_suivie_telephonique = date_suivie_telephonique;
    }

    public String getDate_suivie_en_personne() {
        return date_suivie_en_personne;
    }

    public void setDate_suivie_en_personne(String date_suivie_en_personne) {
        this.date_suivie_en_personne = date_suivie_en_personne;
    }

    public String getRelance_interet() {
        return relance_interet;
    }

    public void setRelance_interet(String relance_interet) {
        this.relance_interet = relance_interet;
    }

    public int getId_suivie_en_personne() {
        return id_suivie_en_personne;
    }

    public void setId_suivie_en_personne(int id_suivie_en_personne) {
        this.id_suivie_en_personne = id_suivie_en_personne;
    }

    public String getDate_entrevue() {
        return date_entrevue;
    }

    public void setDate_entrevue(String date_entrevue) {
        this.date_entrevue = date_entrevue;
    }

    public String getCourriel_remerciement() {
        return courriel_remerciement;
    }

    public void setCourriel_remerciement(String courriel_remerciement) {
        this.courriel_remerciement = courriel_remerciement;
    }

    public String getInvitation_linkedin() {
        return invitation_linkedin;
    }

    public void setInvitation_linkedin(String invitation_linkedin) {
        this.invitation_linkedin = invitation_linkedin;
    }

    public String getCourriel_ouappel_suivie() {
        return courriel_ouappel_suivie;
    }

    public void setCourriel_ouappel_suivie(String courriel_ouappel_suivie) {
        this.courriel_ouappel_suivie = courriel_ouappel_suivie;
    }

    public int getId_suivie_telephonique() {
        return id_suivie_telephonique;
    }

    public void setId_suivie_telephonique(int id_suivie_telephonique) {
        this.id_suivie_telephonique = id_suivie_telephonique;
    }

    public String getDate_entretien() {
        return date_entretien;
    }

    public void setDate_entretien(String date_entretien) {
        this.date_entretien = date_entretien;
    }

    public String getCourriel_remerciement_st() {
        return courriel_remerciement_st;
    }

    public void setCourriel_remerciement_st(String courriel_remerciement_st) {
        this.courriel_remerciement_st = courriel_remerciement_st;
    }

    public String getInvitation_linkedin_st() {
        return invitation_linkedin_st;
    }

    public void setInvitation_linkedin_st(String invitation_linkedin_st) {
        this.invitation_linkedin_st = invitation_linkedin_st;
    }

    public String getCourriel_ouappel_suivie_st() {
        return courriel_ouappel_suivie_st;
    }

    public void setCourriel_ouappel_suivie_st(String courriel_ouappel_suivie_st) {
        this.courriel_ouappel_suivie_st = courriel_ouappel_suivie_st;
    }
}
