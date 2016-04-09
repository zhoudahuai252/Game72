package com.myapp.game72.module.money.dao;

import com.google.gson.Gson;
import com.myapp.game72.base.NetCallback;
import com.myapp.game72.common.constant.Constant;
import com.myapp.game72.common.net.HttpNet;
import com.myapp.game72.module.money.bean.MoneyData;
import com.orhanobut.logger.Logger;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MoneyDao {
    /**
     * 获取网络数据
     */
    public static void getMoneyData(String strPage, final MoneyCallback callback) {
        String strRequestMethod = "POST";//实用post方法
        String strUrl = Constant.MONEY_URL;//赚钱接口
        Map<String, String> params = new HashMap<>();
        params.put("platform", "2");//安卓接口
        params.put("page", strPage);//页数
        HttpNet.doHttpRequest(strRequestMethod, strUrl, params, new NetCallback() {
            @Override
            public void success(String strResult) {
                MoneyData moneyData = new Gson().
                        fromJson(strResult, MoneyData.class);
                callback.callback(moneyData);
//                Logger.json(strResult);
            }

            @Override
            public void fail(String message) {
                Logger.d(message);
            }
        });

    }

    public interface MoneyCallback {
        void callback(MoneyData moneyData);
    }

    public static ApiService getRefoit() {
        return new Retrofit.Builder()
                .baseUrl(Constant.GAME_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build()
                .create(ApiService.class);
    }
}
