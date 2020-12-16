package com.example.isistage.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;

import com.example.isistage.R;
import com.example.isistage.managers.TaskCreerApplication;
import com.example.isistage.managers.TaskUserConnexion;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class CreerApplication extends AppCompatActivity {
    EditText edt_date, edt_nomEntreprise, edt_nomContactEntreprise_, edt_telephone, edt_email, edt_linkdin, edt_adresse, edt_titrePoste, edt_description_poste, edt_language_utilise, edt_numero_reference, edt_remuneration, edt_dateFinAffichage, edt_sourcePoste, edt_matchPoste, edt_datesuiviecourriel, edt_datesuivietelephonique, edt_daterelanceinteret, edt_datentretien, date_courrielremerciemente1, edt_invitationlinkdin1, edt_courrielOuappeldesuivie1, edt_dateentrevue, courrielremerciement2, invitationlinkdin2, courrielouappelsuivie2, edt_commentaire;
    Context ctx;
    CheckBox cb1, cb2, cb3, cb4,cb5;
    Button btnajoute;
    TaskCreerApplication taskCreerApplication;
    String s33;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creer_application);
        ctx = this;
        Intent retour = getIntent();
        s33 = retour.getStringExtra("idUser1");
        edt_date = findViewById(R.id.edt_date);
        edt_nomEntreprise = findViewById(R.id.edt_nomEntreprise);
        edt_nomContactEntreprise_ = findViewById(R.id.et_nomContactEntreprise);
        edt_telephone = findViewById(R.id.et_telephone);
        edt_email = findViewById(R.id.edt_email_app);
        edt_linkdin = findViewById(R.id.edt_linkdin);
        edt_adresse = findViewById(R.id.edt_adresse);
        //////////
        edt_titrePoste = findViewById(R.id.edt_titrePoste);
        edt_description_poste = findViewById(R.id.edt_descriptionPoste);
        edt_language_utilise = findViewById(R.id.edt_languageutilise);
        edt_numero_reference = findViewById(R.id.edt_numerodereference);
        edt_remuneration = findViewById(R.id.edt_remuneration);
        edt_dateFinAffichage = findViewById(R.id.edt_dateFinDaffichage);
        edt_sourcePoste = findViewById(R.id.edt_sourcePoste);
        edt_matchPoste = findViewById(R.id.edt_matchposte);
        ///////////

        edt_datesuiviecourriel = findViewById(R.id.edt_datesuivieCourriel);
        edt_datesuivietelephonique = findViewById(R.id.edt_datesuivieTelephonique);
        edt_daterelanceinteret = findViewById(R.id.edt_relanceInteret);
        edt_datentretien = findViewById(R.id.edt_datedentretien);
        date_courrielremerciemente1 = findViewById(R.id.edt_courrieleremerciement1);
        edt_invitationlinkdin1 = findViewById(R.id.edt_invitationlinkdin1);
        edt_courrielOuappeldesuivie1 = findViewById(R.id.edt_courrielOuAppelDeSuivie1);
        ///////////////
        edt_dateentrevue = findViewById(R.id.edt_datedentrevue);
        courrielremerciement2 = findViewById(R.id.edt_courrieleremerciement2);
        invitationlinkdin2 = findViewById(R.id.edt_invitationlinkdin2);
        courrielouappelsuivie2 = findViewById(R.id.edt_courrielOuAppelDeSuivie2);
        edt_commentaire = findViewById(R.id.edt_commentaire);
//////
        cb1 = findViewById(R.id.chekBCv);
        cb2 = findViewById(R.id.chekBLettreMotivation);
        cb3 = findViewById(R.id.chekBReleveNote);
        cb4 = findViewById(R.id.chekBAutre);
        cb5 = findViewById(R.id.chekReference);
//


        final Calendar myCalendar = Calendar.getInstance();
        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }

            private void updateLabel() {
                String myFormat = "yy-MM-dd"; //In which you need put here
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.CANADA);

                edt_date.setText(sdf.format(myCalendar.getTime()));
            }
        };

        edt_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(ctx, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });


        //
        btnajoute = findViewById(R.id.btn_ajouter);
        btnajoute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1 = edt_date.getText().toString();
                String s2 = edt_nomEntreprise.getText().toString();
                String s4 = edt_nomContactEntreprise_.getText().toString();
                String s5 = edt_telephone.getText().toString();
                String s6 = edt_email.getText().toString();
                String s7 = edt_linkdin.getText().toString();
                String s8 = edt_adresse.getText().toString();
                //
                String s9 = edt_titrePoste.getText().toString();
                String s10 = edt_description_poste.getText().toString();
                String s11 = edt_language_utilise.getText().toString();
                String s12 = edt_numero_reference.getText().toString();
                String s13 = edt_remuneration.getText().toString();
                String s14 = edt_dateFinAffichage.getText().toString();
                String s15 = edt_sourcePoste.getText().toString();
                String s16 = edt_matchPoste.getText().toString();
                //
//String.valueOf(faculty.isChecked())
                String s17 = String.valueOf(cb1.isChecked());
                String s18 = String.valueOf(cb2.isChecked());
                String s19 = String.valueOf(cb3.isChecked());
                String s20 = String.valueOf(cb4.isChecked());
                String s21 = String.valueOf(cb5.isChecked());


                String s22 = edt_datesuiviecourriel.getText().toString();
                String s23 = edt_datesuivietelephonique.getText().toString();
                String s24 = edt_daterelanceinteret.getText().toString();
                //
                String s25 = edt_datentretien.getText().toString();
                String s26 = date_courrielremerciemente1.getText().toString();
                String s27 = edt_invitationlinkdin1.getText().toString();
                String s28 = edt_courrielOuappeldesuivie1.getText().toString();
                //
                String s29 = edt_dateentrevue.getText().toString();
                String s30 = courrielremerciement2.getText().toString();
                String s31 = invitationlinkdin2.getText().toString();
                String s32 = courrielouappelsuivie2.getText().toString();
                //
                String s34 = edt_commentaire.getText().toString();

                Log.v("a", s17);
                taskCreerApplication = new TaskCreerApplication(ctx);
taskCreerApplication.execute(s1,s2,s4,s5,s6,s7,s8,s9,s8,s9,s10,s11,s12,s13,s14,s15,s16,s17,s18,s19,s20,s21,s22,s23,s24,s25,s26,s27,s28,s29,s30,s31,s32,s33,s34);

            }
        });


    }
}