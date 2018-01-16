package com.davik.baseapp.presenter;

import com.davik.baseapp.contract.SplashContract;
import com.davik.baseapp.ui.activity.SplashActivity;
import com.davik.baseapp.utils.SharedPrefsUtil;

/**
 * Description：
 */
public class SplashPresenter extends BasePresenter<SplashActivity> implements SplashContract.ISplashPresenter {

    @Override
    public void isAppFirstRun() {
        boolean isFirstRun = SharedPrefsUtil.getValue(getView(), "isFirstRun","isFirstRun", true);
        if (isFirstRun) {
            SharedPrefsUtil.putValue(getView(),"isFirstRun", "isFirstRun", false);
            getView().goHome();
        } else {
            getView().goHome();
        }
    }
}
