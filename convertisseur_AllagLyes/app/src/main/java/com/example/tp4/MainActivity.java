package com.example.tp4;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ContextMenu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AlertDialog;
import android.view.MenuInflater;


public class MainActivity extends AppCompatActivity {

    private EditText editTextPhone;
    private RadioGroup radioGroup;
    private RadioButton radioButtonDinarToEuro;
    private RadioButton radioButtonEuroToDinar;
    private Button buttonConvertir;
    private TextView textViewResultat;

    private static final float TAUX_DINAR_VERS_EURO = 0.0071f;
    private static final float TAUX_EURO_VERS_DINAR = 140.45f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextPhone = findViewById(R.id.editTextPhone);
        radioGroup = findViewById(R.id.radioGroup);
        radioButtonDinarToEuro = findViewById(R.id.radioButton);
        radioButtonEuroToDinar = findViewById(R.id.radioButton2);
        buttonConvertir = findViewById(R.id.button);
        textViewResultat = findViewById(R.id.textView2);

        buttonConvertir.setOnClickListener(view -> convertir());

        registerForContextMenu(radioButtonDinarToEuro);
        registerForContextMenu(radioButtonEuroToDinar);
    }

    private void convertir() {
        String input = editTextPhone.getText().toString();
        if (!input.isEmpty()) {
            float number = Float.parseFloat(input);

            if (radioButtonDinarToEuro.isChecked()) {

                float resultat = dinarsToEuro(number);
                textViewResultat.setText(String.format("Resultat: %.2f EUR", resultat));
            } else if (radioButtonEuroToDinar.isChecked()) {
                float resultat = euroToDinar(number);
                textViewResultat.setText(String.format("Resultat: %.2f DZD", resultat));
            }
        } else {
            new AlertDialog.Builder(this)
                    .setTitle("erreur")
                    .setMessage("veuillez entrer une valeur à convertir")
                    .setPositiveButton("ok", (dialog, which) -> dialog.dismiss())
                    .create()
                    .show();
        }
    }

    private float dinarsToEuro(float valeurDinar) {
        return valeurDinar * TAUX_DINAR_VERS_EURO;
    }

    private float euroToDinar(float valeurEuro) {
        return valeurEuro * TAUX_EURO_VERS_DINAR;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Menu de Taux de Conversion");

        if (v.getId() == R.id.radioButton) {
            menu.add(0, 1, 0, "Taux dinar -> euro");
        } else if (v.getId() == R.id.radioButton2) {
            menu.add(0, 2, 0, "Taux euro -> dinar");
        }
    }


    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 1:
                Toast.makeText(this, "Taux Dinar -> Euro : " + TAUX_DINAR_VERS_EURO, Toast.LENGTH_LONG).show();
                return true;
            case 2:
                Toast.makeText(this, "Taux Euro -> Dinar : " + TAUX_EURO_VERS_DINAR, Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.quitter) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}