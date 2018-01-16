package com.davik.baseapp.ui.fragment;


import android.os.Bundle;

import com.davik.baseapp.R;
import com.davik.baseapp.contract.HomeContract;
import com.davik.baseapp.presenter.HomePresenter;

/**
 * 主页
 * @author davikchen
 * @version 1.0.0
 * @time 2017/11/21 09:28
 */
public class HomeFragment extends BaseFragment<HomeFragment,HomePresenter> implements HomeContract.IHome{

    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * 设置根布局资源id
     */
    @Override
    protected int setLayoutResouceId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initData(Bundle arguments) {
        super.initData(arguments);
    }

    @Override
    protected void initView() {
        super.initView();
    }

    @Override
    protected HomePresenter createPresenter() {
        return new HomePresenter();
    }

}
