package com.example.login;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.database.Cursor;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {

    private EditText usernameEditText, emailEditText, passwordEditText;
            private Button loginButton;
            private DatabaseHelper db;

            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);

                // Initialiser les vues
                usernameEditText = findViewById(R.id.username);
                emailEditText = findViewById(R.id.email);
                passwordEditText = findViewById(R.id.password);
                loginButton = findViewById(R.id.login);

                // Initialiser la base de données
                db = new DatabaseHelper(this);

                // Ajouter un écouteur au bouton de connexion
                loginButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String username = usernameEditText.getText().toString();
                        String email = emailEditText.getText().toString();
                        String password = passwordEditText.getText().toString();

                        // Vérifier les informations de l'utilisateur
                        Cursor cursor = db.getUser(email, password);
                        if (cursor != null && cursor.moveToFirst() && cursor.getString(1).equals(username)) {
                            // Informations correctes, ouvrir une nouvelle activité
                            Intent intent = new Intent(MainActivity.this, NewActivity.class);
                            startActivity(intent);
                        } else {
                            // Informations incorrectes, afficher un message d'erreur
                            Toast.makeText(MainActivity.this, "Invalid credentials", Toast.LENGTH_SHORT).show();
                        }
                        if (cursor != null) {
                            cursor.close();
                        }
                    }
                });
            }
        }



