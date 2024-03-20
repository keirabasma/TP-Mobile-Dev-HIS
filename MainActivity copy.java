package com.example.tp1calc;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
TextView resultTV,solutionTV;
MaterialButton C,AC,buttonp,buttondiv;
    MaterialButton button7,button8,button9,buttonX;
    MaterialButton button4,button5,button6,buttonmin;
    MaterialButton button1,button2,button3,buttonplus;
    MaterialButton button00,button0,buttonvg,buttonegal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultTV=findViewById(R.id.result_tv);

        solutionTV=findViewById(R.id.solution_tv);
        assignId(AC,R.id.AC);
        assignId(C,R.id.c);
        assignId(buttonp,R.id.p);
        assignId(buttondiv,R.id.div);
        assignId(button7,R.id.button7);assignId(button8,R.id.button8);assignId(button9,R.id.button9);assignId(buttonX,R.id.buttonX);
        assignId(button4,R.id.button4);assignId(button5,R.id.button5);assignId(button6,R.id.button6);assignId(buttonmin,R.id.buttonmin);
        assignId(button1,R.id.button1);assignId(button2,R.id.button2);assignId(button3,R.id.button3);assignId(buttonplus,R.id.buttonplus);
        assignId(button00,R.id.button00);assignId(button0,R.id.button0);assignId(buttonvg,R.id.buttonver);assignId(buttonegal,R.id.buttonegl);
    }
    void assignId(MaterialButton btn, int id){
        btn=findViewById(id);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        MaterialButton button=(MaterialButton) v;
        String Buttontext=button.getText().toString();
        solutionTV.setText(Buttontext);

    }
}