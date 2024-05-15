package com.example.calculatrice;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private TextView textView;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editTextText);
        textView = findViewById(R.id.textView2);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateResult();
            }
        });
    }

    private void calculateResult() {
        String inputText = editText.getText().toString().trim(); // Trim to remove leading and trailing spaces

        if (!inputText.isEmpty()) {

            Pattern pattern = Pattern.compile("([0-9.]+)\\s*([+\\-*/])\\s*([0-9.]+)");
            Matcher matcher = pattern.matcher(inputText);

            if (matcher.matches()) {
                try {
                    double operand1 = Double.parseDouble(matcher.group(1));
                    double operand2 = Double.parseDouble(matcher.group(3));
                    String operator = matcher.group(2);

                    double result = 0;

                    switch (operator) {
                        case "+":
                            result = operand1 + operand2;
                            break;
                        case "-":
                            result = operand1 - operand2;
                            break;
                        case "*":
                            result = operand1 * operand2;
                            break;
                        case "/":
                            if (operand2 != 0) {
                                result = operand1 / operand2;
                            } else {
                                textView.setText("Cannot divide by zero");
                                return;
                            }
                            break;
                        default:
                            textView.setText("Invalid operator");
                            return;
                    }

                    // Set the result to the TextView
                    textView.setText(String.valueOf(result));
                } catch (NumberFormatException e) {
                    textView.setText("Invalid input format");
                }
            } else {
                textView.setText(editText.getText());
            }
        } else {
            textView.setText("No input provided");
        }
    }
}
