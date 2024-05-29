package com.example.vraitpappmob;

import android.os.Bundle;
import android.view.Menu;
import android.widget.RadioButton;
import androidx.appcompat.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.view.Gravity;


public class MainActivity extends AppCompatActivity {

    private EditText edt;
    private TextView resultText;
    private RadioButton rd1, rd2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt = findViewById(R.id.money);
        resultText = findViewById(R.id.textView4);
        rd1 = findViewById(R.id.rd1);
        rd2 = findViewById(R.id.rd2);

        Button convertButton = findViewById(R.id.convertir);
        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertir();
            }
        });


    }

    private float dinarToEuro(float valeurDinar) {
        return (float) (valeurDinar * 0.0071);
    }

    private float euroToDinar(float valeurEuro) {
        return (float) (valeurEuro * 140.45);
    }

    private void convertir() {
        float number = Float.valueOf(edt.getText().toString());
        float result;

        if (rd1.isChecked()) {
            result = dinarToEuro(number);
            resultText.setText(String.valueOf(result));
        } else if (rd2.isChecked()) {
            result = euroToDinar(number);
            resultText.setText(String.valueOf(result));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.conversion_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.menu_conversion_dinar_dollar) {
            return true;
        } else if (id == R.id.menu_quitter) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}