package com.example.revision;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity  {
private EditText number1;
private EditText number2;

private Button division;
private Button addition;
private Button soustraction;
private Button multiplication;

private TextView resultat;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number1 = findViewById(R.id.num1);
        number2 = findViewById(R.id.num2);
        addition = findViewById(R.id.add);
        soustraction = findViewById(R.id.sum);
        multiplication = findViewById(R.id.multi);
        division=findViewById(R.id.div);
        resultat = findViewById(R.id.resu);

    }



    public void add(View view){

        double mynumber1 = Double.parseDouble(number1.getText().toString());
      double mynumber2 = Double.parseDouble(number2.getText().toString());
      resultat.setText ("Resultat"  + (mynumber1 +  mynumber2));

    }

    public void sum(View view){

        double mynumber1 = Double.parseDouble(number1.getText().toString());
        double mynumber2 = Double.parseDouble(number2.getText().toString());
       double resultatt = mynumber1-mynumber2;
        resultat.setText("Result: " + resultatt);
    }


public void multip (View view){
        double mynumber1 = Double.parseDouble(number1.getText().toString());
    double mynumber2 = Double.parseDouble(number2.getText().toString());
   double resultatt = mynumber1*mynumber2;
   resultat.setText("resu "+resultatt);
}




    }




