package com.example.smarthome;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class RefrigeratorActivity extends AppCompatActivity {
    private static final String[] STATUS = {"Normal", "Eco", "High"};

    private ListView statusListView;
    private TextView freezerValueTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refrigerator);

        statusListView = (ListView) findViewById(R.id.statusListView);
        freezerValueTV = (TextView) findViewById(R.id.freezerValueTV);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, STATUS);
        statusListView.setAdapter(arrayAdapter);
    }

    public void increaseFreezerValue(View view) {
        double freezerValue = Integer.parseInt( freezerValueTV.getText().toString() );
        if(freezerValue == -20)
            return;
        freezerValue -= 0.5;
        freezerValueTV.setText( String.valueOf(freezerValue) );
    }

    public void decreaseFreezerValue(View view) {
        double freezerValue = Integer.parseInt( freezerValueTV.getText().toString() );
        if(freezerValue == 0)
            return;
        freezerValue += 0.5;
        freezerValueTV.setText( String.valueOf(freezerValue) );
    }
}