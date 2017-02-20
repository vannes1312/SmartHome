package com.example.smarthome;

import android.content.Context;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yiannisvamvakas on 23/01/2017.
 */

public class DeviceListAdapter extends RecyclerView.Adapter<DeviceListAdapter.ViewHolder> {

    private List<DeviceModel> items = new ArrayList<>();
    public List<DeviceModel> getItems() { return items; }

    @Override
    public DeviceListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_device, null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(DeviceListAdapter.ViewHolder holder, int position) {
        DeviceModel device = items.get(position);

        Context context = holder.itemView.getContext();
        ImageView icon = (ImageView) holder.itemView.findViewById(R.id.icon);
        TextView name = (TextView) holder.itemView.findViewById(R.id.name);

        icon.setImageDrawable(ContextCompat.getDrawable(context, device.iconResourceId));
        name.setText(device.nameStringResourceId);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

     public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView textView;
        private ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.name);
            imageView = (ImageView) itemView.findViewById(R.id.icon);
            itemView.setOnClickListener(this);
        }

         @Override
         public void onClick(View v) {
             Context context = itemView.getContext();
             final Intent intent;
             switch (getAdapterPosition()) {
                 case 0:
                     intent = new Intent(context, ThermostatActivity.class);
                     context.startActivity(intent);
                     break;
                 case 1:
                     intent = new Intent(context, AirConditionActivity.class);
                     context.startActivity(intent);
                     break;
                 case 2:
                     intent = new Intent(context, LightsActivity.class);
                     context.startActivity(intent);
                     break;
                 case 3:
                     intent = new Intent(context, LocksActivity.class);
                     context.startActivity(intent);
                     break;
                 case 4:
                     intent = new Intent(context, RefrigeratorActivity.class);
                     context.startActivity(intent);
                     break;
                 case 5:
                     intent = new Intent(context, StoveActivity.class);
                     context.startActivity(intent);
                     break;
                 case 6:
                     intent = new Intent(context, CookerActivity.class);
                     context.startActivity(intent);
                     break;
                 case 7:
                     intent = new Intent(context, DishwasherActivity.class);
                     context.startActivity(intent);
                     break;
                 case 8:
                     intent = new Intent(context, WasherActivity.class);
                     context.startActivity(intent);
                     break;
                 default:
                     break;
             }
         }
     }
}
