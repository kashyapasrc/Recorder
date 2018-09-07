package com.kashyap.recorder.ui.fragments.recorder;

import com.kashyap.recorder.ui.BasePresenter;
import com.kashyap.recorder.ui.BaseView;

public interface RecorderContract {

    interface View extends BaseView {

        void updateUI(int value);



    }

    interface Presenter extends BasePresenter {
        void initCounter();

        void startCounter();



    }
}
