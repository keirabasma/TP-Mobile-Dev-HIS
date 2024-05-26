package com.example.abdelkaderkheddaouiabdelhaktp5;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.JsonObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class SignUpActivity extends AppCompatActivity {
    private EditText emailEditText, passwordEditText;
    private Button signUpButton;
    private OkHttpClient client;

    private static final String SUPABASE_URL = "https://vxknkuydhpevpjshpina.supabase.co";
    private static final String SUPABASE_KEY = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6InZ4a25rdXlkaHBldnBqc2hwaW5hIiwicm9sZSI6ImFub24iLCJpYXQiOjE3MTY3MTk4MTksImV4cCI6MjAzMjI5NTgxOX0.MA2JpzK8Jo6bNYn1BE0oSgtOgIwFti4ZKM7ZY5DBJvw";
    private static final String TAG = "SignUpActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        signUpButton = findViewById(R.id.signUpButton);
        client = new OkHttpClient();

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUp();
            }
        });
    }

    private void signUp() {
        String email = emailEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();

        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("email", email);
        jsonObject.addProperty("password", password);

        RequestBody body = RequestBody.create(jsonObject.toString(), MediaType.get("application/json; charset=utf-8"));

        Request request = new Request.Builder()
                .url(SUPABASE_URL + "/auth/v1/signup")
                .header("apikey", SUPABASE_KEY)
                .header("Content-Type", "application/json")
                .post(body)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e(TAG, "Network Error: " + e.getMessage(), e);
                runOnUiThread(() -> Toast.makeText(SignUpActivity.this, "Signup failed: " + e.getMessage(), Toast.LENGTH_SHORT).show());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    // User created in Supabase auth, now add user to the users table
                    addUserToTable(email, password);
                } else {
                    String responseBody = response.body().string();
                    Log.e(TAG, "Signup failed: " + responseBody);
                    runOnUiThread(() -> Toast.makeText(SignUpActivity.this, "Signup failed: " + responseBody, Toast.LENGTH_SHORT).show());
                }
            }
        });
    }

    private void addUserToTable(String email, String password) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("email", email);
        jsonObject.addProperty("password", password);

        RequestBody body = RequestBody.create(jsonObject.toString(), MediaType.get("application/json; charset=utf-8"));

        Request request = new Request.Builder()
                .url(SUPABASE_URL + "/rest/v1/users")
                .header("apikey", SUPABASE_KEY)
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + SUPABASE_KEY)
                .post(body)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e(TAG, "Network Error: " + e.getMessage(), e);
                runOnUiThread(() -> Toast.makeText(SignUpActivity.this, "Failed to add user to table: " + e.getMessage(), Toast.LENGTH_SHORT).show());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    runOnUiThread(() -> {
                        Toast.makeText(SignUpActivity.this, "Signup successful", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(SignUpActivity.this, SignInActivity.class);
                        startActivity(intent);
                        finish();
                    });
                } else {
                    String responseBody = response.body().string();
                    Log.e(TAG, "Failed to add user to table: " + responseBody);
                    runOnUiThread(() -> Toast.makeText(SignUpActivity.this, "Failed to add user to table: " + responseBody, Toast.LENGTH_SHORT).show());
                }
            }
        });
    }
}
