package com.example.contact;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ContactAdapter extends ArrayAdapter<Contact> {
    ArrayList<Contact> contactList;
    LayoutInflater inflat;
    int rc;

    public ContactAdapter(Context c, int resource, ArrayList<Contact> L) {
        super(c, resource, L);
        inflat = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        rc = resource;
        contactList = L;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            v = inflat.inflate(rc, null);
        }
        TextView tvName = (TextView) v.findViewById(R.id.TV_Nom);
        TextView tvPrenom = (TextView) v.findViewById(R.id.TV_Prenom);
        ImageView imageView = (ImageView) v.findViewById(R.id.profileImage);

        tvName.setText(contactList.get(position).getNom());
        tvPrenom.setText(contactList.get(position).getPrenom());
        imageView.setImageResource(contactList.get(position).getPhoto());

        return v;
    }

    @Override
    public int getCount() {
        return contactList.size();
    }
}
