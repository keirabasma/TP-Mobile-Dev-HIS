package com.example.liste;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class detailactivity extends AppCompatActivity {
    private TextView Nom;
    private TextView Prenom;
    private TextView Numero;

    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView Nom = findViewById(R.id.Nom);
        TextView Prenom = findViewById(R.id.Prenom);
        TextView Numero = findViewById(R.id.numero);

        Contact contact = getIntent().getParcelableExtra("contact");
        if (contact != null) {
            Nom.setText(contact.getNom());
            Prenom.setText(contact.getPrenom());
            Numero.setText(contact.getNumero());
        }
    }
}
