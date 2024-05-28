package com.example.contacte;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.widget.ArrayAdapter;

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

        TextView tvName = view.findViewById(R.id.fullName);
        TextView tvPrenom = view.findViewById(R.id.Name);

        tvName.setText(contact.getNom());
        tvPrenom.setText(contact.getPrenom());

        return view;
    }
}
