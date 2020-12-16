package com.example.isistage.activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.isistage.R;
import com.example.isistage.entities.User;
import com.example.isistage.managers.TaskUser;
import com.example.isistage.managers.TaskUserConnexion;
import com.example.isistage.managers.TaskUserWithProgrammeName;
import com.google.gson.Gson;

import java.util.concurrent.ExecutionException;

public class LoginActivity extends AppCompatActivity {

    EditText etEmail, etPassword;
    Button btnConnexion;
    TextView tvInscription;
    TaskUserConnexion taskUserConnexion;
    Context ctx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ctx = this;

        etEmail = findViewById(R.id.et_email_login);
        etPassword = findViewById(R.id.et_pwd_login);
        btnConnexion = findViewById(R.id.btn_connexion);
        tvInscription = findViewById(R.id.tv_inscription);

        //
        tvInscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ctx, InscriptionActivity.class);
                startActivity(intent);
            }
        });

        ///
        btnConnexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();

                taskUserConnexion = new TaskUserConnexion(ctx);
                taskUserConnexion.execute("https://test-api3.herokuapp.com/login?prenom=" + email + "&password=" + password);

                try{
                    User user;
                    Gson gson = new Gson();
                    String resultJson  = taskUserConnexion.get();
                    user = gson.fromJson(resultJson, User.class);

                    if (user != null){

                        int idUser = user.getId();
                        int idPrivilege = user.getId_privilge();
                        String prenomUser = user.getPrenom();

                        if (idUser != 1){
                            Intent intentEtu = new Intent(ctx, ApplicationActivity.class);
                            intentEtu.putExtra("prenomUser", prenomUser);
                            intentEtu.putExtra("idUser", Integer.toString(idUser));
                            startActivity(intentEtu);

                        }else{
                            Intent intentAdmin = new Intent(ctx, AccueilAdminActivity.class);
                            intentAdmin.putExtra("prenomUser", prenomUser);
                            intentAdmin.putExtra("idUser", idUser);
                            startActivity(intentAdmin);
                        }

                    }else{
                        Toast toast = Toast.makeText(ctx, "Mot de passe ou email incorrect", Toast.LENGTH_LONG);
                        toast.show();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }

            }
        });

    }
}