package com.myapp.game72.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setViewId());
        findViews();
        init();
        initEvents();
        loadData();
    }



    /**
     * 设置layout的资源ID
     *
     * @return
     */
    protected abstract int setViewId();

    /**
     * 查找控件
     */
    protected abstract void findViews();

    /**
     * 初始化
     */
    protected abstract void init();

    /**
     * 对控件设置监听
     */
    protected abstract void initEvents();

    /**
     * 加载数据
     */
    protected abstract void loadData();
}
