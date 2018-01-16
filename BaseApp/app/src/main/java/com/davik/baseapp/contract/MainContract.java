package com.davik.baseapp.contract;


public interface MainContract {

    interface  IMainPresenter extends BaseContract.IBasePresenter{
        /**
         * 选中导航栏
         * @param position 导航栏位置
         */
        void choiceTab(int position);
    }

    interface  IMain extends BaseContract.IBase {
        void hideFragments();
        void showTabByPosition(int position);
    }
}
