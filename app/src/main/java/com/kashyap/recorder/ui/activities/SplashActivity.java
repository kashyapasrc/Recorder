package com.kashyap.recorder.ui.activities;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.intentfilter.androidpermissions.PermissionManager;
import com.kashyap.recorder.R;
import com.kashyap.recorder.utils.DisplayMessage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SplashActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                navigateToMainActivity();
            }
        }, 1000);
    }


    private void navigateToMainActivity() {
        Intent intent = MainActivity.getIntentWithNewTask(this);
        startActivity(intent);
        finish();
    }
}
