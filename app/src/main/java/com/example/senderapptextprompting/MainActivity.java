package com.example.senderapptextprompting;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnQRScanner = findViewById(R.id.scanQRCodeButton);

        btnQRScanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ScanQRCodeActivity.class);
                startActivity(intent);
            }
        });

    }

    public void startScrolling(View view) {
        // Send broadcast intent to start scrolling
        Intent intent = new Intent();
        intent.setAction("com.example.senderapptextprompting.ACTION_CONTROL_SCROLL");
        intent.putExtra("command", "start");
        sendBroadcast(intent);
    }

    public void stopScrolling(View view) {
        // Send broadcast intent to stop scrolling
        Intent intent = new Intent();
        intent.setAction("com.example.senderapptextprompting.ACTION_CONTROL_SCROLL");
        intent.putExtra("command", "stop");
        sendBroadcast(intent);
    }
}
