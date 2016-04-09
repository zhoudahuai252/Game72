package com.myapp.game72.module.money.dao;

import com.myapp.game72.module.login.bean.LoginApiInfo;
import com.myapp.game72.module.money.bean.MoneyDetailBean;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

public interface ApiService {

//    @POST("/app_api/prize_list/")
//    Observable<GiftBean> getGiftInfo(@Body Reinfo reinfo);

    @FormUrlEncoded
    @POST("/app/game/game_info/")
    Observable<MoneyDetailBean> getDetailData(@Field("id") String id);


//    Observable<LoginApiInfo> getLoginInfo(@Field( ));
}
