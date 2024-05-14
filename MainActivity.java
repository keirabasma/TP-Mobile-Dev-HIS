package com.example.convertisseur;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText edt;
    private TextView txtResult;
    private Button btnConvert;
    private RadioButton radioButton1, radioButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt = findViewById(R.id.editTextNumber);
        txtResult = findViewById(R.id.textView3);
        btnConvert = findViewById(R.id.button);
        radioButton1 = findViewById(R.id.radioButton);
        radioButton2 = findViewById(R.id.radioButton2);

        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertir();
            }
        });

        // Enregistrer les boutons radios pour les menus contextuels
        registerForContextMenu(radioButton1);
        registerForContextMenu(radioButton2);
    }

    private void convertir() {
        float number = 0;
        try {
            number = Float.valueOf(edt.getText().toString());
        } catch (NumberFormatException e) {
            Toast.makeText(MainActivity.this, "Veuillez entrer un nombre valide.", Toast.LENGTH_SHORT).show();
            return;
        }

        if (edt.getText().toString().isEmpty()) {
            Toast.makeText(MainActivity.this, "Veuillez entrer une valeur à convertir.", Toast.LENGTH_SHORT).show();
            return;
        }

        float result;
        if (radioButton1.isChecked()) {
            // Conversion de l'euro au dinar
            result = euroToDinar(number);
        } else if (radioButton2.isChecked()) {
            // Conversion du dinar à l'euro
            result = dinarsToEuro(number);
        } else {
            Toast.makeText(MainActivity.this, "Veuillez sélectionner un type de conversion.", Toast.LENGTH_SHORT).show();
            return;
        }

        // Affichage du résultat dans le champ de texte "Resultat"
        txtResult.setText(String.valueOf(result));
    }

    private float dinarsToEuro(float valeurDinar) {
        return (float) (valeurDinar * 0.0071);
    }

    private float euroToDinar(float valeurEuro) {
        return (float) (valeurEuro * 140.45);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.menu_dinar_to_euro) {
            Toast.makeText(MainActivity.this, "Taux de conversion Dinar -> Euro : 0.0071", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.menu_euro_to_dinar) {
            Toast.makeText(MainActivity.this, "Taux de conversion Euro -> Dinar : 140.45", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(android.view.MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.menu_conversion_dinar_to_dollar) {
            // Lancer la nouvelle activité pour la conversion de dinar vers dollar
            startActivity(new Intent(MainActivity.this, ConversionDinarDollarActivity.class));
            return true;
        } else if (id == R.id.menu_quitter) {
            // Code pour quitter l'application
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

