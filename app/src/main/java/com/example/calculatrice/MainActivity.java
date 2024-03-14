package com.example.calculatrice;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
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

    public void numberClick(View view) {
        String buttonValue = ((TextView)view).getText().toString();
        String currentText = ((TextView)findViewById(R.id.operation)).getText().toString();
        String newText = currentText+buttonValue;
        ((TextView)findViewById(R.id.operation)).setText(newText);
    }

    public void resultButton(View view) {
        Context context = getApplicationContext();
        String result = ((TextView)findViewById(R.id.operation)).getText().toString();

        String[] split = result.split("(?<=\\d)(?=\\D)|(?<=\\D)(?=\\d)|(?<=\\d)(?=\\.)|(?<=\\.)(?=\\d)");
        float result_number;
        try {
        switch (split[1]){
            case "+":
                result_number=Float.parseFloat(split[0])+Float.parseFloat(split[2]);
                break;
            case "-":
                result_number=Float.parseFloat(split[0])-Float.parseFloat(split[2]);
                break;
            case "*":
                result_number=Float.parseFloat(split[0])*Float.parseFloat(split[2]);
                break;
            case "/":
                result_number=Float.parseFloat(split[0])/Float.parseFloat(split[2]);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + split[1]);
        }
        result = ""+result_number;
        ((TextView)findViewById(R.id.text1)).setText(result);
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, result, duration);
        toast.show();
        } catch (Exception e) {
            Log.e("ResultButton", "An error occurred during calculation", e);
        }
    }

    public void delete(View view) {
        ((TextView)findViewById(R.id.text1)).setText("");
        ((TextView)findViewById(R.id.operation)).setText("");
    }
    public void backspace(View view) {
        TextView operationText= findViewById(R.id.operation);
        String currentText = operationText.getText().toString();
        if (!currentText.isEmpty()) {
            String newText = currentText.substring(0, currentText.length() - 1);
            operationText.setText(newText);
        }

    }
}