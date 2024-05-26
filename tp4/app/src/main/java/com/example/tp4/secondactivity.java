package com.example.tp4;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class secondactivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        String username = getIntent().getStringExtra("username");
        String email = getIntent().getStringExtra("email");

        TextView textViewUsername = findViewById(R.id.editTextText2);
        TextView textViewEmail = findViewById(R.id.editTextTex7);

        textViewUsername.setText("Bienvenue, " + username + " !");
        textViewEmail.setText("Votre email : " + email);
    }
}
