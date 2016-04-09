package com.myapp.game72.module.login.dao;

import android.support.annotation.NonNull;
import android.util.Log;

import com.myapp.game72.common.constant.Constant;
import com.myapp.game72.module.login.apiinfo.ApiService;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginDao {

    @NonNull
    public static ApiService getRetrofit() {
        Log.d("LoginDao", "getRetrofit");
        return new Retrofit.Builder()
                .baseUrl(Constant.LOGIN_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build()
                .create(ApiService.class);
    }

}
