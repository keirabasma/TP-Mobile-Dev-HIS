package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextValue1, editTextValue2, editTextValue3;
    private Button buttonCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextValue1 = findViewById(R.id.editTextValue1);
        editTextValue2 = findViewById(R.id.editTextValue2);
        editTextValue3 = findViewById(R.id.editTextValue3);
        buttonCalculate = findViewById(R.id.buttonCalculate);

        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateAverage();
            }
        });
    }

    private void calculateAverage() {
        String strValue1 = editTextValue1.getText().toString();
        String strValue2 = editTextValue2.getText().toString();
        String strValue3 = editTextValue3.getText().toString();

        if (strValue1.isEmpty() || strValue2.isEmpty() || strValue3.isEmpty()) {
            Toast.makeText(MainActivity.this, "Tous les champs doivent être remplis.", Toast.LENGTH_LONG).show();
            return;
        }

        double value1 = Double.parseDouble(strValue1);
        double value2 = Double.parseDouble(strValue2);
        double value3 = Double.parseDouble(strValue3);

        double average = (value1 + value2 + value3) / 3;

        if (average > 10) {
            Intent successIntent = new Intent(MainActivity.this, SuccessActivity.class);
            successIntent.putExtra("EXTRA_AVERAGE", average);
            startActivity(successIntent);
        } else {
            Intent failureIntent = new Intent(MainActivity.this, FailureActivity.class);
            failureIntent.putExtra("EXTRA_AVERAGE", average);
            startActivity(failureIntent);
        }
    }
}
