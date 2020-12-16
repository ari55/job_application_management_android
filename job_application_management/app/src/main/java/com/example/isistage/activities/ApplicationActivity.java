package com.example.isistage.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.isistage.R;
import com.example.isistage.managers.TaskInfoGeneraleApp;

public class ApplicationActivity extends AppCompatActivity {

    Button btnAjouter, btnVoirPlus;
    TextView tvPrenomUser;
    ListView listViewApp;
    Context ctx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ctx = this;
        setContentView(R.layout.activity_application);
        //
        btnAjouter = findViewById(R.id.btn_ajouter_app);
        btnVoirPlus = findViewById(R.id.btn_voir_plus);
        tvPrenomUser = findViewById(R.id.tv_bonjour_etu);
        listViewApp = findViewById(R.id.listview_application);


        Intent retour = getIntent();
        String prenomUser = retour.getStringExtra("prenomUser");
        String idUser = retour.getStringExtra("idUser");

        tvPrenomUser.setText(prenomUser);

        TaskInfoGeneraleApp taskInfo = new TaskInfoGeneraleApp(ctx, listViewApp);
        taskInfo.execute("https://test-api3.herokuapp.com/application?idUser=" + idUser);
    }
}