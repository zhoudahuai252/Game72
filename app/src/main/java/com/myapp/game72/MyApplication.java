package com.myapp.game72;

import android.app.Application;

import com.lidroid.xutils.DbUtils;
import com.lidroid.xutils.HttpUtils;
import com.se7en.utils.SystemUtil;

public class MyApplication extends Application {
    public static DbUtils dbUtils;
    public static HttpUtils mHttpUtils;

    @Override
    public void onCreate() {
        super.onCreate();
        SystemUtil.setContext(this);
        dbUtils = DbUtils.create(this);
        mHttpUtils = new HttpUtils();
        configUtils();
    }

    /**
     * 给httputils配置各种参数
     */
    void configUtils() {
        //设置线程池数量
        mHttpUtils.configRequestThreadPoolSize(4);

        //设置请求重试次数
        mHttpUtils.configRequestRetryCount(3);

        //设置响应编码
        mHttpUtils.configResponseTextCharset("utf-8");

        //设置请求超时时间
        mHttpUtils.configTimeout(30000);

    }
}
