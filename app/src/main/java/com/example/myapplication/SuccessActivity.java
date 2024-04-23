package com.example.myapplication;


import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SuccessActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);


        double average = getIntent().getDoubleExtra("EXTRA_AVERAGE", 0);


        TextView textViewSuccessAverage = findViewById(R.id.textViewSuccessAverage);
        textViewSuccessAverage.setText(String.format("Votre Moyenne est: %.2f", average));
        textViewSuccessAverage.setTextColor(Color.WHITE);
    }
}