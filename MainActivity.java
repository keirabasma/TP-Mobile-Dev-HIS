package com.example.moyenne;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    private EditText note1;
    private EditText note2;
    private EditText note3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        note1 = findViewById(R.id.note1);
        note2 = findViewById(R.id.note2);
        note3 = findViewById(R.id.note3);

        findViewById(R.id.btncalculer).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateAverage();
            }
        });
    }

    private void calculateAverage() {
        String value1 = note1.getText().toString();
        String value2 = note2.getText().toString();
        String value3 = note3.getText().toString();

        if (value1.isEmpty() || value2.isEmpty() || value3.isEmpty()) {
            Toast.makeText(this, "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!isNumeric(value1) || !isNumeric(value2) || !isNumeric(value3)) {
            Toast.makeText(this, "Veuillez saisir uniquement des chiffres", Toast.LENGTH_SHORT).show();
            return;
        }

        float average = (Float.parseFloat(value1) + Float.parseFloat(value2) + Float.parseFloat(value3)) / 3;

        if (average > 10) {
            showSuccessInterface(average);
        } else {
            showFailureInterface(average);
        }
    }

    private void showSuccessInterface(float average) {
        setContentView(R.layout.activity_reussite);
        TextView resultTextView = findViewById(R.id.moy);
        resultTextView.setText("Moyenne : " + average);
        resultTextView.setTextColor(Color.parseColor("#00ff00"));

    }

    private void showFailureInterface(float average) {
        setContentView(R.layout.activity_echoe);
        TextView resultTextView = findViewById(R.id.avg);
        resultTextView.setText("Moyenne : " + average);
        resultTextView.setTextColor(Color.parseColor("##ffffff"));

    }
    private boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }
}