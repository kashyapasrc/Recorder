package com.kashyap.recorder.ui;

import android.app.Activity;
import android.content.Context;

public interface BaseView<Presenter extends BasePresenter> {

    void setPresenter(Presenter presenter);

    Context getCurrentFragmentContext();

    Activity getCurrentFragmentActivity();

}
