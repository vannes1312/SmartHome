package com.example.smarthome;

import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.ImageView;
        import android.widget.Switch;

public class LightsControlActivity extends AppCompatActivity {
    private Switch lightSwitch;
    private ImageView lightImgView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lights_control);

        lightSwitch = (Switch) findViewById(R.id.lightSwitch);
        lightImgView = (ImageView) findViewById(R.id.lightImgView);
    }

    public void controlLight(View view) {
        if(lightSwitch.isChecked() == true)
            lightImgView.setImageResource(R.drawable.lightson);
        if(lightSwitch.isChecked() == false)
            lightImgView.setImageResource(R.drawable.lightsoff);
    }
}
