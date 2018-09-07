package com.kashyap.recorder.ui.recorder;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.kashyap.recorder.BasePresenter;
import com.kashyap.recorder.MainActivityCallBacks;
import com.kashyap.recorder.R;
import com.kashyap.recorder.BaseFragment;

import butterknife.BindView;

public class RecorderFragment extends BaseFragment implements RecorderContract.View {

    @BindView(R.id.fragment_record_text_view_value)
    TextView mCounterTextView;
    private RecorderPresenter mPresenter;
    MainActivityCallBacks mActivityCallbacks;


    public static RecorderFragment getInstance(Bundle bundle) {
        //Create a new Instance.
        RecorderFragment fragment = new RecorderFragment();
        //To add bundle.
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
    public void initView() {


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
            mPresenter.startRecording();
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
