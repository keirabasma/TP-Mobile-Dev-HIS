package com.example.contacte;

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

    public ContactAdapter(Context context, int resource, ArrayList<Contact> objects) {
        super(context, resource, objects);
        this.contactList = objects;
        this.resource = resource;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = inflater.inflate(resource, null);
        }

        Contact contact = contactList.get(position);

        TextView Name = view.findViewById(R.id.fullName);
        TextView Prenom = view.findViewById(R.id.Name);

        Name.setText(contact.getNom());
        Prenom.setText(contact.getPrenom());

        return view;
    }
}
