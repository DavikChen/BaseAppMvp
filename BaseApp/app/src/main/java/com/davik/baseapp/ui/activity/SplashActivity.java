package com.davik.baseapp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

import com.davik.baseapp.R;
import com.davik.baseapp.contract.SplashContract;
import com.davik.baseapp.presenter.SplashPresenter;

import butterknife.BindView;
import butterknife.OnClick;

public class SplashActivity extends BaseActivity<SplashActivity, SplashPresenter> implements SplashContract.ISplash {


    @BindView(R.id.timer_tv) TextView mTimerTv;
    private String mTimeHint;
    private byte mTimeLeft;
    private CountDownTimer mCountDownTimer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!isTaskRoot()) {
            finish();
            return;
        }


    }

    @Override
    protected int initContentView() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        if (!isTaskRoot()) {
            return;
        }
        mTimeHint = getResources().getString(R.string.timer_seconds);
        mCountDownTimer = new CountDownTimer(4000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimeLeft = (byte) (millisUntilFinished / 1000);
                mTimerTv.setText(String.format(mTimeHint, mTimeLeft));
            }

            @Override
            public void onFinish() {
                mTimeLeft = 0;
                mTimerTv.setText(String.format(mTimeHint, mTimeLeft));
                mPresenter.isAppFirstRun();
            }
        };
        mCountDownTimer.start();
    }

    @Override
    protected SplashPresenter createPresenter() {
        return new SplashPresenter();
    }

    @OnClick(R.id.timer_tv)
    public void onClick() {
        mCountDownTimer.cancel();
        mPresenter.isAppFirstRun();
    }

    @Override
    public void goHome() {
        Intent mIntent = new Intent();
        mIntent.setClass(this,MainActivity.class);
        startActivity(mIntent);
        finish();
    }

    @Override
    public void goGuide() {
        Intent mIntent = new Intent();
        mIntent.setClass(this,MainActivity.class);
        startActivity(mIntent);
        finish();
    }
}
