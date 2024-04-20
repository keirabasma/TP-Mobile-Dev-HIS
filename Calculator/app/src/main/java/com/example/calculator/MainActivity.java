package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button b_Add, b_Sub, b_Mul, b_Div;
    EditText n1, n2;
    TextView textView;
    int num1, num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        b_Add = findViewById(R.id.b_add);
        b_Sub = findViewById(R.id.b_sub);
        b_Mul = findViewById(R.id.b_mul);
        b_Div = findViewById(R.id.b_div);

        n1 = findViewById(R.id.n1);
        n2 = findViewById(R.id.n2);

        textView = findViewById(R.id.ans);

        b_Add.setOnClickListener(this);
        b_Sub.setOnClickListener(this);
        b_Mul.setOnClickListener(this);
        b_Div.setOnClickListener(this);
    }

    public int GetNum(EditText editText) {
        if (editText.getText().toString().equals("")) {
            Toast.makeText(this, "Enter a number", Toast.LENGTH_SHORT).show();
            return 0;
        }
        return Integer.parseInt(editText.getText().toString());
    }

    @Override
    public void onClick(View view) {
        num1 = GetNum(n1);
        num2 = GetNum(n2);

        if (view.getId() == R.id.b_add) {
            textView.setText("Answer = " + (num1 + num2));
        } else if (view.getId() == R.id.b_sub) {
            textView.setText("Answer = " + (num1 - num2));
        } else if (view.getId() == R.id.b_mul) {
            textView.setText("Answer = " + (num1 * num2));
        } else if (view.getId() == R.id.b_div) {
            textView.setText("Answer = " + ((float) num1 / (float) num2));
        }
    }
}
