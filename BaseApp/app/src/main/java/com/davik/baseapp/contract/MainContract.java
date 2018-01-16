package com.davik.baseapp.contract;


/**
 * @class describe  APP主页契约
 * @anthor davikchen
 * @time 2017/11/21 09:28
 */
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
