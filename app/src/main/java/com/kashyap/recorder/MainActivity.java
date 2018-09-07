package com.kashyap.recorder;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.kashyap.recorder.ui.recorder.RecorderContract;
import com.kashyap.recorder.ui.recorder.RecorderFragment;
import com.kashyap.recorder.ui.recorder.RecorderPresenter;

public class MainActivity extends AppCompatActivity implements MainActivityCallBacks {

    public static Intent getIntent(Context context) {
        return new Intent(context, MainActivity.class);
    }

    public static Intent getIntentWithNewTask(Context context) {
        Intent intent = getIntent(context);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        flipToRecorder();

    }

    @Override
    public void flipToRecorder() {
        RecorderFragment fragment = RecorderFragment.getInstance(new Bundle());
        RecorderContract.View view = (RecorderContract.View) fragment;
        fragment.setPresenter(new RecorderPresenter(view));
    }

    @Override
    public void flipToSender() {

    }


}
