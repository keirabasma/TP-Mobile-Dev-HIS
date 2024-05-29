package com.example.moyenne;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText editText1 = findViewById(R.id.EditText1);
        EditText editText2 = findViewById(R.id.EditText2);
        EditText editText3 = findViewById(R.id.EditText3);
        Button button = findViewById(R.id.button);

        button.setOnClickListener(v -> {
            try {
                float number1 = Float.parseFloat(editText1.getText().toString());
                float number2 = Float.parseFloat(editText2.getText().toString());
                float number3 = Float.parseFloat(editText3.getText().toString());

                float average = (number1 + number2 + number3) / 3;

                if (average < 10) {
                    Intent intent = new Intent(MainActivity.this, MainActivity3.class);
                    intent.putExtra("average", average);
                    startActivity(intent);
                } else if (average >= 10) {
                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                    intent.putExtra("average", average);
                    startActivity(intent);
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
                Toast.makeText(MainActivity.this, "Please enter valid numbers", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
