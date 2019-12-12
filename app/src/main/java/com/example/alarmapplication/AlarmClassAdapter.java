package com.example.alarmapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import static com.example.alarmapplication.R.layout.alarm_adapter;

public class AlarmClassAdapter  extends RecyclerView.Adapter<AlarmClassAdapter.ViewHolder>{

    private  ArrayList<Alarm> alarms = new ArrayList<>();

    public AlarmClassAdapter() {

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(alarm_adapter,parent,  false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.messageTxtView.setText(alarms.get(position).getMessage());
        String time = alarms.get(position).getHours() + " : " + alarms.get(position).getMessage();
        holder.timeTxtView.setText(time);
    }

    @Override
    public int getItemCount() {
        return alarms.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView timeTxtView;
        private TextView messageTxtView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            timeTxtView = (TextView)itemView.findViewById(R.id.timeTxtView);
            messageTxtView = (TextView)itemView.findViewById(R.id.messageTxtView);
        }
    }

    public void setAlarms(ArrayList<Alarm> alarms) {
        this.alarms = alarms;
        notifyDataSetChanged();
    }
}
