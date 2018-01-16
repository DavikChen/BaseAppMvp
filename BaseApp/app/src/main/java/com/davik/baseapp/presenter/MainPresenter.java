package com.davik.baseapp.presenter;

import com.davik.baseapp.contract.MainContract;
import com.davik.baseapp.ui.activity.MainActivity;

/**
 * Description：
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
