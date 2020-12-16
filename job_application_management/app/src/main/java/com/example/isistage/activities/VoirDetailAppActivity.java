package com.example.isistage.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.isistage.R;
import com.example.isistage.entities.InfoApplication;
import com.example.isistage.entities.User;
import com.example.isistage.managers.TaskInfoApplication;
import com.google.gson.Gson;

import java.util.concurrent.ExecutionException;

public class VoirDetailAppActivity extends AppCompatActivity {
    Context ctx;
    EditText edDateApplication, edNomEntreprise, edNomContact, edEmail, edTelephone, edLinkedin, edAdresse;
    Button btnModifierInfoGen, btnModifierInfoSpe, btnModifierDocs, btnModifierSuivieApp, btnModifierSuivieTel, btnModifierSuiviEnPerson;
    EditText titrePoste, descriptionPoste, language, numReference, dateFinAffichage, remuneration,sourcePoste, match;
    CheckBox cv, lettre, reference, releveNote;
    EditText suiviCourriel, suiviTel, relanceInteret;
    EditText dateEntretien, dateCourielRemerciement, dateInvitationLinkedin, dateCourielAppelSuivie;
    EditText dateEntrevue, dateCourielRemerciementPers, dateInvitationLinkedinPers, dateCourielAppelSuiviePers;
boolean etatSuivi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ctx = this;
        setContentView(R.layout.activity_voir_detail_app);

        //
        edDateApplication = findViewById(R.id.ed_date_application);
        edNomEntreprise = findViewById(R.id.ed_nom_entreprise);
        edNomContact = findViewById(R.id.ed_nom_contact);
        edEmail = findViewById(R.id.ed_email_entreprise);
        edTelephone = findViewById(R.id.ed_telephone_contact);
        edLinkedin = findViewById(R.id.ed_linkedin_entreprise);
        edAdresse = findViewById(R.id.ed_adresse_entreprise);
        // info specifique
        titrePoste = findViewById(R.id.ed_titre_poste);
        descriptionPoste = findViewById(R.id.ed_description_poste);
        language = findViewById(R.id.ed_language);
        numReference = findViewById(R.id.ed_num_reference);
        remuneration = findViewById(R.id.ed_remuneration);
        dateFinAffichage = findViewById(R.id.ed_date_fin_affichage);
        sourcePoste = findViewById(R.id.ed_source_poste);
        match = findViewById(R.id.ed_match_poste);
        //Documents achemines
        cv = findViewById(R.id.checkbox_cv);
        lettre = findViewById(R.id.checkbox_lettre);
        reference = findViewById(R.id.checkbox_reference);
        releveNote = findViewById(R.id.checkbox_releve_note);
        //Suivie d'application
        suiviCourriel = findViewById(R.id.ed_suivie_courriel);
        suiviTel = findViewById(R.id.ed_suivie_tel);
        relanceInteret = findViewById(R.id.ed_relance_interet);
        //Entretien telephonique
        dateEntretien = findViewById(R.id.ed_date_entretien);
        dateCourielRemerciement = findViewById(R.id.ed_date_remerciement);
        dateInvitationLinkedin = findViewById(R.id.ed_date_invitation_linkedin);
        dateCourielAppelSuivie = findViewById(R.id.ed_date_courriel_suivie_appel);
        //Entretien en personne
        dateEntrevue = findViewById(R.id.ed_date_entrevue);
        dateCourielRemerciementPers = findViewById(R.id.ed_courriel_remerciement_p);
        dateInvitationLinkedinPers = findViewById(R.id.ed_date_invitaion_likedin_p);
        dateCourielAppelSuiviePers = findViewById(R.id.ed_date_courriel_suivie_appel_p);
        //
        btnModifierInfoGen = findViewById(R.id.btn_modifier_info_generale);
        btnModifierInfoSpe = findViewById(R.id.btn_modifier_info_specifique);
        btnModifierDocs = findViewById(R.id.btn_modifier_doc_achemine);
        btnModifierSuivieApp = findViewById(R.id.btn_modifier_suivie_application);
        btnModifierSuivieTel = findViewById(R.id.btn_modifier_suivie_tel);
        btnModifierSuiviEnPerson = findViewById(R.id.btn_modifier_suivie_app_en_personne);

        //
        btnModifierInfoGen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        //
        Intent intentRetour= getIntent();
        String idUser = intentRetour.getStringExtra("idApp");

        TaskInfoApplication task = new TaskInfoApplication(ctx);
        task.execute("https://test-api3.herokuapp.com/application?idApp=" + idUser);



        try {
            Gson gson = new Gson();
            String json = task.get();
            InfoApplication infoApp = gson.fromJson(json, InfoApplication.class);

            //Info generales
            etatSuivi=infoApp.isEtat_suivie();
            Log.v("clear" , ""+ etatSuivi);

            edDateApplication.setHint(infoApp.getDate_application());
            edNomEntreprise.setHint(infoApp.getNom_de_lentreprise());
            edNomContact.setHint(infoApp.getNom_contact_de_lentreprise());
            edEmail.setHint(infoApp.getEmail());
            edTelephone.setHint(Long.toString(infoApp.getTelephone()));
            edLinkedin.setHint(infoApp.getLinkedin());
            edAdresse.setHint(infoApp.getAddresse());
            //Specifications
            titrePoste.setHint(infoApp.getTitre_du_poste());
            descriptionPoste.setHint(infoApp.getDescription_poste());
            language.setHint(infoApp.getLanguage_utilise());
            numReference.setHint(infoApp.getNumero_reference());
            remuneration.setHint(Double.toString(infoApp.getRemuneration()));
            dateFinAffichage.setHint(infoApp.getDate_fin_affichage());
            sourcePoste.setHint(infoApp.getSource_poste());
            match.setHint(infoApp.getMatch_poste());
            //Documents achemines
            cv.setChecked(infoApp.isCv());
            lettre.setChecked(infoApp.isLetre_motivation());
            reference.setChecked(infoApp.isLesreferences());
            releveNote.setChecked(infoApp.isReleve_note());
            //Suivie d'application
            suiviCourriel.setHint(infoApp.getDate_suivie_en_personne());
            suiviTel.setHint(infoApp.getDate_suivie_telephonique());
            relanceInteret.setHint(infoApp.getRelance_interet());
            //Entretien telephonique
            dateEntretien.setHint(infoApp.getDate_entretien());
            dateCourielRemerciement.setHint(infoApp.getCourriel_remerciement_st());
            dateInvitationLinkedin.setHint(infoApp.getInvitation_linkedin_st());
            dateCourielAppelSuivie.setHint(infoApp.getCourriel_ouappel_suivie_st());
            //Entretien en personne
            dateEntrevue.setHint(infoApp.getDate_entrevue());
            dateCourielRemerciementPers.setHint(infoApp.getCourriel_remerciement());
            dateInvitationLinkedinPers.setHint(infoApp.getInvitation_linkedin());
            dateCourielAppelSuiviePers.setHint(infoApp.getCourriel_ouappel_suivie());


        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



    }
}