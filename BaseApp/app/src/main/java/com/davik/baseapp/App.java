package com.davik.baseapp;

import android.app.Application;
import android.content.Context;

/**
 * Description：
 */
public class App extends Application {

    //Context
    private static App mInstance;


    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }


    /**
     * 获取全局应用上下文
     * @return
     */
    public static Context getAppContext() {
        if (mInstance != null) {
            return mInstance;
        } else {
            mInstance = new App();
            mInstance.onCreate();
            return mInstance;
        }
    }
}
