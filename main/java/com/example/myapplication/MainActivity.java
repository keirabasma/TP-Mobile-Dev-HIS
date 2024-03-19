package com.example.myapplication;

import android.os.Bundle;
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
    private Button button6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        editText = findViewById(R.id.editTextText);
        textView = findViewById(R.id.textView2);
        button6= findViewById(R.id.button6);

        // Set OnClickListener for the button
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateResult();
            }
        });
    }

    // Method to calculate the result
    private void calculateResult() {
        // Get text from the EditText
        String inputText = editText.getText().toString().trim(); // Trim to remove leading and trailing spaces

        // Check if inputText is not empty
        if (!inputText.isEmpty()) {
            // Use regular expression to split the inputText into operands and operator
            Pattern pattern = Pattern.compile("([0-9.]+)\\s*([+\\-/])\\s([0-9.]+)");
            Matcher matcher = pattern.matcher(inputText);

            if (matcher.matches()) {
                try {
                    double operand1 = Double.parseDouble(matcher.group(1));
                    double operand2 = Double.parseDouble(matcher.group(3));
                    String operator = matcher.group(2);

                    double result = 0;
                    // Perform the calculation based on the operator
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
                    // Handle parsing errors (e.g., non-numeric operands)
                    textView.setText("Invalid input format");
                }
            } else {
                textView.setText("Invalid input format");
            }
        } else {
            textView.setText("No input provided");
        }
    }
}