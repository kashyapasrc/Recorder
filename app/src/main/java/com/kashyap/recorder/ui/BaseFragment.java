package com.kashyap.recorder.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

abstract public class BaseFragment extends Fragment {

    protected Unbinder mUnBinder;

    public abstract int layoutId();

    public abstract void initButterKnife();


    private View mRootView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(layoutId(), container, false);
        initButterKnife();
        return mRootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    public View getRootView() {
        return mRootView;
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mUnBinder != null)
            mUnBinder.unbind();
    }
}
