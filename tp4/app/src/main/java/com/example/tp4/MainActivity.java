package com.example.tp4;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editTextUsername, editTextEmail, editTextPassword;
    Button buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextUsername = findViewById(R.id.editTextText2);
        editTextEmail = findViewById(R.id.editTextTex7);
        editTextPassword = findViewById(R.id.editTextText8);
        buttonLogin = findViewById(R.id.button);

        buttonLogin.setOnClickListener(v -> {
            String username = editTextUsername.getText().toString().trim();
            String email = editTextEmail.getText().toString().trim();
            String password = editTextPassword.getText().toString().trim();

            if (TextUtils.isEmpty(username)) {
                editTextUsername.setError("Veuillez entrer un nom d'utilisateur");
                return;
            }

            if (TextUtils.isEmpty(email)) {
                editTextEmail.setError("Veuillez entrer une adresse email");
                return;
            }

            if (TextUtils.isEmpty(password)) {
                editTextPassword.setError("Veuillez entrer un mot de passe");
                return;
            }

            if (!isValidEmail(email)) {
                editTextEmail.setError("Adresse email non valide");
                return;
            }

            if (password.length() < 6) {
                editTextPassword.setError("Le mot de passe doit contenir au moins 6 caractères");
                return;
            }

            Intent intent = new Intent(MainActivity.this, com.example.tp4.secondactivity.class);
            startActivity(intent);
        });
    }

    private boolean isValidEmail(String email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}
