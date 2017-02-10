package com.example.smarthome;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by yiannisvamvakas on 01/02/2017.
 */

public class ThermostatActivity extends AppCompatActivity {
    private Button plusButton;
    private Button minusButton;
    private TextView temperatureDisplay;
    private int temperature = 20;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thermostat);

        plusButton = (Button) findViewById(R.id.plus_button);
        minusButton = (Button) findViewById(R.id.minus_button);
        temperatureDisplay = (TextView) findViewById(R.id.temperature);
        temperatureDisplay.setText(String.valueOf(temperature));

        plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int newTemperature = increasingTemperature(temperatureDisplay);
                temperatureDisplay.setText(String.valueOf(newTemperature));
            }


        });

        minusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int newTemperature = decreasingTemperature(temperatureDisplay);
                temperatureDisplay.setText(String.valueOf(newTemperature));
            }
        });
    }

    public int increasingTemperature (TextView textView) {
        int temperature = Integer.parseInt(String.valueOf(textView.getText()));
        temperature += 1;
        if (temperature > 30) {
            return temperature = 30;
        } else {
            return temperature;
        }
    }

    public int decreasingTemperature (TextView textView) {
        int temperature = Integer.parseInt(String.valueOf(textView.getText()));
        temperature -= 1;
        if (temperature < 0) {
            temperature = 0;
            return temperature;
        } else {
            return temperature;
        }

    }
}
