package com.example.contact;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ContactDetailActivity extends AppCompatActivity {

    TextView tvName, tvPrenom, tvTelephone;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_detail);

        tvName = findViewById(R.id.TV_Detail_Nom);
        tvPrenom = findViewById(R.id.TV_Detail_Prenom);
        tvTelephone = findViewById(R.id.TV_Detail_Telephone);
        imageView = findViewById(R.id.Detail_ProfileImage);

        Contact contact = (Contact) getIntent().getSerializableExtra("contact");

        if (contact != null) {
            tvName.setText(contact.getNom());
            tvPrenom.setText(contact.getPrenom());
            tvTelephone.setText(contact.getTelephone());
            imageView.setImageResource(contact.getPhoto());
        }
    }
}
