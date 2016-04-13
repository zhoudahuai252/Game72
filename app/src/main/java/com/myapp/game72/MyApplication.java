package com.myapp.game72;

import android.app.Application;

import com.lidroid.xutils.DbUtils;
import com.se7en.utils.SystemUtil;

public class MyApplication extends Application {
    public static DbUtils dbUtils;

    @Override
    public void onCreate() {
        super.onCreate();
        SystemUtil.setContext(this);
        dbUtils = DbUtils.create(this);
    }
}
