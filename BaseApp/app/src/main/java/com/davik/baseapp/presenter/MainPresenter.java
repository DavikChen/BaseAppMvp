package com.davik.baseapp.presenter;

import com.davik.baseapp.contract.MainContract;
import com.davik.baseapp.ui.activity.MainActivity;

/**
 * @class describe  APP主页控制器
 * @anthor davikchen
 * @time 2017/11/21 09:28
 */
public class MainPresenter extends BasePresenter<MainActivity> implements MainContract.IMainPresenter {


    /**
     * 选中导航栏
     *
     * @param position 导航栏位置
     */
    @Override
    public void choiceTab(int position) {
        getView().showTabByPosition(position);
    }
}
