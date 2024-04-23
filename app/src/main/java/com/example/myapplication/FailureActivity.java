package com.example.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class FailureActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_failure);


        double average = getIntent().getDoubleExtra("EXTRA_AVERAGE", 0);


        TextView textViewFailureAverage = findViewById(R.id.textViewFailureAverage);
        textViewFailureAverage.setText(String.format("Votre Moyenne est: %.2f", average));
        textViewFailureAverage.setTextColor(Color.WHITE);
    }
}