package com.example.moyenne;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText value1, value2, value3;
    Button calculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        value1 = findViewById(R.id.value1);
        value2 = findViewById(R.id.value2);
        value3 = findViewById(R.id.value3);
        calculateButton = findViewById(R.id.calculateButton);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateAverage();
            }
        });
    }

    private void calculateAverage() {
        if (value1.getText().toString().isEmpty() || value2.getText().toString().isEmpty() || value3.getText().toString().isEmpty()) {
            Toast.makeText(MainActivity.this, "Tous les champs doivent être remplis", Toast.LENGTH_SHORT).show();
        } else {
            double val1 = Double.parseDouble(value1.getText().toString());
            double val2 = Double.parseDouble(value2.getText().toString());
            double val3 = Double.parseDouble(value3.getText().toString());
            double average = (val1 + val2 + val3) / 3;

            Intent intent;
            if (average > 10) {
                intent = new Intent(MainActivity.this, SuccessActivity.class);
                intent.putExtra("moyenne", average);
            } else {
                intent = new Intent(MainActivity.this, FailureActivity.class);
                intent.putExtra("moyenne", average);
            }
            startActivity(intent);
        }
    }
}
