package com.Karim.convertisseur;


import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;

import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    private RadioButton dinar_euro;
    private RadioGroup radioGroup;
    private RadioButton euro_dinar;
    private Button convertirbtn;
    private TextView result;
    private TextView titreapp;
    private EditText editTextNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result=findViewById(R.id.result);
        editTextNumber=findViewById(R.id.editTextNumber);
        titreapp=findViewById(R.id.titreapp);

        convertirbtn=findViewById(R.id.convertir);

        radioGroup=findViewById(R.id.radiogrp);
        euro_dinar=findViewById(R.id.radioeuro);
        dinar_euro=findViewById(R.id.radiodinar);

        registerForContextMenu(dinar_euro);
        registerForContextMenu(convertirbtn);

        convertirbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editTextNumber.getText().toString().isEmpty()){
                    showAlert();
                }else{
                    Convertir();
                }
            }
        });
    }



    private void Convertir(){
        float valeur=Float.valueOf(editTextNumber.getText().toString());
        float resultat;

        if (dinar_euro.isChecked()){
            resultat=eurotodinar(valeur);
            result.setText(String.valueOf(resultat));

        }else if(euro_dinar.isChecked()) {
            resultat=dinartoeuro(valeur);
            result.setText(String.valueOf(resultat));
        }
    }

    private void showAlert(){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setMessage("Veuiller entrer une valeur avent de convertir.").setTitle("champ vide").setPositiveButton("OK",null);
        AlertDialog dialog=builder.create();
        dialog.show();
    }

    private float dinartoeuro(float valeurdinar){
        return (float)(valeurdinar *140.45);
    }

    private float eurotodinar(float valeureuro){
        return (float)(valeureuro *0.0071);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        if (v.getId() == R.id.radiodinar || v.getId() == R.id.convertir||v.getId()==R.id.radioeuro){
            getMenuInflater().inflate(R.menu.conversion_menu, menu);
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menu_dinar_to_euro) {
            Toast.makeText(this, "Taux dinar → euro : 1 DZD = 0.0071 EUR", Toast.LENGTH_SHORT).show();
            return true;
        } else if (item.getItemId() == R.id.menu_euro_to_dinar) {
            Toast.makeText(this, "Taux euro → dinar : 1 EUR = 140.45 DZD", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            return super.onContextItemSelected(item);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_quit) {
            finish();
            return true;
        }
            return super.onOptionsItemSelected(item);

    }

}
