package com.example.convertir;



import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class resu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_res);

        TextView resultTextView = findViewById(R.id.textView);
        String message = getIntent().getStringExtra("message");
        resultTextView.setText(message);
    }
}