package com.example.contacte;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;


public class activity_contact_detail extends AppCompatActivity {
    private TextView contactName;
    private TextView contactPrenom;
    private TextView contactNumero;
    private ImageView contactPhoto;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_detail);

        contactName = findViewById(R.id.contactName);
        contactPrenom = findViewById(R.id.contactPrenom);
        contactNumero = findViewById(R.id.contactNumero);
        contactPhoto = findViewById(R.id.contactPhoto);

        contactPhoto.setImageResource(R.drawable.ic_launcher_foreground);

            Contact contact = (Contact) getIntent().getParcelableExtra("contact");
            if (contact != null) {
                contactName.setText(contact.getPrenom());
                contactPrenom.setText(contact.getNom());
                contactNumero.setText(contact.getNumero());
            }
        }
    }

