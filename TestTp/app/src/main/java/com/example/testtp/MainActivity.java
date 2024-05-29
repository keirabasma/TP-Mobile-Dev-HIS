package com.example.testtp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {



    EditText edit1, edit2, lengthField, commonField;

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
        edit1 = findViewById(R.id.edit1);
        edit2 = findViewById(R.id.edit2);
        lengthField = findViewById(R.id.lengthField);
        lengthField.setKeyListener(null);
        commonField = findViewById(R.id.commonField);
        commonField.setKeyListener(null);
        Button btnLength = findViewById(R.id.btnLength);
        btnLength.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setLength(edit1.getText().toString(),edit2.getText().toString());
            }
        });


        Button btnCommon = findViewById(R.id.btnCommon);
        btnCommon.setOnClickListener(v -> setCommon(edit1.getText().toString(), edit2.getText().toString()));
        Button btnClear = findViewById(R.id.btnClear);
        btnClear.setOnClickListener(v -> {
            edit1.setText("");
            edit2.setText("");
            lengthField.setText("");
            commonField.setText("");
        });





    }


    public void setLength(String edit1, String edit2){
        int length = edit1.length()+edit2.length();
        if (length == 0)
            Toast.makeText(this, "Both fields are empty", Toast.LENGTH_LONG).show();
        lengthField.setText(length +"");
    }
    public void setCommon(String edit1, String edit2){
        if(edit1.isEmpty() && edit2.isEmpty())
            Toast.makeText(this, "Both fields are empty", Toast.LENGTH_LONG).show();


        boolean[] chars = new boolean[256]; // Array to track characters
        int count = 0;
        // Mark characters present in str1
        for (char c : edit1.toCharArray()) {
            chars[c] = true;
        }

        // Count common characters from str2
        for (char c : edit2.toCharArray()) {
            if (chars[c]) {
                count++;
                chars[c] = false; // Prevent double counting
            }
        }
        commonField.setText(count+"");

    }




}