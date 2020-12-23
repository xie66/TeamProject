package com.gezhi.gege.stepcount;

import android.content.Intent;
import android.content.SharedPreferences;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.gezhi.gege.MainActivity;
import com.gezhi.gege.R;
import com.gezhi.gege.news.MainNewsActivity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StepcounterActivity extends AppCompatActivity implements SensorEventListener {

    TextView showHelloTv, showStepTv, showTimeTv;
    SensorManager sensorManager;
    Sensor stepCounterSensor;
    SharedPreferences sharedPreferences;
    long currentSteps;
    ImageView stepback, stepperson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitystepcounter_main);
        initview();
//        onClick();
        if (stepCounterSensor != null) {
            sensorManager.registerListener(this, stepCounterSensor, SensorManager.SENSOR_DELAY_NORMAL);
        } else {
            Toast.makeText(this, "设备不支持计步传感器", Toast.LENGTH_SHORT).show();
        }

        if (sharedPreferences != null) {
            long storSteps = sharedPreferences.getLong("total", 0);
            String storeTime = sharedPreferences.getString("time", setDataFormat(System.currentTimeMillis()));
            String currentTime = setDataFormat(System.currentTimeMillis());
            if (storeTime.substring(0, 9).equals(currentTime.substring(0, 9))) {
                currentSteps = storSteps;
                Log.d("TAG-stor", "onCreate当天步数： " + currentSteps);
            } else {  //不是当天步数
                currentSteps = 0;
                Log.d("TAG-init-steps", "onCreate不是当天步数 " + currentSteps);
            }
        }
    }

//    private void onClick() {
//        stepperson.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });
//    }

    public void uiUpdate(long steps, String time) {
        Log.d("TAG-uiUpdate", "uiUpdate: " + steps);
        showTimeTv.setText(time);
        showStepTv.setText(steps + "");
        if (steps > 10000) {
            showHelloTv.setText("燃烧你的卡路里！");
        } else if (steps > 5000) {
            showHelloTv.setText("燃烧你的卡路里！");
        } else {
            showHelloTv.setText("燃烧你的卡路里！");
        }
    }


    public String setDataFormat(long time) {
        Date now = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd  HH:ss");
        String nowString = dateFormat.format(now);
        return nowString;
    }


    private void initview() {
        showHelloTv = (TextView) findViewById(R.id.show_hello_tv);
        showStepTv = (TextView) findViewById(R.id.show_step_tv);
        showTimeTv = (TextView) findViewById(R.id.show_time_tv);
        stepback = (ImageView) findViewById(R.id.stepbank_iv);
//        stepperson = (ImageView) findViewById(R.id.step_person);
        stepback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StepcounterActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        stepCounterSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
        sharedPreferences = getSharedPreferences("steps", MODE_PRIVATE);
    }

    public void saveTodaySteps(long steps, String time) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putLong("total", steps);
        editor.putString("time", time);
        editor.apply();
        Log.d("TAG-save", "saveTodaySteps: " + steps);
    }


    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == Sensor.TYPE_STEP_COUNTER) {
            currentSteps += (long) sensorEvent.values[0];
            String time = setDataFormat(System.currentTimeMillis());
            uiUpdate(currentSteps, time);
            saveTodaySteps(currentSteps, time);
            Log.d("TAG-sensor", "onSensorChanged: " + currentSteps);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}