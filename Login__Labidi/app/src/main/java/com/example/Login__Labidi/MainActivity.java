package com.example.Login__Labidi;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.util.Patterns;



public class MainActivity extends AppCompatActivity {

    private EditText editTextEmail, editTextUsername, editTextPassword;
    private Button buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextEmail = findViewById(R.id.editTextEmail);
        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonLogin = findViewById(R.id.buttonLogin);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = editTextEmail.getText().toString().trim();
                String username = editTextUsername.getText().toString().trim();
                String password = editTextPassword.getText().toString().trim();

                if (email.isEmpty() || username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show();
                } else if (!isValidEmail(email)) {
                    Toast.makeText(MainActivity.this, "Format d'email invalide", Toast.LENGTH_SHORT).show();
                } else if (!isPasswordValid(password)) {
                    Toast.makeText(MainActivity.this, "Le mot de passe doit contenir au moins 8 caractères", Toast.LENGTH_SHORT).show();
                } else if (isUserExists(email, username)) {
                    Toast.makeText(MainActivity.this, "L'email ou le nom d'utilisateur existe déjà", Toast.LENGTH_SHORT).show();
                } else {
                    MainActivity3 dbHelper = new MainActivity3(MainActivity.this);
                    dbHelper.insertUser(email, username, password);

                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                    intent.putExtra("email", email);
                    intent.putExtra("username", username);
                    intent.putExtra("password", password);
                    startActivity(intent);
                }
            }
        });
    }

    private boolean isValidEmail(String email) {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private boolean isPasswordValid(String password) {
        return password.length() >= 8;
    }

    private boolean isUserExists(String email, String username) {
        MainActivity3 dbHelper = new MainActivity3(MainActivity.this);
        return dbHelper.isUserExists(email, username);
    }
}
