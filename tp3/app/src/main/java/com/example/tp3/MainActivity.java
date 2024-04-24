package com.example.tp3;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText c1, c2, c3;
    private TextView textRes;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        c1 = findViewById(R.id.editText1);
        c2 = findViewById(R.id.editText2);
        c3 = findViewById(R.id.editText3);
        textRes = findViewById(R.id.textMsg);

        Button calculateButton = findViewById(R.id.button);
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateAverage();
            }
        });
    }

    private void calculateAverage() {
        String inputText1 = c1.getText().toString().trim();
        String inputText2 = c2.getText().toString().trim();
        String inputText3 = c3.getText().toString().trim();
        if ((!inputText1.isEmpty())&&(!inputText2.isEmpty())&&(!inputText3.isEmpty())){
        double note1 = Double.parseDouble(c1.getText().toString());
        double note2 = Double.parseDouble(c2.getText().toString());
        double note3 = Double.parseDouble(c3.getText().toString());

        double average = (note1 + note2 + note3) / 3;

        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        if (average > 10) {
            intent.putExtra("message", "Félicitations! Vous avez réussi. Votre moyenne est : " + average);
        } else {
            intent.putExtra("message", "Vous êtes recalé. Votre moyenne est : " + average);
        }
        startActivity(intent);
        } else {
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            intent.putExtra("message", "champ vide" );
            startActivity(intent);
}
}
}
