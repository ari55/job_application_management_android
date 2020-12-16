package com.example.isistage.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.isistage.R;
import com.example.isistage.entities.User;

public class UserAdapter extends ArrayAdapter<User> {

    int idLayout;
    Context ctx;
    TextView tvNom, tvPrenom;
    CheckBox checkBoxStatut;

    public UserAdapter(@NonNull Context context, int resource, @NonNull User[] objects) {
        super(context, resource, objects);
        this.idLayout = resource;
        this.ctx = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //return super.getView(position, convertView, parent);
        User user = getItem(position);

        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(idLayout, null);
        }

        tvNom = convertView.findViewById(R.id.lv_user_nom);
        tvPrenom = convertView.findViewById(R.id.lv_user_prenom);
        checkBoxStatut = convertView.findViewById(R.id.lv_user_statut);

        tvPrenom.setText(user.getNom());
        tvNom.setText(user.getPrenom());
        checkBoxStatut.setChecked(user.getStatus());

        return convertView;
    }


}
