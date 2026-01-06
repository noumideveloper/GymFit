package com.example.gymfit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class BMICalculatorActivity extends AppCompatActivity {
    Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bmi_calculator);

        EditText w = findViewById(R.id.etWeight);
        EditText h = findViewById(R.id.etHeight);
        TextView r = findViewById(R.id.tvResult);
        Button b = findViewById(R.id.btnCalc);
        back= findViewById(R.id.back);

        b.setOnClickListener(v -> {

            double weight = Double.parseDouble(w.getText().toString());
            double height = Double.parseDouble(h.getText().toString());

            double bmi = weight / (height * height);

            String status;

            if(bmi < 18.5) status = "Underweight";
            else if(bmi < 25) status = "Normal";
            else if(bmi < 30) status = "Overweight";
            else status = "Obese";

            r.setText("BMI = " + bmi + "\nStatus: " + status);
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(BMICalculatorActivity.this, HomeActivity.class);
                startActivity(i);
            }
        });
    }
}

