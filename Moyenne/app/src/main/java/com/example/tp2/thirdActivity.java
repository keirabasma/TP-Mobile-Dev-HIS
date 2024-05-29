package com.example.tp2;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.tp2.R;

public class thirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thirdactivity);

        float moyenne = getIntent().getFloatExtra("moyenne", 0);

        TextView textViewMoyenne = findViewById(R.id.textViewMoyenne);
        textViewMoyenne.setText("Votre moyenne : " + moyenne);
    }
}
