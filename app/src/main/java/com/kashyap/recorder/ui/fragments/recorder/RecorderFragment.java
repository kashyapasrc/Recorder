package com.kashyap.recorder.ui.fragments.recorder;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.kashyap.recorder.ui.BasePresenter;
import com.kashyap.recorder.ui.MainActivityCallBacks;
import com.kashyap.recorder.R;
import com.kashyap.recorder.ui.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecorderFragment extends BaseFragment implements RecorderContract.View {

    @BindView(R.id.fragment_record_text_view_value)
    TextView mCounterTextView;
    private RecorderPresenter mPresenter;
    MainActivityCallBacks mActivityCallbacks;


    public static RecorderFragment getInstance(Bundle bundle) {
        RecorderFragment fragment = new RecorderFragment();
        fragment.setArguments(bundle);
        return fragment;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        onAttached(context);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        onAttached(activity);
    }

    private void onAttached(Context context) {
        try {
            mActivityCallbacks = (MainActivityCallBacks) context;
        } catch (ClassCastException ignored) {
            throw new RuntimeException(context.getClass().getSimpleName() + " must implements MainActivityCallBacks");
        }
    }


    @Override
    public int layoutId() {
        return R.layout.fragment_record;
    }


    @Override
    public void initButterKnife() {
        mUnBinder = ButterKnife.bind(this, getRootView());
    }

    @Override
    public void setPresenter(BasePresenter presenter) {
        this.mPresenter = (RecorderPresenter) presenter;
    }

    @Override
    public Context getCurrentFragmentContext() {
        return getContext();
    }

    @Override
    public Activity getCurrentFragmentActivity() {
        return getActivity();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (mPresenter != null) {
            mPresenter.initCounter();
            mPresenter.startCounter();
        }
    }

    @Override
    public void updateUI(final int value) {
        if (getActivity() != null) {
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    mCounterTextView.setText(String.valueOf(value));
                }
            });
        }
    }
}
