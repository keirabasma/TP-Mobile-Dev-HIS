package com.example.convertiseur;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextAmount;
    private RadioGroup radioGroup;
    private RadioButton radioButtonDinarToEuro;
    private RadioButton radioButtonEuroToDinar;
    private Button buttonConvert;
    private TextView textViewResult;

    private static final double DINAR_TO_EURO_RATE = 0.0031;
    private static final double EURO_TO_DINAR_RATE = 322.58;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextAmount = findViewById(R.id.editTextAmount);
        radioGroup = findViewById(R.id.radioGroup);
        radioButtonDinarToEuro = findViewById(R.id.radioButtonDinarToEuro);
        radioButtonEuroToDinar = findViewById(R.id.radioButtonEuroToDinar);
        buttonConvert = findViewById(R.id.buttonConvert);
        textViewResult = findViewById(R.id.textViewResult);

        buttonConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertCurrency();
            }
        });
    }

    private void convertCurrency() {
        String amountStr = editTextAmount.getText().toString();

        if (amountStr.isEmpty()) {
            Toast.makeText(this, "Veuillez entrer un montant", Toast.LENGTH_SHORT).show();
            return;
        }

        double amount = Double.parseDouble(amountStr);
        double result;

        if (radioButtonDinarToEuro.isChecked()) {
            result = amount * DINAR_TO_EURO_RATE;
        } else {
            result = amount * EURO_TO_DINAR_RATE;
        }

        textViewResult.setText(String.format("Résultat: %.2f", result));
    }
}