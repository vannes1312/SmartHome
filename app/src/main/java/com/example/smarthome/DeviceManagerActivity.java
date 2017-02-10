package com.example.smarthome;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * Created by yiannisvamvakas on 23/01/2017.
 */

public class DeviceManagerActivity extends AppCompatActivity {

    private RecyclerView deviceList;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_manager);
        deviceList = (RecyclerView) findViewById(R.id.device_list);
        deviceList.setLayoutManager(new LinearLayoutManager(this));
        deviceList.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        DeviceListAdapter adapter = new DeviceListAdapter();
        adapter.getItems().add(new DeviceModel(R.drawable.ic_thermostat, R.string.device_thermostat));
        adapter.getItems().add(new DeviceModel(R.drawable.ic_air_conditioning, R.string.device_ac));
        adapter.getItems().add(new DeviceModel(R.drawable.ic_lights, R.string.device_lights));
        adapter.getItems().add(new DeviceModel(R.drawable.ic_key, R.string.device_locks));
        adapter.getItems().add(new DeviceModel(R.drawable.ic_refrigerator, R.string.device_fridge));
        adapter.getItems().add(new DeviceModel(R.drawable.ic_stove, R.string.device_stove));
        adapter.getItems().add(new DeviceModel(R.drawable.ic_cooker, R.string.device_cooker));
        adapter.getItems().add(new DeviceModel(R.drawable.ic_dishwasher, R.string.device_dishwasher));
        adapter.getItems().add(new DeviceModel(R.drawable.ic_washing_machine, R.string.device_washer));
        deviceList.setAdapter(adapter);
    }
}
