package com.example.liste;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;

public class ContactAdapter extends ArrayAdapter<Contact> {
    private ArrayList<Contact> contactList;
    private LayoutInflater inflater;
    private int resource;

    public ContactAdapter(Context context, int resource, ArrayList<Contact> contactList) {
        super(context, resource, contactList);
        this.contactList = contactList;
        this.inflater = LayoutInflater.from(context);
        this.resource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = inflater.inflate(resource, parent, false);
        }

        TextView tvName = view.findViewById(R.id.Nom);
        TextView tvPrenom = view.findViewById(R.id.Prenom);

        Contact contact = contactList.get(position);

        tvName.setText(contact.getNom());
        tvPrenom.setText(contact.getPrenom());

        return view;
    }
}

