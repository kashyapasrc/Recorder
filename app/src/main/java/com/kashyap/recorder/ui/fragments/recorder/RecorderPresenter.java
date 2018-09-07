package com.kashyap.recorder.ui.fragments.recorder;


import android.os.Handler;

public class RecorderPresenter implements RecorderContract.Presenter {


    private RecorderContract.View mView;
    private int mCounter = 0;
    private Handler mCounterHandler = null;

    public RecorderPresenter(RecorderContract.View view) {
        this.mView = view;
    }

    @Override
    public void initCounter() {
        mCounter = 0;
    }

    @Override
    public void startCounter() {
        mCounterHandler = new Handler();
        mCounterHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mView.updateUI(++mCounter);
                mCounterHandler.postDelayed(this, 1000);
            }
        }, 1000);
    }




}
