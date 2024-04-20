package com.example.moyenne;


import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView resultTextView = findViewById(R.id.textView);
        String message = getIntent().getStringExtra("message");
        resultTextView.setText(message);
    }
}