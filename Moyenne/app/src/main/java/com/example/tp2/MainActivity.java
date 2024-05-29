
package com.example.tp2;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tp2.R;
import com.example.tp2.thirdActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextNote1, editTextNote2, editTextNote3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNote1 = findViewById(R.id.editTextNote1);
        editTextNote2 = findViewById(R.id.editTextNote2);
        editTextNote3 = findViewById(R.id.editTextNote3);

        Button buttonCalculer = findViewById(R.id.buttonCalculer);
        buttonCalculer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float note1 = Float.parseFloat(editTextNote1.getText().toString());
                float note2 = Float.parseFloat(editTextNote2.getText().toString());
                float note3 = Float.parseFloat(editTextNote3.getText().toString());

                float moyenne = (note1 + note2 + note3) / 3;

                if (moyenne >= 10) {
                    Intent intent = new Intent(MainActivity.this,SuccedActivity.class);
                    intent.putExtra("moyenne", moyenne);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(MainActivity.this, thirdActivity.class);
                    intent.putExtra("moyenne", moyenne);
                    startActivity(intent);
                }
            }
        });
    }
}
