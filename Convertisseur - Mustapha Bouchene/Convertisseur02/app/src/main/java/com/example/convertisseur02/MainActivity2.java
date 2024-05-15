package com.example.convertisseur02;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        String editTextContent = getIntent().getStringExtra("value");
        EditText entredNum = findViewById(R.id.entered2);
        entredNum.setText(editTextContent);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }


    private float dinarsTodollar (float valeurDinar) {
        return (float) (valeurDinar * 0.0071);
    }
    private float dollarToDinar(float valeurDollar) {
        return (float) (valeurDollar * 140.45);
    }

    public void converterFunc2 (View view){
        /**/

        RadioButton radio1 = findViewById(R.id.radioDinars2);
        RadioButton radio2 = findViewById(R.id.radioDollar);

        EditText entredNum = findViewById(R.id.entered2);
        String entredNumString = entredNum.getText().toString();
        if (entredNumString.isEmpty()){
            AlertDialog alertDialog;
            alertDialog = new AlertDialog.Builder(this).create();
            alertDialog.setTitle("Error");
            alertDialog.setMessage("Please enter a number!");
            alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            alertDialog.show();


        } else {
            float num = Float.valueOf(entredNumString);

            float result;
            String resultSring="";
            if(radio1.isChecked()){
                result = dinarsTodollar(num);
                resultSring = String.valueOf(result) + " $";
            } else if (radio2.isChecked()){
                result = dollarToDinar(num);
                resultSring = String.valueOf(result) + " DZD";
            }

            TextView textView = findViewById(R.id.result2);
            textView.setText(resultSring);



        }}





}