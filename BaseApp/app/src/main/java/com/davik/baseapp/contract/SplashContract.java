package com.davik.baseapp.contract;

/**
 * Description：
 */
public interface SplashContract {

    interface  ISplashPresenter extends BaseContract.IBasePresenter{
        void isAppFirstRun();
    }

    interface  ISplash extends BaseContract.IBase {

        void goHome();

        void goGuide();
    }
}
