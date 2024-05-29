package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText display;
    private EditText resultEditText;
    private Button btnClear, btnEqual, btnPlus, btnMinus, btnMultiply, btnDivide;
    private Button[] numberButtons = new Button[10];
    private String input = "";
    private double num1, num2;
    private char operator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.display);
        resultEditText = findViewById(R.id.editText);
        btnClear = findViewById(R.id.btn_clear);
        btnEqual = findViewById(R.id.btn_equal);
        btnPlus = findViewById(R.id.btn_add);
        btnMinus = findViewById(R.id.btn_subtract);
        btnMultiply = findViewById(R.id.btn_multiply);
        btnDivide = findViewById(R.id.button99);

        for (int i = 0; i < numberButtons.length; i++) {
            String buttonID = "btn_" + i;
            int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
            numberButtons[i] = findViewById(resID);
        }

        for (Button button : numberButtons) {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    input += button.getText().toString();
                    display.setText(input);
                }
            });
        }

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input = "";
                display.setText(input);
            }
        });

        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate();
            }
        });

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operator = '+';
                num1 = Double.parseDouble(input);
                input = "";
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operator = '-';
                num1 = Double.parseDouble(input);
                input = "";
            }
        });

        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operator = '*';
                num1 = Double.parseDouble(input);
                input = "";
            }
        });

        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operator = '/';
                num1 = Double.parseDouble(input);
                input = "";
            }
        });
    }

    private void calculate() {
        num2 = Double.parseDouble(input);
        double result = 0;

        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    display.setText("Error");
                    return;
                }
                break;
        }

        // Mettre à jour le texte de l'EditText avec le résultat
        resultEditText.setText(String.valueOf(result));
    }

    Intent intent = new Intent(MainActivity.this, OtherActivity.class);
}
