package com.freakylab.iotivityble;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

@TargetApi(Build.VERSION_CODES.LOLLIPOP)
public class MainActivity extends AppCompatActivity {
    private Intent intent;
    private RestartService restartService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        unregisterReceiver(restartService);
    }

    private void initData() {
        restartService = new RestartService();
        intent = new Intent(MainActivity.this, LEService.class);

        IntentFilter intentFilter = new IntentFilter("com.freakylab.iotivityble.LEService");

        registerReceiver(restartService, intentFilter);

        startService(intent);
    }
}
