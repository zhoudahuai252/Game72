package com.myapp.game72;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.myapp.game72.base.BaseActivity;
import com.myapp.game72.common.widget.BottomMenu;
import com.myapp.game72.module.change.ui.ChiFragment;
import com.myapp.game72.module.event.ui.PengFragment;
import com.myapp.game72.module.gift.ui.LibaoFragment;
import com.myapp.game72.module.login.bean.LoginApiInfo;
import com.myapp.game72.module.me.ui.MeFragment;
import com.myapp.game72.module.money.ui.MoneyFragment;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends BaseActivity {
    BottomMenu mMenoyMenu;
    BottomMenu mLastMenu;
    Map<Integer, Fragment> mapFragments;//按钮资源id和对应fragment组成的map
    Fragment lastFragment;//当前显示的fragment
    private BottomMenu mMeMenu;
    private LoginApiInfo info;

    @Override
    protected int setViewId() {
        return R.layout.activity_main;
    }

    @Override
    protected void findViews() {
        mMenoyMenu = (BottomMenu) findViewById(R.id.moneymenu);
        mMeMenu = (BottomMenu) findViewById(R.id.memenu);
    }

    @Override
    protected void init() {
        mapFragments = new HashMap<>();
        Intent intent = getIntent();
        if (intent.getIntExtra("num", 0) == 0) {
            mMenoyMenu.performClick();//第一次进入页面时，默认选择第一个按钮
        } else {
            //得到登陆的信息
            info = intent.getParcelableExtra("info");
            //设置页面为我的页面
            mMeMenu.performClick();
        }
    }

    @Override
    protected void initEvents() {

    }

    @Override
    protected void loadData() {

    }

    public void onChoose(View view) {

        ((BottomMenu) view).onSelect();

        //把前面一个选择的按钮变成不选择
        if ((mLastMenu != null) && !(mLastMenu.equals(view))) {
            mLastMenu.onUnSelect();
        }
        mLastMenu = (BottomMenu) view;


        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        Fragment showFragment = null;//需要显示出来的fragment

        // 切换fragment
        if (mapFragments.containsKey(view.getId())) {//如果map中已经存在此fragment，把此fragment显示出来
            //并且隐藏前一个fragment
            if (lastFragment != null) {
                transaction.hide(lastFragment);
            }
            showFragment = mapFragments.get(view.getId());
            lastFragment = showFragment;
            transaction.show(showFragment);

        } else {//如果map里面没有此fragment，需要创建，然后add到activity中
            switch (view.getId()) {
                case R.id.moneymenu:
                    showFragment = new MoneyFragment();
                    break;
                case R.id.libaomenu:
                    showFragment = new LibaoFragment();
                    break;
                case R.id.pengmenu:
                    showFragment = new PengFragment();
                    break;
                case R.id.chimenu:
                    showFragment = new ChiFragment();
                    break;
                case R.id.memenu:
                    showFragment = new MeFragment();
                    break;
                default:
                    break;
            }
            transaction.add(R.id.rl_contner, showFragment);
            mapFragments.put(view.getId(), showFragment);
            if (lastFragment != null) {
                transaction.hide(lastFragment);
            }
            lastFragment = showFragment;

        }


        transaction.commit();
    }

}
