package com.example.converter;

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

    private EditText editTextValue;
    private RadioButton radioButtonEuroToDinar;
    private RadioButton radioButtonDinarToEuro;
    private Button buttonConvert;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextValue = findViewById(R.id.editTextValue);
        radioButtonEuroToDinar = findViewById(R.id.radioButtonEuroToDinar);
        radioButtonDinarToEuro = findViewById(R.id.radioButtonDinarToEuro);
        buttonConvert = findViewById(R.id.buttonConvert);
        textViewResult = findViewById(R.id.textViewResult);
        registerForContextMenu(radioButtonEuroToDinar);
        registerForContextMenu(radioButtonDinarToEuro);

        buttonConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertir();
            }
        });
    }

    private float dinarsToEuro(float valeurDinar) {
        return (float) (valeurDinar * 0.0071);
    }

    private float euroToDinar(float valeurEuro) {
        return (float) (valeurEuro * 140.45);
    }

    private void convertir() {
        String inputText = editTextValue.getText().toString();
        if (inputText.isEmpty()) {
            Toast.makeText(MainActivity.this, "Veuillez entrer une valeur", Toast.LENGTH_SHORT).show();
            return;
        }

        float inputValue = Float.valueOf(inputText);
        float result;

        if (radioButtonEuroToDinar.isChecked()) {
            result = euroToDinar(inputValue);
            textViewResult.setText(String.valueOf(result));
        } else if (radioButtonDinarToEuro.isChecked()) {
            result = dinarsToEuro(inputValue);
            textViewResult.setText(String.valueOf(result));
        } else {
            Toast.makeText(MainActivity.this, "Veuillez sélectionner une direction de conversion", Toast.LENGTH_SHORT).show();
        }
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

        if (id == R.id.menu_conversion_dinar_dollar) {
            return true;
        } else if (id == R.id.menu_quitter) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
