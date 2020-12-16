package com.example.isistage.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.isistage.R;
import com.example.isistage.activities.ApplicationActivity;
import com.example.isistage.activities.LoginActivity;
import com.example.isistage.activities.VoirDetailAppActivity;
import com.example.isistage.entities.InfoGeneraleApplication;
import com.example.isistage.managers.TaskDeleteApp;
import com.example.isistage.managers.TaskInfoGeneraleApp;
import com.example.isistage.managers.TaskUserConnexion;


public class InfoGeneraleApplicationAdapter extends ArrayAdapter<InfoGeneraleApplication> {

    int idLayout;
    Context ctx;
    TextView tvDate, tvEntreprise, tvNomContact, tvTelephone;
    ImageButton appToDelelete,notificationStephanie;
    Button btnDetail;

    public InfoGeneraleApplicationAdapter(@NonNull Context context, int resource, @NonNull InfoGeneraleApplication[] objects) {
        super(context, resource, objects);
        this.idLayout = resource;
        this.ctx = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull final ViewGroup parent) {
        //return super.getView(position, convertView, parent);
        final InfoGeneraleApplication infoGeneralApp = getItem(position);

        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(idLayout, null);
        }

        tvDate = convertView.findViewById(R.id.tv_date_application);
        tvEntreprise = convertView.findViewById(R.id.tv_nom_entreprise);
        tvNomContact = convertView.findViewById(R.id.tv_nom_contact);
        tvTelephone = convertView.findViewById(R.id.tv_tel_contact);
        btnDetail = convertView.findViewById(R.id.btn_voir_plus);
        appToDelelete = convertView.findViewById(R.id.img_delete_app);
        notificationStephanie=convertView.findViewById(R.id.notificationSteph);
        tvDate.setText(infoGeneralApp.getDate_application());
        tvEntreprise.setText(infoGeneralApp.getNom_de_lentreprise());
        tvNomContact.setText(infoGeneralApp.getNom_contact_de_lentreprise());
        tvTelephone.setText(Long.toString(infoGeneralApp.getTelephone()));



        if(infoGeneralApp.isEtat_suivie()==true){

            notificationStephanie.setVisibility(View.VISIBLE);
        }
        notificationStephanie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });

        appToDelelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                Intent intent = ((ApplicationActivity) getContext()).getIntent();
                final String idUser = intent.getStringExtra("idUser");
                final String idApp = Integer.toString(infoGeneralApp.getId());

                AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
                builder.setTitle("Suppression de l'application");
                builder.setMessage("Etes-vous sure de vouloir suppprimer cette application ?");

                builder.setPositiveButton("OUI", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        TaskDeleteApp taskDeleteApp = new TaskDeleteApp();
                        taskDeleteApp.execute("https://test-api3.herokuapp.com/application?idAppToDelete=" + idApp + "&idUser=" + idUser);
                        notifyDataSetChanged();
                    }
                });

                builder.setNegativeButton("ANNULER", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();

            }
        });

        return convertView;
    }

    public void remove(InfoGeneraleApplication infoGeneraleApplication){
        this.remove(infoGeneraleApplication);
        this.notifyDataSetChanged();
    }
}
