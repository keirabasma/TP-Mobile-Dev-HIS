package com.example.calculator;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
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
    }

    public void add(View view) {
        Context context = getApplicationContext();
        EditText editText = (EditText)
                findViewById(R.id.editTextNumberDecimal);
        EditText editText2 = (EditText)
                findViewById(R.id.editTextNumberDecimal2);
        EditText editText3 = (EditText)
                findViewById(R.id.editTextNumberDecimal3);
        int n1 =Integer.parseInt(editText.getText().toString());
        int n2 =Integer.parseInt(editText2.getText().toString());

        int result=n1+n2;

        editText3.setText("the result is:"+result);
    }

    public void substract(View view) {
        Context context = getApplicationContext();
        EditText editText = (EditText)
                findViewById(R.id.editTextNumberDecimal);
        EditText editText2 = (EditText)
                findViewById(R.id.editTextNumberDecimal2);
        EditText editText3 = (EditText)
                findViewById(R.id.editTextNumberDecimal3);
        int n1 =Integer.parseInt(editText.getText().toString());
        int n2 =Integer.parseInt(editText2.getText().toString());

        int result=n1-n2;

        editText3.setText("the result is:"+result);
    }

    public void multiplication(View view) {
        Context context = getApplicationContext();
        EditText editText = (EditText)
                findViewById(R.id.editTextNumberDecimal);
        EditText editText2 = (EditText)
                findViewById(R.id.editTextNumberDecimal2);
        EditText editText3 = (EditText)
                findViewById(R.id.editTextNumberDecimal3);
        int n1 =Integer.parseInt(editText.getText().toString());
        int n2 =Integer.parseInt(editText2.getText().toString());

        int result=n1*n2;

        editText3.setText("the result is:"+result);
    }

    public void division(View view) {
        Context context = getApplicationContext();
        EditText editText = (EditText)
                findViewById(R.id.editTextNumberDecimal);
        EditText editText2 = (EditText)
                findViewById(R.id.editTextNumberDecimal2);
        EditText editText3 = (EditText)
                findViewById(R.id.editTextNumberDecimal3);
        int n1 =Integer.parseInt(editText.getText().toString());
        int n2 =Integer.parseInt(editText2.getText().toString());

        int result=n1/n2;

        editText3.setText("the result is:"+result);
    }
}