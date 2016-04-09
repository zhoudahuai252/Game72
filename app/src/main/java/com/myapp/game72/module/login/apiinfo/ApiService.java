package com.myapp.game72.module.login.apiinfo;

import com.myapp.game72.module.login.bean.LoginApiInfo;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

public interface ApiService {

//    @POST("/app_api/prize_list/")
//    Observable<GiftBean> getGiftInfo(@Body Reinfo reinfo);

    @FormUrlEncoded
    @POST("/app_api/app_login")
    Observable<LoginApiInfo> getGiftData(@Field("username") String username,
                                     @Field("password") String pwd);


//    Observable<LoginApiInfo> getLoginInfo(@Field( ));
}
