package com.example.isistage.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.isistage.R;
import com.example.isistage.adapter.UserAdapter;
import com.example.isistage.adapter.UserWithProgramAdapter;
import com.example.isistage.entities.User;
import com.example.isistage.entities.UserWithProgrammeName;
import com.example.isistage.managers.TaskUserWithProgrammeName;
import com.google.gson.Gson;

import java.util.concurrent.ExecutionException;

public class EtudiantByStatutActivity extends AppCompatActivity {

    Context ctx;
    ListView listView;
    TaskUserWithProgrammeName taskUser;
    UserWithProgramAdapter adapter;
    UserWithProgrammeName etudiant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ctx = this;
        setContentView(R.layout.activity_etudiant_by_statut);

        listView = findViewById(R.id.list_view_etu_filtree);

        Intent retour = getIntent();
        String statutSelected = retour.getStringExtra("statut");

        taskUser = new TaskUserWithProgrammeName(listView, ctx);
        taskUser.execute("https://test-api3.herokuapp.com/users?idStatut=" + statutSelected);


        Gson gson = new Gson();
        try {
            adapter = new UserWithProgramAdapter(ctx, R.id.list_view_etu_filtree, gson.fromJson(taskUser.get(), UserWithProgrammeName[].class));
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                etudiant = adapter.getItem(i);
                String idEtudiant = Integer.toString(etudiant.getId());
                String prenomEtudiant = etudiant.getPrenom();

                Intent intent = new Intent(ctx, ApplicationActivity.class);
                intent.putExtra("idUser", idEtudiant);
                intent.putExtra("prenomUser", prenomEtudiant);
                startActivity(intent);
            }
        });

    }
}