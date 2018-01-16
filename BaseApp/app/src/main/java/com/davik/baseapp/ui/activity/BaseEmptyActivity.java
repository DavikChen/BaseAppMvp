package com.davik.baseapp.ui.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.WindowManager;

import com.davik.baseapp.R;
import com.davik.baseapp.ui.view.CustomProgress;
import com.davik.baseapp.utils.AppStackManager;
import com.davik.baseapp.utils.HLogUtil;

import butterknife.ButterKnife;


/**
 * @class describe 非MVP Activity 基类
 * @anthor davikchen
 * @time 2017/11/21 09:28
 */
public abstract class BaseEmptyActivity extends FragmentActivity {
    //全屏标志
    public static final int SCREEN_FULL = 0;
    //当前类名，打印使用
    private Class<? extends BaseEmptyActivity> mClassName = this.getClass();
    private CustomProgress progressDialog;

    //声明为final,不允许子类对该方法进行覆写已防止子类未调用super.initView()方法对view控件进行绑定
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置是否全屏，如果不全屏,设置状态栏颜色
        setScreenIsFull();
        //设置Layout
        setContentView(initContentView());
        //初始化Presenter
        ButterKnife.bind(this);
        initView();
        initData();
        //添加到Activity栈管理器
        AppStackManager.getAppStackManager().addActivity(this);
        HLogUtil.i(mClassName + " ----------> oncreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        HLogUtil.i(mClassName + " ----------> onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        HLogUtil.i(mClassName + " ----------> onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        HLogUtil.i(mClassName + " ----------> onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        HLogUtil.i(mClassName + " ----------> onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        hideProgressDialog();
        AppStackManager.getAppStackManager().removeOfStack(this);
        HLogUtil.i(mClassName + " ----------> onDestroy");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        if (outState != null) {
            String FRAGMENTS_TAG = "Android:support:fragments";
            outState.remove(FRAGMENTS_TAG);
        }
    }


    //设置是否是全屏，默认：notitlebar (FragmentActivity默认不带TitileBar)
    public int setFullScreen() {
        return -1;
    }

    protected abstract int initContentView();

    protected abstract void initView();

    protected abstract void initData();

    private void setScreenIsFull() {
        if (setFullScreen() == SCREEN_FULL) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
    }


    protected void showProgressDialog() {
        if (progressDialog == null) {
            progressDialog  = CustomProgress.getDialog(this, getString(R.string.loadding_prgressbar_hint), true, null);
        } else if (progressDialog.isShowing()) {
            progressDialog.setMessage(getString(R.string.loadding_prgressbar_hint));
        }
        progressDialog.show();
    }

    protected void hideProgressDialog() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
            progressDialog = null;
        }
    }

}
