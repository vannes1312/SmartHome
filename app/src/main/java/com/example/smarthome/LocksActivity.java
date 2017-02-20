package com.example.smarthome;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class LocksActivity extends AppCompatActivity {
    private Button lockBtn;
    private Button unlockBtn;
    private ImageView doorImgView;
    private TextView doorIndicatorTxtView;

    private boolean isLocked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locks);

        lockBtn = (Button) findViewById(R.id.lockbutton);
        unlockBtn = (Button) findViewById(R.id.unlockbutton);
        doorImgView = (ImageView) findViewById(R.id.doorimage);
        doorIndicatorTxtView = (TextView) findViewById(R.id.doorindicator);

        isLocked = true;
    }

    public void lockDoor(View view) {
        if(isLocked == false) {
            doorImgView.setImageResource(R.drawable.reddoor);
            doorIndicatorTxtView.setText("THE DOOR IS LOCKED");
            isLocked = true;
        }
    }

    public void unlockDoor(View view) {
        if(isLocked == true) {
            doorImgView.setImageResource(R.drawable.greendoor);
            doorIndicatorTxtView.setText("THE DOOR IS UNLOCKED");
            isLocked = false;
        }
    }
}