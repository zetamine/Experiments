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
        Layout(); // initializes the TextViews
        this.account = new Account(1001); //Creates a new account and passes an ID to the account

        //SensorManager needs an instance to start pulling sensor readings.
        SensorManager senManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        //Creates an instance of the Acceleration class which will begin recording accelerometer data.
        acceleration = new Acceleration(senManager, this.accelDisp, this.maxAccelDisp);
    }

    /**
     * Initializes the Views in the app.
     */
    public void Layout() {
        this.accelDisp = (TextView) findViewById(R.id.accelerationView);
        this.logDisp = (TextView) findViewById(R.id.logView);
        this.maxAccelDisp = (TextView) findViewById(R.id.maxAccelView);
    }

    /**
     * Records a punch when the record button is pressed
     * @param view
     */
    public void record(View view) {
        this.account.newRecord(this.acceleration.getMaxAcceleration()); // records a new punch
        this.logDisp.setText(this.account.toString()); //displays the punch in the view
        this.acceleration.resetMaxAcceleration(); //resets the max acceleration view
    }

    /**
     * Clears the history of punches
     * @param view
     */
    public void clear(View view) {
        this.account.clear(); // clears all punch data
        this.logDisp.setText(this.account.toString()); // displays empty log
    }
}