package com.example.smarthome;

import java.util.concurrent.TimeUnit;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import org.w3c.dom.Text;

import static java.security.AccessController.getContext;


public class WasherActivity extends AppCompatActivity {
    private ProgressBar progressBar;
    private ToggleButton startButton;
    private Button cancelButton;
    private Button cancelDrainButton;
    private WashCountDownTimer washCountDownTimer;
    private TextView timeLeftDisplay;
    private Spinner washerSpinner;
    private Spinner washerCyclesSpinner;
    private Spinner washerTemperatureSpinner;

    private static final String[] WASHEROPTIONS = new String[] {
            "Wool", "Super Speed", "Delicate", "White", "Dark", "Cotton", "Synthetic"
    };

    private static final String[] WASHERCYCLES = new String[] {
            "1000", "900", "800", "700", "600", "500", "400"
    };

    private static final String[] WASHERTEMPERATURE = new String[] {
            "90°", "70°", "60°", "50°", "40°", "30°", "20°"
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_washer);

        washerSpinner = (Spinner) findViewById(R.id.washer_spinner_1);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_item, WASHEROPTIONS);
        adapter.setDropDownViewResource(R.layout.spinner_item);
        washerSpinner.setAdapter(adapter);

        washerCyclesSpinner = (Spinner) findViewById(R.id.washer_spinner_2);
        ArrayAdapter<String> washerCyclesAdapter = new ArrayAdapter<String>(this, R.layout.spinner_item, WASHERCYCLES);
        washerCyclesAdapter.setDropDownViewResource(R.layout.spinner_item);
        washerCyclesSpinner.setAdapter(washerCyclesAdapter);

        washerTemperatureSpinner = (Spinner) findViewById(R.id.washer_spinner_3);
        ArrayAdapter<String> washerTemperatureAdapter = new ArrayAdapter<String>(this, R.layout.spinner_item, WASHERTEMPERATURE);
        washerTemperatureAdapter.setDropDownViewResource(R.layout.spinner_item);
        washerTemperatureSpinner.setAdapter(washerTemperatureAdapter);

        progressBar = (ProgressBar) findViewById(R.id.washer_progressBar);
        startButton = (ToggleButton) findViewById(R.id.washer_start_button);
        cancelButton = (Button) findViewById(R.id.washer_cancel);
        cancelDrainButton = (Button) findViewById(R.id.washer_drain);
        timeLeftDisplay = (TextView) findViewById(R.id.washer_time_left);

        startButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    progressBar.setMax(300);
                    washCountDownTimer = new WashCountDownTimer(30000, 1000);
                    washCountDownTimer.start();
                } else {
                    washCountDownTimer.cancel();
                }
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (washCountDownTimer != null) {
                    washCountDownTimer.cancel();
                    Toast.makeText(WasherActivity.this, "Canceled...", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(WasherActivity.this, "The washer in not operating...", Toast.LENGTH_SHORT).show();
                }
            }
        });

        cancelDrainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (washCountDownTimer != null) {
                    washCountDownTimer.cancel();
                    Toast.makeText(WasherActivity.this, "Canceled, the water is now drained", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(WasherActivity.this, "The washer in not operating...", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public class WashCountDownTimer extends CountDownTimer {
        public WashCountDownTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            int progress = (int) (millisUntilFinished/100);
            timeLeftDisplay.setText("Time left: " + String.valueOf(progress));
            progressBar.setProgress(progressBar.getMax() - progress);
        }

        @Override
        public void onFinish() {
            Toast.makeText(WasherActivity.this, "Done!", Toast.LENGTH_SHORT).show();
        }
    }
}
