package com.example.moyenne;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText editTextPhone1;
    private TextView editTextPhone2;
    private TextView editTextPhone3;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextPhone1 = findViewById(R.id.editTextPhone1);
        editTextPhone2 = findViewById(R.id.editTextPhone2);
        editTextPhone3 = findViewById(R.id.editTextPhone3);

        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateMoy();
            }
        });
    }

    private void calculateMoy() {
        String inputText1 = editTextPhone1.getText().toString().trim();
        String inputText2 = editTextPhone2.getText().toString().trim();
        String inputText3 = editTextPhone3.getText().toString().trim();

        if ((!inputText1.isEmpty())&&(!inputText2.isEmpty())&&(!inputText3.isEmpty())) {


            double operand1 = Double.parseDouble(inputText1);
            double operand2 = Double.parseDouble(inputText2);
            double operand3 = Double.parseDouble(inputText3);
            double moy = (operand1 + operand2 + operand3) / 3;

            Intent intent = new Intent(MainActivity.this, com.example.moyenne.MainActivity2.class);
            if (moy > 10) {
                intent.putExtra("message", "Félicitations! Vous avez réussi. Votre moyenne est : " + moy);
            } else {
                intent.putExtra("message", "Vous êtes recalé. Votre moyenne est : " + moy);
            }
            startActivity(intent);

        } else {
            Intent intent = new Intent(MainActivity.this, com.example.moyenne.MainActivity2.class);
            intent.putExtra("message", "!!!!! No input provided !!!!!" );
            startActivity(intent);
        }
    }
}