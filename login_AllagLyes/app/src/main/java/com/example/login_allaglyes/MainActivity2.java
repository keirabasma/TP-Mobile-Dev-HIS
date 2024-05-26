package com.example.login_allaglyes;

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
        String password = getIntent().getStringExtra("password");

        String welcomeMessage = "hello " + username + "!\nEmail: " + email;
        textViewWelcome.setText(welcomeMessage);
    }
}
