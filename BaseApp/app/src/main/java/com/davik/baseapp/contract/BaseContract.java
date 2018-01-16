package com.davik.baseapp.contract;


/**
 * Description：Base --- Contract
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
