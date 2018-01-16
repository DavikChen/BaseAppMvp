package com.davik.baseapp.presenter;

import com.davik.baseapp.contract.SplashContract;
import com.davik.baseapp.ui.activity.SplashActivity;
import com.davik.baseapp.utils.SharedPrefsUtil;

/**
 * @class describe  启动页面控制器
 * @anthor davikchen
 * @time 2017/11/21 09:28
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
