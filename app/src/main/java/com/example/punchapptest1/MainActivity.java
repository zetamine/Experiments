package com.example.punchapptest1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.punchapptest1.data.Acceleration;
import com.example.punchapptest1.data.Account;

public class MainActivity extends AppCompatActivity {
    private TextView accelDisp; // This displays the linear acceleration from the sensor
    private TextView maxAccelDisp; // This displays the max acceleration.
    private TextView logDisp; // This displays the history of punches
    private Button clearBut; // This appears in the layout but is not defined in this class
    private Button recordBut; // same as clearBut.

    private Account account; // Account class that holds all recorded punches
    private Acceleration acceleration; // Class to take acceleration data

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Layout();
        this.account = new Account(1001);

        SensorManager senManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        acceleration = new Acceleration(senManager, this.accelDisp, this.maxAccelDisp);
    }

    public void Layout() {
        this.accelDisp = (TextView) findViewById(R.id.accelerationView);
        this.logDisp = (TextView) findViewById(R.id.logView);
        this.maxAccelDisp = (TextView) findViewById(R.id.maxAccelView);
    }

    public void record(View view) {
        this.account.newRecord(this.acceleration.getMaxAcceleration());
        this.logDisp.setText(this.account.toString());
        this.acceleration.resetMaxAcceleration();
    }

    public void clear(View view) {
        this.account.clear();
        this.logDisp.setText(this.account.toString());
    }
}