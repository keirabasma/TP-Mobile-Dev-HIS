package com.example.convertisseur;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ConversionDinarDollarActivity extends AppCompatActivity {

    private EditText edtDinarAmount;
    private Button btnConvert;
    private TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversion_dinar_dollar);

        edtDinarAmount = findViewById(R.id.editTextDinarAmount);
        btnConvert = findViewById(R.id.buttonConvert);
        txtResult = findViewById(R.id.textViewResult);

        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertDinarToDollar();
            }
        });
    }

    private void convertDinarToDollar() {
        if (edtDinarAmount.getText().toString().isEmpty()) {
            txtResult.setText("Veuillez entrer un montant en Dinar.");
            return;
        }

        try {
            float dinarAmount = Float.parseFloat(edtDinarAmount.getText().toString());
            float dollarAmount = dinarAmount * 0.0015f; // Conversion en utilisant le taux de 0.0015
            txtResult.setText("Montant en Dollar : " + dollarAmount);
        } catch (NumberFormatException e) {
            txtResult.setText("Veuillez entrer un nombre valide pour le montant en Dinar.");
        }
    }
}
