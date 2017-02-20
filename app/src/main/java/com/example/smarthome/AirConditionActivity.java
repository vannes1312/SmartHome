package com.example.smarthome;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * Created by yiannisvamvakas on 01/02/2017.
 */

public class AirConditionActivity extends AppCompatActivity {
    private Button plusButton;
    private Button minusButton;
    private TextView temperatureDisplay;
    private Spinner fanOptionsSpinner;
    private Spinner windDirectionSpinner;
    private int temperature = 19;

    private static final String[] FANOPTIONS = new String[] {
            "Auto", "Low", "Medium", "High", "Turbo", "I'm flying"
    };

    private static final String[] WINDDIRECTIONOPTIONS = new String[] {
            "Flap", "Halt"
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_air_condition);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.air_conditions_functions, R.layout.spinner_item);
        adapter.setDropDownViewResource(R.layout.spinner_item);
        spinner.setAdapter(adapter);

        fanOptionsSpinner = (Spinner) findViewById(R.id.fanSpeedSpinner);
        ArrayAdapter<String> fanAdapter = new ArrayAdapter<String>(this, R.layout.spinner_item, FANOPTIONS);
        fanAdapter.setDropDownViewResource(R.layout.spinner_item);
        fanOptionsSpinner.setAdapter(fanAdapter);

        windDirectionSpinner = (Spinner) findViewById(R.id.windDirectionSpinner);
        ArrayAdapter<String> windDirectionAdapter = new ArrayAdapter<String>(this, R.layout.spinner_item, WINDDIRECTIONOPTIONS);
        windDirectionAdapter.setDropDownViewResource(R.layout.spinner_item);
        windDirectionSpinner.setAdapter(windDirectionAdapter);

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
        if (temperature < 16) {
             temperature = 16;
            return temperature;
        } else {
            return temperature;
        }
    }
}
