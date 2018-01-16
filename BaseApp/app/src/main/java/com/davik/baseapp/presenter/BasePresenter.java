package com.davik.baseapp.presenter;


import com.davik.baseapp.contract.BaseContract;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/**
 * @class describe 对Activity进行弱引用处理的BasePresenter
 * @anthor davikchen
 * @time 2017/11/21 09:28
 */
public abstract class BasePresenter<V extends BaseContract.IBase> implements BaseContract.IBasePresenter{
    protected Reference<V> mViewRef;

    //建立关联
    public void attachView(V view) {
        mViewRef = new WeakReference<V>(view);
    }

    //获取view
    protected V getView() {
        return mViewRef.get();
    }

    //判断是否与View建立了关联
    public boolean isViewAttached() {
        return mViewRef != null && mViewRef.get() != null;
    }

    //该方法在activity或者Fragment的onDestory中调用
    public void detachView() {
        if (mViewRef != null) {
            mViewRef.clear();
            mViewRef = null;
        }
    }
}
