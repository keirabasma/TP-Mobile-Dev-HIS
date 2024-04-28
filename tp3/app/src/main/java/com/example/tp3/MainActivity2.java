package com.example.tp3;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView testRes = findViewById(R.id.textMsg);
        String message = getIntent().getStringExtra("message");
        testRes.setText(message);
}
}