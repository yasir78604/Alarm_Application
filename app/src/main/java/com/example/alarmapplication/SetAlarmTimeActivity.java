package com.example.alarmapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SetAlarmTimeActivity extends AppCompatActivity {
    private EditText edtTxtHour , edtTxtMinute ;
    private Button btnSetAlarmTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_alarm_time);

        edtTxtHour = (EditText)findViewById(R.id.edtTextHour);
        edtTxtMinute = (EditText)findViewById(R.id.edtTextMinute);
        btnSetAlarmTime = (Button) findViewById(R.id.btnSetAlarmTime);
        btnSetAlarmTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();

                int i =Integer.parseInt(String.valueOf(edtTxtHour.getText()));
                bundle.putInt(getString(R.string.hours),i);
                bundle.putInt(getString(R.string.minute),Integer.parseInt(String.valueOf(edtTxtMinute.getText())));
                Intent intent = new Intent(SetAlarmTimeActivity.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra(getString(R.string.bundle),bundle);
                startActivity(intent);
            }
        });

    }
}
