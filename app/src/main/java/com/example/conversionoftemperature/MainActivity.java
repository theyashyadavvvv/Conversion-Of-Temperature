package com.example.conversionoftemperature;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editTextCelsius, editTextFahrenheit;
    private TextView textViewResultCelsius, textViewResultFahrenheit;
    private Button buttonConvert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextCelsius = findViewById(R.id.editTextCelsius);
        editTextFahrenheit = findViewById(R.id.editTextFahrenheit);
        textViewResultCelsius = findViewById(R.id.textViewResultCelsius);
        textViewResultFahrenheit = findViewById(R.id.textViewResultFahrenheit);
        buttonConvert = findViewById(R.id.buttonConvert);

        buttonConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertTemperature();
            }
        });
    }

    private void convertTemperature() {
        String celsiusText = editTextCelsius.getText().toString().trim();
        String fahrenheitText = editTextFahrenheit.getText().toString().trim();

        if (!celsiusText.isEmpty()) {
            double celsius = Double.parseDouble(celsiusText);
            double fahrenheit = (celsius * 9/5) + 32;
            textViewResultFahrenheit.setText("Fahrenheit Result: " + String.valueOf(fahrenheit));
        }

        if (!fahrenheitText.isEmpty()) {
            double fahrenheit = Double.parseDouble(fahrenheitText);
            double celsius = (fahrenheit - 32) * 5/9;
            textViewResultCelsius.setText("Celsius Result: " + String.valueOf(celsius));
        }
    }
}