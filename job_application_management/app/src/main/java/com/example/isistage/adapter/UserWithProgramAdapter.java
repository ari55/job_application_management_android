package com.example.isistage.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.isistage.R;
import com.example.isistage.entities.UserWithProgrammeName;

public class UserWithProgramAdapter extends ArrayAdapter<UserWithProgrammeName> {
    int idLayout;
    Context ctx;
    TextView tvNom, tvPrenom, tvProgramme;

    public UserWithProgramAdapter(@NonNull Context context, int resource, @NonNull UserWithProgrammeName[] objects) {
        super(context, resource, objects);
        idLayout = resource;
        ctx = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //return super.getView(position, convertView, parent);
        UserWithProgrammeName user = getItem(position);

        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(idLayout, null);
        }

        tvNom = convertView.findViewById(R.id.lv_user_program_nom);
        tvPrenom = convertView.findViewById(R.id.lv_user_program_prenom);
        tvProgramme = convertView.findViewById(R.id.lv_user_program);

        tvNom.setText(user.getNom());
        tvPrenom.setText(user.getPrenom());
        tvProgramme.setText(user.getNom_programme());

        return convertView;
    }

}
