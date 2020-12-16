package com.example.isistage.managers;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ListView;

import androidx.annotation.Nullable;

import com.example.isistage.R;
import com.example.isistage.adapter.UserWithProgramAdapter;
import com.example.isistage.entities.UserWithProgrammeName;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class TaskUserWithProgrammeName extends AsyncTask<String, Nullable, String> {

    Context ctx;
    ListView listView;

    public TaskUserWithProgrammeName(ListView listView, Context ctx) {
        this.ctx = ctx;
        this.listView = listView;
    }

    @Override
    protected String doInBackground(String... strings) {

        String json = "";

        try {
            URL url = new URL(strings[0]);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(false);
            connection.setDoInput(true);

            /*BufferedWriter out = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()));
            out.write("idStatut=" + strings[1]);
            out.flush();
            out.close();*/
            connection.connect();
            int code = connection.getResponseCode();
            if (code == HttpURLConnection.HTTP_OK) {

                String line;
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                while ((line = in.readLine()) != null)
                    json += line;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;

    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        //Log.d("debug-test", s);

        Gson gson = new Gson();
        UserWithProgrammeName[] users = gson.fromJson(s, UserWithProgrammeName[].class);

        UserWithProgramAdapter adapter = new UserWithProgramAdapter(ctx, R.layout.listview_user_with_program_name, users);
        listView.setAdapter(adapter);
    }
}
