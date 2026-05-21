package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TextView tvDisplay;
    String current = "";
    double firstNumber = 0;
    String operator = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDisplay = findViewById(R.id.tvDisplay);
    }

    public void onClick(View v) {

        Button btn = (Button) v;
        String value = btn.getText().toString();

        switch (value) {
            case "C":
                current = "";
                firstNumber = 0;
                operator = "";
                tvDisplay.setText("0");
                break;

            case "+":
            case "-":
            case "*":
            case "/":
                if (!current.isEmpty()) {
                    firstNumber = Double.parseDouble(current);
                    operator = value;
                    current = "";
                }
                break;

            case "=":
                if (current.isEmpty()) return;

                double secondNumber = Double.parseDouble(current);
                double result = 0;

                switch (operator) {
                    case "+":
                        result = firstNumber + secondNumber;
                        break;

                    case "-":
                        result = firstNumber - secondNumber;
                        break;

                    case "*":
                        result = firstNumber * secondNumber;
                        break;

                    case "/":
                        if (secondNumber == 0) {
                            tvDisplay.setText("Error");
                            return;
                        }
                        result = firstNumber / secondNumber;
                        break;
                }

                tvDisplay.setText(String.valueOf(result));
                current = String.valueOf(result);
                break;


            default:
                current += value;
                tvDisplay.setText(current);
                break;
        }
    }
}