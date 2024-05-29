package com.example.calculmoyenne;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class affichage_resul extends AppCompatActivity {
    private TextView resu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_affichage_resul);


        resu = findViewById(R.id.resultat2);


        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            double result = extras.getDouble("result");
            resu.setText("Moyenne: " + result);
        }
    }
}
