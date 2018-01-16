package com.davik.baseapp.contract;


/**
 * @class describe  契约基类
 * @anthor davikchen
 * @time 2017/11/21 09:28
 */
public interface BaseContract {
    interface  IBasePresenter {

    }

    interface  IBase {

        //显示带ProgressBar的Dialog
        void showProgressDialog();


        //隐藏弹出的Dialog
        void hideProgressDialog();
    }
}
