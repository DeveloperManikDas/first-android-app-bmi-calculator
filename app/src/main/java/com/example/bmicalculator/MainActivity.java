package com.example.bmicalculator;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        TextView bmi_result = findViewById(R.id.bmi_result);
        EditText weight = findViewById(R.id.weight);
        EditText heightF = findViewById(R.id.heightF);
        EditText heightI = findViewById(R.id.heightI);
        Button submit = findViewById(R.id.submit);

        submit.setOnClickListener(v -> {
            int wt = Integer.parseInt(weight.getText().toString());
            int hf = Integer.parseInt(heightF.getText().toString());
            int hi = Integer.parseInt(heightI.getText().toString());

            double totalIn = hf*12 + hi;
            double totalCm = totalIn*2.54;
            double totalHeight = totalCm/100;
            double bmi = wt/(totalHeight*totalHeight);

            if(bmi<18){
                bmi_result.setText(String.format(getString(R.string.underweight), bmi));
                bmi_result.setTextColor(ContextCompat.getColor(this, R.color.red));

            }else if(bmi>=18 && bmi<=25){
                bmi_result.setText(String.format(getString(R.string.normal_bmi), bmi));
                bmi_result.setTextColor(ContextCompat.getColor(this, R.color.green));


            }else{
                bmi_result.setText(String.format(getString(R.string.overweight), bmi));
                bmi_result.setTextColor(ContextCompat.getColor(this, R.color.yellow));


            }


        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}