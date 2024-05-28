package com.example.contacte;

import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class activity_contact_detail extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_detail);

        Contact contact = (Contact) getIntent().getSerializableExtra("contact");

        TextView nomTextView = findViewById(R.id.contactName);
        TextView prenomTextView = findViewById(R.id.contactPrenom);
        TextView numeroTextView = findViewById(R.id.contactNumero);

        if (contact != null) {
            nomTextView.setText(contact.getNom());
            prenomTextView.setText(contact.getPrenom());
            numeroTextView.setText(contact.getNumero());
        }

    }
}
