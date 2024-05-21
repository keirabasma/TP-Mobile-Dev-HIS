package com.example.login_baghdadi_aimen_nadjib;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private EditText email;
    private EditText username;
    private EditText password;
    private Button login;
    private Database database;

    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +
                    "(?=.*[0-9])" +
                    "(?=.*[a-z])" +
                    "(?=.*[A-Z])" +
                    "(?=.*[@#$%^&+=])" +
                    "(?=\\S+$)" +
                    ".{8,}" +
                    "$");

    private static final Pattern USERNAME_PATTERN =
            Pattern.compile("^[a-zA-Z0-9]+$");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.email);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login_button);

        database = new Database(this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleLogin(v);

            }
        });
    }

    private void handleLogin(View view) {
        String emailr = email.getText().toString().trim();
        String usernamer = username.getText().toString().trim();
        String passwordr = password.getText().toString().trim();

        if (!isValidEmail(emailr)) {
            showAlertDialog("Erreur", "Veuillez entrer une addresse Gmail valide.");
            return;
        }

        if (!isValidUsername(usernamer)) {
            showAlertDialog("Erreur", "Le nom d'utilisateur doit contenir uniquement des lettres et des chiffres.");
            return;
        }

        if (!isValidPassword(passwordr)) {
            showAlertDialog("Erreur", "Le mot de passe doit contenir au moins 8 caractères, un chiffre, une lettre majuscule, une lettre minuscule et un caractère spécial.");
            return;
        }

        // Si tous les champs sont valides, ajouter l'utilisateur à la base de données
        if (database.isEmailExists(emailr)) {
            showAlertDialog("Erreur", "Cet email est déjà enregistré.");
        } else {
            boolean isAdded = database.addUser(usernamer, emailr, passwordr);
            if (isAdded) {
                Snackbar.make(view, "Utilisateur ajouté avec succès!", Snackbar.LENGTH_LONG).show();
                // Rediriger vers la page d'accueil
                Intent intent = new Intent(MainActivity.this, HomePageActivity.class);
                startActivity(intent);
            } else {
                showAlertDialog("Erreur", "Échec de l'ajout de l'utilisateur.");
            }
        }
    }

    private boolean isValidEmail(String email) {
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches() && email.endsWith("@gmail.com");
    }

    private boolean isValidUsername(String username) {
        return !TextUtils.isEmpty(username) && USERNAME_PATTERN.matcher(username).matches();
    }

    private boolean isValidPassword(String password) {
        return PASSWORD_PATTERN.matcher(password).matches();
    }

    private void showAlertDialog(String title, String message) {
        new AlertDialog.Builder(this)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton("OK", (dialog, which) -> dialog.dismiss())
                .create()
                .show();
    }
}
