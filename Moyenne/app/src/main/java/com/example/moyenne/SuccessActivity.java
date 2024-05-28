package com.example.moyenne;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SuccessActivity extends AppCompatActivity {

    TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);

        resultTextView = findViewById(R.id.resultTextView);

        double moyenne = getIntent().getDoubleExtra("moyenne", 0);
        resultTextView.setText("Moyenne: " + moyenne);
    }
}
