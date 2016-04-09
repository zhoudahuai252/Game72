package com.myapp.game72;

import android.app.Application;

import com.se7en.utils.SystemUtil;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        SystemUtil.setContext(this);
    }
}
