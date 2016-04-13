package com.myapp.game72.module.gift.dao;

import com.google.gson.Gson;
import com.myapp.game72.base.NetCallback;
import com.myapp.game72.common.constant.Constant;
import com.myapp.game72.common.net.HttpNet;
import com.myapp.game72.module.gift.bean.GiftBean;
import com.orhanobut.logger.Logger;

import java.util.HashMap;
import java.util.Map;

public class GiftDao {
    /**
     * 获取网络数据
     */
    public static void getGiftData(String strPage,String strType,final GiftCallBack callback) {
        String strRequestMethod = "POST";//实用post方法
        String strUrl = Constant.GIFT_URL;//兑换礼物接口接口
        Map<String, String> params = new HashMap<>();
        params.put("type", strType);//接口类型
        params.put("page", strPage);//页数
        HttpNet.doHttpRequest(strRequestMethod, strUrl, params, new NetCallback() {
            @Override
            public void success(String strResult) {
                GiftBean giftBean = new Gson().
                        fromJson(strResult, GiftBean.class);
                callback.call(giftBean);
//                Logger.json(strResult);
            }

            @Override
            public void fail(String message) {
                Logger.d(message);
            }
        });

    }
    public interface GiftCallBack{
        void call(GiftBean giftBean);
    }
}
