package com.example.Login__Labidi;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


public class MainActivity2 extends AppCompatActivity {

    private TextView textViewWelcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textViewWelcome = findViewById(R.id.textViewWelcome);

        String email = getIntent().getStringExtra("email");
        String username = getIntent().getStringExtra("username");

        String welcomeMessage = "Bonjour " + username + "!\nVotre email est: " + email;
        textViewWelcome.setText(welcomeMessage);
    }
}
