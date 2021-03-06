package com.example.isistage.managers;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.ListView;

import androidx.annotation.Nullable;

import com.example.isistage.R;
import com.example.isistage.adapter.UserAdapter;
import com.example.isistage.entities.User;
import com.example.isistage.entities.UserWithProgrammeName;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class TaskUser extends AsyncTask<String, Nullable, String> {

    Context ctx;
    ListView listView;

    public TaskUser(Context ctx, ListView listView) {
        this.ctx = ctx;
        this.listView = listView;
    }

    @Override
    protected String doInBackground(String... strings) {
        String retour = "";

        try {
            URL url = new URL(strings[0]);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(false);
            connection.setDoInput(true);
            connection.connect();

            int code = connection.getResponseCode();
            if (code == HttpURLConnection.HTTP_OK) {
                String line;
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                while ((line = in.readLine()) != null)
                    retour += line;
            }
        }catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return retour;
    }

    @Override
    protected void onPostExecute(String s) {

        Gson gson = new Gson();
        User[] users = gson.fromJson(s, User[].class);

        UserAdapter adapter = new UserAdapter(ctx, R.layout.listview_tous_etudiants, users);
        listView.setAdapter(adapter);
    }
}
