package com.example.smarthome;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class LightsActivity extends AppCompatActivity {
    private static final String[] OPERATIONS = {"Living Room", "Bedroom 1", "Bedroom 2","Kitchen","WC"};
    private ListView Lightslist ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lights);


        Lightslist = (ListView) findViewById(R.id.Lightslist);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, OPERATIONS);
        Lightslist.setAdapter(arrayAdapter);

        Lightslist.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0) {
                    Intent entranceIntent = new Intent(LightsActivity.this, LightsControlActivity.class);
                    startActivity(entranceIntent);
                }
                else if(position == 1) {
                    Intent entranceIntent = new Intent(LightsActivity.this, LightsControlActivity.class);
                    startActivity(entranceIntent);
                }
                else if(position == 2){
                    Intent entranceIntent = new Intent(LightsActivity.this, LightsControlActivity.class);
                    startActivity(entranceIntent);
                }

                else if(position == 3){
                    Intent entranceIntent = new Intent(LightsActivity.this, LightsControlActivity.class);
                    startActivity(entranceIntent);
                }

                else if(position == 4){
                    Intent entranceIntent = new Intent(LightsActivity.this, LightsControlActivity.class);
                    startActivity(entranceIntent);
                }

                else if(position == 5){
                    Intent entranceIntent = new Intent(LightsActivity.this, LightsControlActivity.class);
                    startActivity(entranceIntent);
                }

            }
        });
    }
}
