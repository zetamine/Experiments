package com.example.punchapptest1.data;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Acceleration implements SensorEventListener {
    private Double maxAcceleration = 0.0;
    private SensorManager senManager;
    private double acceleration = 0;
    private Sensor sen;
    private TextView view;
    String pattern = "##.####";
    DecimalFormat format = new DecimalFormat(pattern);

    public Acceleration(SensorManager manager, TextView view) {
        this.senManager = manager;
        assert senManager != null;
        sen = senManager.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION);
        senManager.registerListener(this, sen, SensorManager.SENSOR_DELAY_NORMAL);
        this.view = view;
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        Double linAcceleration;

        float x = event.values[0];
        float y = event.values[1];
        float z = event.values[2];

        linAcceleration = Math.sqrt(x * x + y * y + z * z);
        this.acceleration = linAcceleration;

        // updates to a new maxAcceleration is newer value is larger
        if (this.maxAcceleration < linAcceleration)
            this.maxAcceleration = linAcceleration;

        this.view.setText(format.format(this.maxAcceleration));
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    public double getMaxAcceleration() {
        return maxAcceleration;
    }
}
