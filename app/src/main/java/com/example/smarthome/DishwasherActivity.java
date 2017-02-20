package com.example.smarthome;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;


public class DishwasherActivity extends AppCompatActivity {
    private ProgressBar progressBar;
    private ToggleButton startButton;
    private Button cancelButton;
    private Button cancelDrainButton;
    private DishWashCountDownTimer dishWashCountDownTimer;
    private TextView timeLeftDisplay;
    private Spinner dishwasherSpinner;

    private static final String[] DISHWASHEROPTIONS = new String[] {
            "Auto", "Normal", "Heavy", "Delicate", "Express 30'", "Rinse only", "Self clean"
    };


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dishwasher);

        dishwasherSpinner = (Spinner) findViewById(R.id.dishwasher_spinner_1);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_item, DISHWASHEROPTIONS);
        adapter.setDropDownViewResource(R.layout.spinner_item);
        dishwasherSpinner.setAdapter(adapter);

        progressBar = (ProgressBar) findViewById(R.id.dishwasher_progressBar);
        startButton = (ToggleButton) findViewById(R.id.dishwasher_start_button);
        cancelButton = (Button) findViewById(R.id.dishwasher_cancel);
        cancelDrainButton = (Button) findViewById(R.id.dishwasher_drain);
        timeLeftDisplay = (TextView) findViewById(R.id.dishwasher_time_left);

        startButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    progressBar.setMax(300);
                    dishWashCountDownTimer = new DishWashCountDownTimer(30000, 1000);
                    dishWashCountDownTimer.start();
                } else {
                    dishWashCountDownTimer.cancel();
                }
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dishWashCountDownTimer != null) {
                    dishWashCountDownTimer.cancel();
                    Toast.makeText(DishwasherActivity.this, "Canceled...", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(DishwasherActivity.this, "The washer in not operating...", Toast.LENGTH_SHORT).show();
                }
            }
        });

        cancelDrainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dishWashCountDownTimer != null) {
                    dishWashCountDownTimer.cancel();
                    Toast.makeText(DishwasherActivity.this, "Canceled, the water is now drained", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(DishwasherActivity.this, "The dishwasher in not operating...", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public class DishWashCountDownTimer extends CountDownTimer {
        public DishWashCountDownTimer(long millisInFuture, long countDownInterval) {
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
            Toast.makeText(DishwasherActivity.this, "Done!", Toast.LENGTH_SHORT).show();
        }
    }
}
