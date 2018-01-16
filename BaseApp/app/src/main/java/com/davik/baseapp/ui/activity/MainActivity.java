package com.davik.baseapp.ui.activity;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.davik.baseapp.R;
import com.davik.baseapp.contract.MainContract;
import com.davik.baseapp.presenter.MainPresenter;
import com.davik.baseapp.ui.fragment.HomeFragment;
import com.davik.baseapp.utils.AppStackManager;
import com.davik.baseapp.utils.ExitUtils;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * APP主导航页面
 */
public class MainActivity extends BaseActivity<MainActivity, MainPresenter> implements MainContract.IMain {

    private HomeFragment home1Fragment;
    private HomeFragment home2Fragment;
    private HomeFragment home3Fragment;
    private HomeFragment home4Fragment;

    private final static String FRAGMENT_TAG_ONE = "fragment_tag_one";
    private final static String FRAGMENT_TAG_TWO = "fragment_tag_two";
    private final static String FRAGMENT_TAG_THREE = "fragment_tag_three";
    private final static String FRAGMENT_TAG_FOUR = "fragment_tag_four";


    public final static int FRAGMENT_FLAG_ONE = 0;
    public final static int FRAGMENT_FLAG_TWO = 1;
    public final static int FRAGMENT_FLAG_THREE = 2;
    public final static int FRAGMENT_FLAG_FOUR = 3;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    private RadioButton button;
    @BindView(R.id.rgBottom)
    RadioGroup rgBottom;


    @Override
    protected int initContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        fragmentManager = this.getSupportFragmentManager();
        // 默认选中主页
        mPresenter.choiceTab(FRAGMENT_FLAG_ONE);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected MainPresenter createPresenter() {
        return new MainPresenter();
    }

    @OnClick(R.id.rbTabOne)
    void onClickTabOne() {
        mPresenter.choiceTab(FRAGMENT_FLAG_ONE);
    }


    @OnClick(R.id.rbTabTwo)
    void onClickTabTwo() {
        mPresenter.choiceTab(FRAGMENT_FLAG_TWO);
    }

    @OnClick(R.id.rbTabThree)
    void onClickTabThree() {
        mPresenter.choiceTab(FRAGMENT_FLAG_THREE);
    }

    @OnClick(R.id.rbTabFour)
    void onClickTabFour() {
        mPresenter.choiceTab(FRAGMENT_FLAG_FOUR);
    }

    @Override
    public void hideFragments() {
        if (fragmentManager.findFragmentByTag(FRAGMENT_TAG_ONE) != null) {
            if (home1Fragment == null) {
                home1Fragment = (HomeFragment) fragmentManager.findFragmentByTag(FRAGMENT_TAG_ONE);
            }
            fragmentTransaction.hide(home1Fragment);
        }

        if (fragmentManager.findFragmentByTag(FRAGMENT_TAG_TWO) != null) {
            if (home2Fragment == null) {
                home2Fragment = (HomeFragment) fragmentManager.findFragmentByTag(FRAGMENT_TAG_TWO);
            }
            fragmentTransaction.hide(home2Fragment);
        }



        if (fragmentManager.findFragmentByTag(FRAGMENT_TAG_THREE) != null) {
            if (home3Fragment == null) {
                home3Fragment = (HomeFragment) fragmentManager.findFragmentByTag(FRAGMENT_TAG_THREE);
            }
            fragmentTransaction.hide(home3Fragment);
        }


        if (fragmentManager.findFragmentByTag(FRAGMENT_TAG_FOUR) != null) {
            if (home4Fragment == null) {
                home4Fragment = (HomeFragment) fragmentManager.findFragmentByTag(FRAGMENT_TAG_FOUR);
            }
            fragmentTransaction.hide(home4Fragment);
        }
    }

    @Override
    public void showTabByPosition(int position) {
        fragmentTransaction = fragmentManager.beginTransaction();
        hideFragments();
        switch (position) {
            case FRAGMENT_FLAG_ONE: // 主页
                if (home1Fragment == null) {
                    home1Fragment = HomeFragment.newInstance();
                    fragmentTransaction.add(R.id.container, home1Fragment, FRAGMENT_TAG_ONE);
                } else {
                    fragmentTransaction.show(home1Fragment);
                }
                break;
            case FRAGMENT_FLAG_TWO: // 监测
                if (home2Fragment == null) {
                    home2Fragment = HomeFragment.newInstance();
                    fragmentTransaction.add(R.id.container, home2Fragment, FRAGMENT_TAG_TWO);
                } else {
                    fragmentTransaction.show(home2Fragment);
                }
                break;

            case FRAGMENT_FLAG_THREE: //  监控
                if (home3Fragment == null) {
                    home3Fragment = HomeFragment.newInstance();
                    fragmentTransaction.add(R.id.container, home3Fragment, FRAGMENT_TAG_THREE);
                } else {
                    fragmentTransaction.show(home3Fragment);
                }

                break;
            case FRAGMENT_FLAG_FOUR: // 我的
                if (home4Fragment == null) {
                    home4Fragment = HomeFragment.newInstance();
                    fragmentTransaction.add(R.id.container, home4Fragment, FRAGMENT_TAG_FOUR);
                } else {
                    fragmentTransaction.show(home4Fragment);
                }

                break;

        }

        fragmentTransaction.commitAllowingStateLoss();
        if (rgBottom != null && rgBottom.getChildCount() > 0) {
            button = (RadioButton) rgBottom.getChildAt(position);
            button.setChecked(true);
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            // 判断是否需要退客户端逻辑
            if (ExitUtils.getInstance().isExit(this)) {
                // 单次用户 弹出红包标识
                AppStackManager.getAppStackManager().AppExit();
                finish();
            }
        }
        return false;
    }
}
