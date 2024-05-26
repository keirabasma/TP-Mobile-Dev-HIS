package com.example.abdelkaderkheddaouiabdelhaktp5;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class SignInActivity extends AppCompatActivity {
    private EditText emailEditText, passwordEditText;
    private Button signInButton;
    private OkHttpClient client;

    private static final String SUPABASE_URL = "https://vxknkuydhpevpjshpina.supabase.co";
    private static final String SUPABASE_KEY = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6InZ4a25rdXlkaHBldnBqc2hwaW5hIiwicm9sZSI6ImFub24iLCJpYXQiOjE3MTY3MTk4MTksImV4cCI6MjAzMjI5NTgxOX0.MA2JpzK8Jo6bNYn1BE0oSgtOgIwFti4ZKM7ZY5DBJvw";
    private static final String TAG = "SignInActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        signInButton = findViewById(R.id.signInButton);
        client = new OkHttpClient();

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();
            }
        });
    }

    private void signIn() {
        String email = emailEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();

        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        Request request = new Request.Builder()
                .url(SUPABASE_URL + "/rest/v1/users?email=eq." + email + "&select=password")
                .header("apikey", SUPABASE_KEY)
                .header("Authorization", "Bearer " + SUPABASE_KEY)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e(TAG, "Network Error: " + e.getMessage(), e);
                runOnUiThread(() -> Toast.makeText(SignInActivity.this, "Signin failed: " + e.getMessage(), Toast.LENGTH_SHORT).show());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    String responseBody = response.body().string();
                    JsonArray jsonArray = JsonParser.parseString(responseBody).getAsJsonArray();
                    if (jsonArray.size() > 0) {
                        JsonObject jsonObject = jsonArray.get(0).getAsJsonObject();
                        String storedPassword = jsonObject.get("password").getAsString();
                        if (storedPassword.equals(password)) {
                            runOnUiThread(() -> {
                                Toast.makeText(SignInActivity.this, "Signin successful", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(SignInActivity.this, BlankActivity.class);
                                startActivity(intent);
                                finish();
                            });
                        } else {
                            runOnUiThread(() -> Toast.makeText(SignInActivity.this, "Signin failed: Invalid password", Toast.LENGTH_SHORT).show());
                        }
                    } else {
                        runOnUiThread(() -> Toast.makeText(SignInActivity.this, "Signin failed: User not found", Toast.LENGTH_SHORT).show());
                    }
                } else {
                    String responseBody = response.body().string();
                    Log.e(TAG, "Signin failed: " + responseBody);
                    runOnUiThread(() -> Toast.makeText(SignInActivity.this, "Signin failed: " + responseBody, Toast.LENGTH_SHORT).show());
                }
            }
        });
    }
}
