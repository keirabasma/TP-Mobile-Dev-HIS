package com.example.tp4_allaglyes;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;


public class ListItemActivity1 extends AppCompatActivity {
    private TextView fname;
    private TextView lname;
    private TextView phone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_item1);

        fname = findViewById(R.id.TV_Nom);
        lname = findViewById(R.id.TV_Prenom);
        phone = findViewById(R.id.TV_Numero);


        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            Contact contact = (Contact) extras.getSerializable("contact");

            if (contact != null) {
                fname.setText(contact.getPrenom());
                lname.setText(contact.getNom());
                phone.setText(contact.getNumero());


            }
}
}
}
