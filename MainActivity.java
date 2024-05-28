package com.example.clacul_tp1;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView resultTV, solutionTV;
    String operand = "";
    double num1 = 0, num2 = 0;
    char operator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultTV = findViewById(R.id.result_tv);
        solutionTV = findViewById(R.id.solution_tv);

        // Assign onClick listener to buttons
        findViewById(R.id.AC).setOnClickListener(this);
        findViewById(R.id.c).setOnClickListener(this);
        findViewById(R.id.p).setOnClickListener(this);
        findViewById(R.id.div).setOnClickListener(this);
        findViewById(R.id.button7).setOnClickListener(this);
        findViewById(R.id.button8).setOnClickListener(this);
        findViewById(R.id.button9).setOnClickListener(this);
        findViewById(R.id.buttonX).setOnClickListener(this);
        findViewById(R.id.button4).setOnClickListener(this);
        findViewById(R.id.button5).setOnClickListener(this);
        findViewById(R.id.button6).setOnClickListener(this);
        findViewById(R.id.buttonmin).setOnClickListener(this);
        findViewById(R.id.button1).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
        findViewById(R.id.button3).setOnClickListener(this);
        findViewById(R.id.buttonplus).setOnClickListener(this);
        findViewById(R.id.button00).setOnClickListener(this);
        findViewById(R.id.button0).setOnClickListener(this);
        findViewById(R.id.buttonver).setOnClickListener(this);
        findViewById(R.id.buttonegl).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String buttonText = ((MaterialButton) v).getText().toString();
        switch (buttonText) {
            case "AC":
                clearAll();
                break;
            case "C":
                clear();
                break;
            case "+":
            case "-":
            case "*":
            case "/":
                operator = buttonText.charAt(0);
                num1 = Double.parseDouble(solutionTV.getText().toString());
                clear();
                break;
            case "=":
                num2 = Double.parseDouble(solutionTV.getText().toString());
                calculate();
                break;
            default:
                operand += buttonText;
                solutionTV.setText(operand);
                break;
        }
    }

    private void clearAll() {
        solutionTV.setText("0");
        resultTV.setText("0");
        operand = "";
        num1 = 0;
        num2 = 0;
        operator = ' ';
    }

    private void clear() {
        operand = "";
        solutionTV.setText("0");
    }

    private void calculate() {
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
                if (num2 != 0)
                    result = num1 / num2;
                else
                    result = Double.NaN; // Indicate division by zero
                break;
        }
        resultTV.setText(String.valueOf(result));
        operand = "";
    }
}
