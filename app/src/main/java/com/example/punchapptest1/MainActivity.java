package com.example.punchapptest1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.punchapptest1.data.Acceleration;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private TextView accelDisp;
    private TextView logDisp;
    private TextView maxAccelDisp;
    private Button clearBut;
    private Button recordBut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Layout();

        SensorManager senManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        Acceleration acceleration = new Acceleration(senManager, this.accelDisp);
    }

    public void Layout() {
        this.accelDisp = (TextView) findViewById(R.id.accelerationView);
        this.logDisp = (TextView) findViewById(R.id.logView);
        this.maxAccelDisp = (TextView) findViewById(R.id.maxAccelView);
    }
}