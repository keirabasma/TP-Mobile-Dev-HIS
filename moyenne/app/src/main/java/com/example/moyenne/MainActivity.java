package com.example.moyenne;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;


import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText note1EditText, note2EditText, note3EditText;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        note1EditText = findViewById(R.id.note1EditText);
        note2EditText = findViewById(R.id.note2EditText);
        note3EditText = findViewById(R.id.note3EditText);


        Button calculateButton = findViewById(R.id.calculateButton);
        calculateButton.setOnClickListener(v -> calculatemoyen());
    }

    private void calculatemoyen() {
        String t1=note1EditText.getText().toString().trim();
        String t2=note2EditText.getText().toString().trim();
        String t3=note3EditText.getText().toString().trim();
        if ((!t1.isEmpty())&&((!t2.isEmpty()))&&((!t3.isEmpty()))){
        double note1 = Double.parseDouble(note1EditText.getText().toString());
        double note2 = Double.parseDouble(note2EditText.getText().toString());
        double note3 = Double.parseDouble(note3EditText.getText().toString());
            if (note1 >= 0 && note1 <= 20 && note2 >= 0 && note2 <= 20 && note3 >= 0 && note3 <= 20) {
                double moyen = (note1 + note2 + note3) / 3;

                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                if (moyen > 10) {
                    intent.putExtra("message", "Félicitations! Vous avez réussi. Votre moyenne est : " + moyen);
                } else {
                    intent.putExtra("message", "Vous êtes recalé. Votre moyenne est : " + moyen);
                }
                startActivity(intent);
            }else {
                Intent intent=new Intent(MainActivity.this,MainActivity2.class);
                intent.putExtra("message","Les notes doivent etre entre 0 est 20");
                startActivity(intent);
            }
    }else {
            Intent intent=new Intent(MainActivity.this,MainActivity2.class);
            intent.putExtra("message","Les champs sont vide !! Veuillez remplire tous les champs !!!!!!!");
            startActivity(intent);
        }
    }
}
