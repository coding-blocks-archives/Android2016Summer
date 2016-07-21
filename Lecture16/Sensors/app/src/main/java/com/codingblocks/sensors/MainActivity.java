package com.codingblocks.sensors;

import android.content.Context;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorEventListener2;
import android.hardware.SensorManager;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    public static final String TAG = "MainAct";

    SensorManager sensorManager;
    long prevTimestamp = 0;

    RelativeLayout background;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        background = (RelativeLayout) findViewById(R.id.background);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        Sensor accelSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(this, accelSensor, SensorManager.SENSOR_DELAY_UI);





    }

    @Override
    public void onSensorChanged(SensorEvent event) {

//        if (prevTimestamp == 0) prevTimestamp = event.timestamp;
//
//        if (event.timestamp > (prevTimestamp + (1000 * 1000 * 1000))) {
//            prevTimestamp = event.timestamp;
//
//        }
        if (background != null) {
//            setColor(event.values[0], event.values[1], event.values[2], background);
            letsDisco(event.values[0], event.values[1], event.values[2], background);
        }


    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        Log.d(TAG, "onAccuracyChanged: sensor = " + sensor.getName()
                + " accuracy = " + accuracy);

    }

    private void setColor (float accX, float accY, float accZ, View v) {
        if (accX > 3) {
            v.setBackgroundColor(Color.GREEN);
        } else if (accX < -3) {
            v.setBackgroundColor(Color.RED);
        } else {
            v.setBackgroundColor(Color.YELLOW);
        }
    }

    private void letsDisco (float accX, float accY, float accZ, View v) {
        int red = gravity2color(accX);
        int green = gravity2color(accY);
        int blue = gravity2color(accZ);

        v.setBackgroundColor(Color.argb(255, red, green, blue));
    }

    private int gravity2color (float gravity) {
        return (int) (((gravity + 10) / 20) * 255);
    }
}
