package com.example.isistage.managers;

import android.content.ContentValues;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

public class TaskCreerApplication extends AsyncTask<String, Integer, String> {
    Context ctx;

    public TaskCreerApplication(Context ctx) {
        this.ctx = ctx;
    }

    @Override
    protected String doInBackground(String... params) {
         //Postdata(params);
        try {
            URL url = new URL("https://test-api3.herokuapp.com/application");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            url = new URL(params[0]);
            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("Accept", "*/*");

            //ContentValues values1 = new ContentValues();
            JSONObject values1 = new JSONObject();
            JSONObject values2 = new JSONObject();
            JSONObject values3 = new JSONObject();
            JSONObject values4 = new JSONObject();
            JSONObject values5 = new JSONObject();
            JSONObject values6 = new JSONObject();
            JSONObject values7 = new JSONObject();

            values1.put("date",params[0]);
            values1.put("nomEntreprise",params[1]);
            values1.put("nomContactDeEntreprise",params[2]);
            values1.put("telephone",params[3]);
            values1.put("email",params[4]);
            values1.put("linkedin",params[5]);
            values1.put("address",params[6]);
            //
            values2.put("titreDuPoste",params[7]);
            values2.put("descriptionPsote",params[8]);
            values2.put("languageUtilise",params[9]);
            values2.put("numeroReference",params[10]);
            values2.put("remuneration",params[11]);
            values2.put("dateFinAffichage",params[12]);
            values2.put("sourcePoste",params[13]);
            values2.put("matchPoste",params[14]);
//

            values3.put("cv",params[15]);
            values3.put("lettre_motivation",params[16]);
            values3.put("releve_note",params[17]);
            values3.put("autres",params[18]);
            values3.put("lesreferences",params[19]);
            //
            values4.put("dateSuiviTelephone",params[20]);
            values4.put("dateSuiviEnPersonne",params[21]);
            values4.put("dateRelanceInternet",params[22]);
            //

            values5.put("dateEntretien",params[23]);
            values5.put("courrielRemerciement",params[24]);
            values5.put("invitationLinkedIn",params[25]);
            values5.put("courrielOuAppelDeSuivi",params[26]);
//
            values6.put("dateEntrevue",params[27]);
            values6.put("courrielRemerciement",params[28]);
            values6.put("courrielOuAppelSuivi",params[29]);
            values6.put("courrielOuAppelDeSuivi",params[30]);
            //
            values7.put("commentaire",params[31]);

            JSONObject values0 = new JSONObject();

            values0.put("infoGenerale",values1 );
            values0.put("infoSpecifique",values2 );
            values0.put("documentAchemine",values3 );
            values0.put("suiviApplication",values4 );
            values0.put("suiviTelephonique",values5 );
            values0.put("suiviEnPersonne",values6 );
            values0.put("commentaire",values7 );

            StringBuilder result = new StringBuilder();
            httpURLConnection.connect();

            OutputStream outputStream = httpURLConnection.getOutputStream();

            BufferedWriter  bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
           // bufferedWriter.write(getQuery(values0));
            bufferedWriter.flush();

            int  statusCode = httpURLConnection.getResponseCode();

            InputStream inputStream = httpURLConnection.getInputStream();

            if (statusCode == 200) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                int data = inputStreamReader.read();
                while (data != -1) {
                    char current = (char) data;
                    result.append(current);
                    data = inputStreamReader.read();
                }

               // JSONObject jsonObject = new JSONObject(values0);

                Log.i("Result",String.valueOf(values0));

            } else {
                Log.i("Result","false");
                return null;
            }



        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return null;
    }
    private String getQuery(ContentValues values) throws UnsupportedEncodingException
    {
        StringBuilder result = new StringBuilder();
        boolean first = true;

        for (Map.Entry<String, Object> entry : values.valueSet())
        {
            if (first)
                first = false;
            else
                result.append("&");

            result.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
            result.append("=");
            result.append(URLEncoder.encode(String.valueOf(entry.getValue()), "UTF-8"));
        }

        Log.i("Result",result.toString());

        return result.toString();
    }
    public void Postdata(String[] valuse) {


    }
}
