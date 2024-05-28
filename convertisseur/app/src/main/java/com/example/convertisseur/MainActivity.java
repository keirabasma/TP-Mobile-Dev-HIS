package com.example.convertisseur;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Enregistrer les boutons radios pour le menu contextuel
        RadioButton rbDinarToEuro = findViewById(R.id.rb_dinar_to_euro);
        RadioButton rbEuroToDinar = findViewById(R.id.rb_euro_to_dinar);
        registerForContextMenu(rbDinarToEuro);
        registerForContextMenu(rbEuroToDinar);
    }

    public void convertir(View view) {
        EditText edt = findViewById(R.id.edit_float);
        String entree = edt.getText().toString();

        if (entree.isEmpty()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Erreur")
                    .setMessage("Veuillez saisir une valeur.")
                    .setPositiveButton("OK", null)
                    .show();
        } else {
            float nombre = Float.parseFloat(entree);

            RadioButton rbDinarToEuro = findViewById(R.id.rb_dinar_to_euro);
            RadioButton rbEuroToDinar = findViewById(R.id.rb_euro_to_dinar);

            if (rbDinarToEuro.isChecked()) {
                float resultat = dinarToEuro(nombre);
                TextView tvResultat = findViewById(R.id.tv_resultat);
                tvResultat.setText(String.valueOf(resultat));
            } else if (rbEuroToDinar.isChecked()) {
                float resultat = euroToDinar(nombre);
                TextView tvResultat = findViewById(R.id.tv_resultat);
                tvResultat.setText(String.valueOf(resultat));
            }
        }
    }

    private float dinarToEuro(float valeurDinar) {
        return valeurDinar * 0.0071f;
    }

    private float euroToDinar(float valeurEuro) {
        return valeurEuro * 140.45f;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        if (v.getId() == R.id.rb_dinar_to_euro || v.getId() == R.id.rb_euro_to_dinar) {
            menu.add(0, 0, 0, "Taux dinar -> euro");
            menu.add(0, 1, 1, "Taux euro -> dinar");
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == 0) {
            Toast.makeText(this, "Taux de conversion : 1 dinar = 0.0071 euro", Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == 1) {
            Toast.makeText(this, "Taux de conversion : 1 euro = 140.45 dinars", Toast.LENGTH_SHORT).show();
        }
        return super.onContextItemSelected(item);
    }


}