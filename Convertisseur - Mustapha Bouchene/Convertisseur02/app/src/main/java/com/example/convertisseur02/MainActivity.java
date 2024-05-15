package com.example.convertisseur02;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    RadioButton radio1;
    RadioButton radio2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        radio1 = findViewById(R.id.radioDinars);
        radio2 = findViewById(R.id.radioEuro);

//          TextView points = findViewById(R.id.points);

        registerForContextMenu(radio1);
        registerForContextMenu(radio2);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


    }


    private float dinarsToEuro(float valeurDinar) {
        return (float) (valeurDinar * 0.0071);
    }
    private float euroToDinar(float valeurEuro) {
        return (float) (valeurEuro * 140.45);
    }

    public void converterFunc (View view){
        /**/

        RadioButton radio1 = findViewById(R.id.radioDinars);
        RadioButton radio2 = findViewById(R.id.radioEuro);

        EditText entredNum = findViewById(R.id.entered);
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
                result = dinarsToEuro(num);
                resultSring = String.valueOf(result) + " €";
            } else if (radio2.isChecked()){
                result = euroToDinar(num);
                resultSring = String.valueOf(result) + " DZD";
            }

            TextView textView = findViewById(R.id.result);
            textView.setText(resultSring);



        }}





    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater1 = new MenuInflater(this);
        menuInflater1.inflate(R.menu.context_menu_radio1, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        if (item.getItemId()==R.id.b1_item1) {
            Toast.makeText(this, "140.45 DZD -> 1 €", Toast.LENGTH_LONG).show();
        } else if (item.getItemId()==R.id.b1_item2) {
            Toast.makeText(this, "0.0071 € -> 1 DZD", Toast.LENGTH_LONG).show();
        }
        return super.onContextItemSelected(item);
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();

        inflater.inflate(R.menu.options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==R.id.b2_item2) {
            finish();
        } else if (item.getItemId()==R.id.b2_item1) {
            EditText editText = findViewById(R.id.entered) ;
            String value = editText.getText().toString();
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            intent.putExtra("value", value);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}