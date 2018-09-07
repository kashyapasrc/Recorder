package com.kashyap.recorder.ui.recorder;

import com.kashyap.recorder.BasePresenter;
import com.kashyap.recorder.BaseView;

public interface RecorderContract {

    interface View extends BaseView {

        void updateUI(int value);



    }

    interface Presenter extends BasePresenter {
        void initCounter();

        void startCounter();

        void stopCounter();

        void initRecording();

        void saveRecording();

        void startRecording();

        void stopRecording();

        void pauseRecording();

        void resumeRecording();


    }
}
