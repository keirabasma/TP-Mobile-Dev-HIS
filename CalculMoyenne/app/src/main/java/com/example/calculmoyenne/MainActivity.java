package com.example.calculmoyenne;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText note1;
    private EditText note2;
    private EditText note3;
    private Button calcule;
    private TextView resultat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

   
        note1 = findViewById(R.id.n1);
        note2 = findViewById(R.id.n2);
        note3 = findViewById(R.id.n3);
        calcule = findViewById(R.id.moyenne);
        resultat = findViewById(R.id.resultat1);

        calcule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculer();
            }
        });
    }

    public void calculer() {
        String note1Text = note1.getText().toString();
        String note2Text = note2.getText().toString();
        String note3Text = note3.getText().toString();

        double mynote1 = Double.parseDouble(note1Text);
        double mynote2 = Double.parseDouble(note2Text);
        double mynote3 = Double.parseDouble(note3Text);

        double moyenne = (mynote1 + mynote2 + mynote3) / 3;
        Intent intent = new Intent(MainActivity.this, affichage_resul.class);
        intent.putExtra("result", moyenne);
        startActivity(intent);

    }

        }

