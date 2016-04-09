package com.myapp.game72.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class BaseFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(setViewId(), container, false);
        findViews(view);
        init();
        initEvents();
        loadData();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    /**
     * 设置layout的资源ID
     *
     * @return
     */
    protected abstract int setViewId();


    /**
     * 查找控件
     *
     * @param view
     */
    protected abstract void findViews(View view);

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
