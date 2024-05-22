package com.example.convertisseur;

import android.app.AlertDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText monaie;
    private EditText titre;
    private EditText radioButton4;
    Button radioButton3;
    private EditText result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        RadioButton radioButton = findViewById(R.id.radioButton3);
        registerForContextMenu(radioButton);

        RadioButton radioButton1 = findViewById(R.id.radioButton4);
        registerForContextMenu(radioButton1);
    }

    private float dinarToEuro(float valeurDinar) {
        return (float) (valeurDinar * 140.45);
    }

    private float euroToDinar(float valeurEuro) {
        return (float) (valeurEuro * 0.0071);
    }

    public void convertCurrency(View view) {
        EditText edt = findViewById(R.id.monaie);
        float number = 0;
        try {
            number = Float.valueOf(edt.getText().toString());
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Veuillez entrer une valeur valide", Toast.LENGTH_SHORT).show();
            return;
        }

        RadioButton radioDinarToEuro = findViewById(R.id.radioButton3);
        float resultat;
        if (radioDinarToEuro.isChecked()) {
            resultat = dinarToEuro(number);
        } else {
            resultat = euroToDinar(number);
        }

        EditText edtResultat = findViewById(R.id.result);
        edtResultat.setText(String.valueOf(resultat));
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_contextuel, menu);
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 1:
                // Afficher le taux de conversion du dinar vers l'euro dans un Toast
                Toast.makeText(this, "Taux de conversion dinar -> euro", Toast.LENGTH_SHORT).show();
                return true;
            case 2:
                // Afficher le taux de conversion de l'euro vers le dinar dans un Toast
                Toast.makeText(this, "Taux de conversion euro -> dinar", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_options, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 1:
                // Code pour gérer la sélection de "Conversion Dinar -> Dollar"
                return true;
            case 2:
                // Code pour gérer la sélection de "Quitter"
                finish(); // Quitter l'application
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}


