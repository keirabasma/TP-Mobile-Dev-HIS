package com.example.calculatrice;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editText;
    private StringBuilder input = new StringBuilder();
    private double operand1 = Double.NaN;
    private double operand2 = Double.NaN;
    private char operator = ' ';

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.EditText01);

        Button button0 = findViewById(R.id.button0);
        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        Button button5 = findViewById(R.id.button5);
        Button button6 = findViewById(R.id.button6);
        Button button7 = findViewById(R.id.button7);
        Button button8 = findViewById(R.id.button8);
        Button button9 = findViewById(R.id.button9);
        Button buttonPlus = findViewById(R.id.buttonPlus);
        Button buttonMoins = findViewById(R.id.buttonMoins);
        Button buttonMultiplier = findViewById(R.id.buttonMultiplier);
        Button buttonDivision = findViewById(R.id.buttonDivision);
        Button buttonPoint = findViewById(R.id.buttonPoint);
        Button buttonC = findViewById(R.id.buttonC);
        Button buttonEgal = findViewById(R.id.buttonEgal);

        button0.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        buttonPlus.setOnClickListener(this);
        buttonMoins.setOnClickListener(this);
        buttonMultiplier.setOnClickListener(this);
        buttonDivision.setOnClickListener(this);
        buttonPoint.setOnClickListener(this);
        buttonC.setOnClickListener(this);
        buttonEgal.setOnClickListener(this);
    }

    public void onClick(View v) {
        if (v.getId() == R.id.button0) {
            input.append("0");
            editText.setText(input.toString());
        } else if (v.getId() == R.id.button1) {
            input.append("1");
            editText.setText(input.toString());
        } else if (v.getId() == R.id.button2) {
            input.append("2");
            editText.setText(input.toString());
        } else if (v.getId() == R.id.button3) {
            input.append("3");
            editText.setText(input.toString());
        } else if (v.getId() == R.id.button4) {
            input.append("4");
            editText.setText(input.toString());
        } else if (v.getId() == R.id.button5) {
            input.append("5");
            editText.setText(input.toString());
        } else if (v.getId() == R.id.button6) {
            input.append("6");
            editText.setText(input.toString());
        } else if (v.getId() == R.id.button7) {
            input.append("7");
            editText.setText(input.toString());
        } else if (v.getId() == R.id.button8) {
            input.append("8");
            editText.setText(input.toString());
        } else if (v.getId() == R.id.button9) {
            input.append("9");
            editText.setText(input.toString());
        } else if (v.getId() == R.id.buttonPoint) {
            if (!input.toString().contains(".")) {
                input.append(".");
                editText.setText(input.toString());
            }
        } else if (v.getId() == R.id.buttonPlus) {
            operand1 = Double.parseDouble(editText.getText().toString());
            operator = '+';
            input.setLength(0);
        } else if (v.getId() == R.id.buttonMoins) {
            operand1 = Double.parseDouble(editText.getText().toString());
            operator = '-';
            input.setLength(0);
        } else if (v.getId() == R.id.buttonMultiplier) {
            operand1 = Double.parseDouble(editText.getText().toString());
            operator = '*';
            input.setLength(0);
        } else if (v.getId() == R.id.buttonDivision) {
            operand1 = Double.parseDouble(editText.getText().toString());
            operator = '/';
            input.setLength(0);
        } else if (v.getId() == R.id.buttonC) {
            input.setLength(0);
            editText.setText("");
            operand1 = Double.NaN;
            operand2 = Double.NaN;
            operator = ' ';
        } else if (v.getId() == R.id.buttonEgal) {
            if (!Double.isNaN(operand1) && !input.toString().isEmpty()) {
                operand2 = Double.parseDouble(editText.getText().toString());
                double result = Operation(operand1, operand2, operator);
                editText.setText(String.valueOf(result));
                input.setLength(0);
                input.append(result);
            }
        }
    }


    private double Operation(double operand1, double operand2, char operator) {
        switch (operator) {
            case '+':
                return operand1 + operand2;
            case '-':
                return operand1 - operand2;
            case '*':
                return operand1 * operand2;
            case '/':
                if (operand2 != 0)
                    return operand1 / operand2;
                else
                    return Double.NaN;
            default:
                return Double.NaN;
        }
    }
}
