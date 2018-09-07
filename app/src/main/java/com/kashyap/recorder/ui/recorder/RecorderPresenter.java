package com.kashyap.recorder.ui.recorder;


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
                mCounterHandler.postDelayed(this, 500);
            }
        }, 1000);
    }

    @Override
    public void stopCounter() {

    }

    @Override
    public void initRecording() {

    }

    @Override
    public void saveRecording() {

    }

    @Override
    public void startRecording() {

    }

    @Override
    public void stopRecording() {

    }

    @Override
    public void pauseRecording() {

    }

    @Override
    public void resumeRecording() {

    }
}
