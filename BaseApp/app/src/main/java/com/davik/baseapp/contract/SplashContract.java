package com.davik.baseapp.contract;

/**
 * @class describe  APP欢迎页面契约
 * @anthor davikchen
 * @time 2017/11/21 09:28
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
