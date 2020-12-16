package com.example.isistage.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.example.isistage.R;
import com.example.isistage.adapter.UserAdapter;
import com.example.isistage.entities.User;
import com.example.isistage.managers.TaskProgramme;
import com.example.isistage.managers.TaskUser;
import com.google.gson.Gson;

import java.util.concurrent.ExecutionException;


public class TousEtudiantsActivity extends AppCompatActivity {

    LinearLayout llProgrammes;
    TaskProgramme taskProgramme;
    TaskUser taskUser;
    ListView listView;
    UserAdapter adapter;
    User etudiant;
    Context ctx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ctx = this;
        setContentView(R.layout.activity_tous_etudiants);

        //
        llProgrammes = findViewById(R.id.ll_programmes);
        listView = findViewById(R.id.list_view_tous_etudiants);

        taskProgramme = new TaskProgramme(llProgrammes,ctx);
        taskProgramme.execute("https://test-api3.herokuapp.com/programme");

        taskUser = new TaskUser(ctx, listView);
        taskUser.execute("https://test-api3.herokuapp.com/users");


        ///Recuperation de la liste des users
        try {
            Gson gson = new Gson();
            adapter = new UserAdapter(ctx, R.id.list_view_tous_etudiants, gson.fromJson(taskUser.get(), User[].class));
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                etudiant = adapter.getItem(i);
                /*Toast toast = Toast.makeText(ctx, "id : " + etudiant.getId(), Toast.LENGTH_SHORT);
                toast.show();*/
                String idEtudiant = Integer.toString(etudiant.getId());
                String prenomUser = etudiant.getPrenom();
                Intent intent = new Intent(ctx, ApplicationActivity.class);
                Intent intent1 = new Intent(ctx, CreerApplication.class);
                intent1.putExtra("idUser1", idEtudiant);
                intent.putExtra("idUser", idEtudiant);
                intent.putExtra("prenomUser", prenomUser);
                startActivity(intent);
            }
        });



    }
}