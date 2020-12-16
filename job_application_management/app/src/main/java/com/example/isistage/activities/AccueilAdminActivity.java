package com.example.isistage.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.isistage.R;

public class AccueilAdminActivity extends AppCompatActivity {

    ImageView imgLogo;
    Button btnTous, btnEtuEnRecherche, btnEtuAyantTrouve;
    TextView tvBonjourNomUser;
    Context ctx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ctx = this;
        setContentView(R.layout.activity_accueil_admin);

        //
        imgLogo = findViewById(R.id.img_logo);
        btnTous = findViewById(R.id.btn_tous);
        btnEtuEnRecherche = findViewById(R.id.btn_etudiant_recherche);
        btnEtuAyantTrouve = findViewById(R.id.btn_trouvee);
        tvBonjourNomUser = findViewById(R.id.tv_bonjour);

        Intent retour = getIntent();
        String prenomUser = retour.getStringExtra("prenomUser");
        tvBonjourNomUser.setText("Bonjour " + prenomUser);

        ////
        btnTous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ctx, TousEtudiantsActivity.class);
                startActivity(intent);
            }
        });

        ///
        btnEtuEnRecherche.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ctx, EtudiantByStatutActivity.class);
                String statut = "false";
                intent.putExtra("statut", statut);
                startActivity(intent);
            }
        });

        ///
        btnEtuAyantTrouve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ctx, EtudiantByStatutActivity.class);
                String statut = "true";
                intent.putExtra("statut", statut);
                startActivity(intent);
            }
        });
    }
}