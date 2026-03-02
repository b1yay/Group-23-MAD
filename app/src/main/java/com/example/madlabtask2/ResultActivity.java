package com.example.madlabtask2; // keep your package name

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    TextView tvDetails, tvBMI, tvCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        tvDetails = findViewById(R.id.tvDetails);
        tvBMI = findViewById(R.id.tvBMI);
        tvCategory = findViewById(R.id.tvCategory);

        String name = getIntent().getStringExtra("name");
        String age = getIntent().getStringExtra("age");
        double bmi = getIntent().getDoubleExtra("bmi", 0);

        tvDetails.setText("Name: " + name + "\nAge: " + age);
        tvBMI.setText("BMI: " + String.format("%.2f", bmi));

        if (bmi < 18.5) {
            tvCategory.setText("Underweight");
            tvCategory.setTextColor(Color.BLUE);
        } else if (bmi >= 18.5 && bmi <= 24.9) {
            tvCategory.setText("Normal");
            tvCategory.setTextColor(Color.GREEN);
        } else {
            tvCategory.setText("Overweight");
            tvCategory.setTextColor(Color.RED);
        }
    }
}