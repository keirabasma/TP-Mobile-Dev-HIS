package com.example.login;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText email;
    private EditText username;
    private EditText password;
    private Button loginButton;
    private monDB dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.email);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        loginButton = findViewById(R.id.loginB);
        dbHelper = new monDB(this);


        dbHelper.insertUser("omar@gmail.com", "omar", "yes@");
        dbHelper.insertUser("nani@hotmail.fr", "na_", "pass2024");
        dbHelper.insertUser("bzaki@gmail.com", "zaki", "z1970");
        dbHelper.insertUser("xavi@yahoo.com", "alonso", "123000");
        dbHelper.insertUser("man@gmail.com", "man00", "012345678");

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailText = email.getText().toString();
                String usernameText = username.getText().toString();
                String passwordText = password.getText().toString();
                loginUser(emailText, usernameText, passwordText);
            }
        });
    }

    private void loginUser(String email, String username, String password) {
        Cursor cursor = dbHelper.checkUserCredentials(email, username, password);
        if (cursor != null && cursor.getCount() > 0) {
            cursor.close();
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            startActivity(intent);
        } else {
            Toast.makeText(MainActivity.this, "Login Failed, please enter valid inormation!!", Toast.LENGTH_SHORT).show();
        }
    }
}
