package com.example.convertisseur;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private RadioButton radioDinarToEuro;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        radioDinarToEuro = findViewById(R.id.radioDinarToEuro);
        RadioButton radioEuroToDinar = findViewById(R.id.radioEuroToDinar);
        textViewResult = findViewById(R.id.textViewResult);
        Button buttonConvert = findViewById(R.id.buttonConvert);

        buttonConvert.setOnClickListener(v -> convertir());

        // Enregistrer une vue pour un menu contextuel
        registerForContextMenu(buttonConvert);
    }

    private void convertir() {
        String valeurStr = editText.getText().toString();
        if (valeurStr.isEmpty()) {
            Toast.makeText(this, getString(R.string.entrez_une_valeur), Toast.LENGTH_SHORT).show();
            return;
        }

        float valeur = Float.parseFloat(valeurStr);
        float resultat;

        if (radioDinarToEuro.isChecked()) {
            resultat = dinarsToEuro(valeur);
        } else {
            resultat = euroToDinar(valeur);
        }

        textViewResult.setText(String.valueOf(resultat));
    }

    private float dinarsToEuro(float valeurDinar) {
        return valeurDinar * 0.0071f;
    }

    private float euroToDinar(float valeurEuro) {
        return valeurEuro * 140.45f;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.conversion_dinar_dollar) {
            // Code pour la conversion dinar <-> dollar (placeholder pour l'instant)
            Toast.makeText(this, getString(R.string.fonctionnalite_avenir), Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.quitter) {
            finish();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.taux_dinar_euro) {
            Toast.makeText(this, getString(R.string.taux_dinar_euro_toast), Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.taux_euro_dinar) {
            Toast.makeText(this, getString(R.string.taux_euro_dinar_toast), Toast.LENGTH_SHORT).show();
            return true;
        } else {
            return super.onContextItemSelected(item);
        }
    }

}