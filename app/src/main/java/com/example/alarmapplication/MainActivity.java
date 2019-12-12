package com.example.alarmapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private Button btnSetAlarm;
    private RecyclerView recyclerView;
    private AlarmClassAdapter adapter;
    private static ArrayList<Alarm> allalarms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (allalarms == null){
            allalarms = new ArrayList<>();
        }
        adapter = new AlarmClassAdapter();
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter.setAlarms(allalarms);

        btnSetAlarm = (Button)findViewById(R.id.btnSetAlarm);
        recyclerView = (RecyclerView) findViewById(R.id.recView);
        btnSetAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SetAlarmTimeActivity.class);
                startActivity(intent);
            }
        });
        try {
            Intent intent=getIntent();
            Bundle bundle = intent.getBundleExtra(getString(R.string.bundle));
            if (bundle != null){
                int hours =  bundle.getInt(getString(R.string.hours),-1);
                int minute = bundle.getInt(getString(R.string.minute),-1);
                if (hours != -1){
                    if (minute != -1){
                        Intent alarmIntent = new Intent(AlarmClock.ACTION_SET_ALARM);
                        alarmIntent.putExtra(AlarmClock.EXTRA_HOUR,hours);
                        alarmIntent.putExtra(AlarmClock.EXTRA_MINUTES,minute);
                        alarmIntent.putExtra(AlarmClock.EXTRA_MINUTES,"Message from Other Side");
                        Alarm alarm = new Alarm(hours,minute,"Message from Other Side");
                        allalarms.add(alarm);
                        adapter.setAlarms(allalarms);
                        startActivity(alarmIntent);
                    }
                }

            }else {
                Log.d(TAG, "onCreate: It has Nothing");
            }


        }catch (Exception e){
            e.getStackTrace();
        }

    }


}
