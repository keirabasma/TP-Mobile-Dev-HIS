package com.example.moyenne;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class FailureActivity extends AppCompatActivity {

    TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_failure);

        resultTextView = findViewById(R.id.resultTextView);

        double moyenne = getIntent().getDoubleExtra("moyenne", 0);
        resultTextView.setText("Moyenne: " + moyenne);
    }
}
