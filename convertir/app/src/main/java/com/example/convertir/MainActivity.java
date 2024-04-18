package com.example.convertir;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextPhone;
    private RadioButton Dinar_Euro;
    private RadioButton Euro_Dinar;
    private RadioButton Dinar_Dollar;
    private RadioButton Dollar_Dinar;
    private TextView textViewResultat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextPhone = findViewById(R.id.editTextNumber);
        Dinar_Euro = findViewById(R.id.radioButton2);
        Euro_Dinar = findViewById(R.id.radioButton3);
        Dinar_Dollar = findViewById(R.id.radioButton4);
        Dollar_Dinar = findViewById(R.id.radioButton5);
        Button Convertir = findViewById(R.id.button);
        textViewResultat = findViewById(R.id.textView2);

       Convertir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertir();
            }
        });
        registerForContextMenu(Dinar_Euro);
        registerForContextMenu(Euro_Dinar);
    }
    private void convertir() {
        Intent intent = new Intent(MainActivity.this, resu.class);

        String input = editTextPhone.getText().toString();
        if (!input.isEmpty()) {
            float number = Float.parseFloat(input);
            if (Dinar_Euro.isChecked()) {
                float resultat = dinarsToEuro(number);
                textViewResultat.setText(String.format("Resultat:"+resultat+"EUR"));
            } else if (Euro_Dinar.isChecked()) {
                float resultat = euroToDinar(number);
                textViewResultat.setText(String.format("Resultat: "+resultat+"DZD", resultat));
            }else if (Dinar_Dollar.isChecked()) {
                float resultat = dinarsToDollar(number);
                intent.putExtra("message","Resultat" + resultat );
            } else if (Dollar_Dinar.isChecked()) {
                float resultat = DollarToDinar(number);
                intent.putExtra("message","Resultat" + resultat );
            }
        } else {
            new AlertDialog.Builder(this)
                    .setTitle("erreur")
                    .setMessage("veuillez entrer une valeur à convertir")
                    .setPositiveButton("ok", (dialog, which) -> dialog.dismiss())
                    .create()
                    .show();
        }
        startActivity(intent);

    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        if (v.getId() == R.id.radioButton2 || v.getId() == R.id.button||v.getId()==R.id.radioButton3){
            getMenuInflater().inflate(R.menu.context_menu, menu);
        }
    }
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.taux_dinar_euro) {
            Toast.makeText(this, "Taux dinar → euro : 1 DZD = 0.0071 EUR", Toast.LENGTH_SHORT).show();
            return true;
        } else if (item.getItemId() == R.id.taux_euro_dinar) {
            Toast.makeText(this, "Taux euro → dinar : 1 EUR = 140.45 DZD", Toast.LENGTH_SHORT).show();
            return true;
        } else {
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
    private float dinarsToEuro(float valeurDinar) {
        return valeurDinar * 0.0071f;
    }
    private float euroToDinar(float valeurEuro) {
        return valeurEuro * 140.45f;
    }
    private float dinarsToDollar(float valeurDinar) {
        return valeurDinar * 0.0071f;
    }
    private float DollarToDinar(float valeurDollar) {
        return valeurDollar * 140.45f;
    }
}
