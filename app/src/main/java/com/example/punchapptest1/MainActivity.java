package com.example.punchapptest1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private TextView accelDisp;
    private TextView logDisp;
    private Button clearBut;
    private Button recordBut;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Layout();
    }

    public void Layout() {
        accelDisp = (TextView)findViewById(R.id.accelerationView);
        logDisp = (TextView)findViewById(R.id.logView);
    }
}