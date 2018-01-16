package com.davik.baseapp.ui.activity;

import com.davik.baseapp.R;
import com.davik.baseapp.contract.GuideContract;
import com.davik.baseapp.presenter.GuidePresenter;

public class GuideActivity extends BaseActivity<GuideActivity, GuidePresenter> implements GuideContract.IGuide {


    @Override
    protected int initContentView() {
        return R.layout.activity_guide;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected GuidePresenter createPresenter() {
        return new GuidePresenter();
    }
}
