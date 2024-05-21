package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnAdd, btnSubtract, btnMultiply, btnDivide;
    private EditText editText1, editText2;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd = findViewById(R.id.btnadd);
        btnSubtract = findViewById(R.id.btnsupp);
        btnMultiply = findViewById(R.id.btnmult);
        btnDivide = findViewById(R.id.btndiv);
        editText1 = findViewById(R.id.number);
        editText2 = findViewById(R.id.number2);
        textView = findViewById(R.id.answer);

        btnAdd.setOnClickListener(this);
        btnSubtract.setOnClickListener(this);
        btnMultiply.setOnClickListener(this);
        btnDivide.setOnClickListener(this);
    }

    private int getIntFromEditText(EditText editText) {
        if (editText.getText().toString().isEmpty()) {
            Toast.makeText(this, "Please enter a number", Toast.LENGTH_SHORT).show();
            return 0;
        } else {
            return Integer.parseInt(editText.getText().toString());
        }
    }

    @Override
    public void onClick(View view) {
        int num1 = getIntFromEditText(editText1);
        int num2 = getIntFromEditText(editText2);

        int viewId = view.getId();
        if (viewId == R.id.btnadd) {
            textView.setText("answer = " + (num1 + num2));
        } else if (viewId == R.id.btnsupp) {
            textView.setText("answer = " + (num1 - num2));
        } else if (viewId == R.id.btnmult) {
            textView.setText("answer = " + (num1 * num2));
        } else if (viewId == R.id.btndiv) {
            if (num2 == 0) {
                Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show();
            } else {
                textView.setText("answer = " + ((float) num1 / num2));
            }
        }
    }
}
