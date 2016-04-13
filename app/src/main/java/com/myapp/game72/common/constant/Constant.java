package com.myapp.game72.common.constant;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;

public class Constant {
    public static final String VERSION_STRING = "APP_VERSION";
    public static final String MONEY_URL = " http://zhushou.72g.com/app/game/game_list/";
    public static final String GIFT_URL = "http://www.yuu1.com/app_api/prize_list/";//兑换礼物接口接口
    public static final String LOGIN_URL = "http://www.yuu1.com";

    public static final String IS_LOGIN = "isLogin";
    public static final String GAME_BASE = "http://zhushou.72g.com";
    public static final String APP_CARE = "";
    public static final String LOGIN_CARE_NAME = "loginInfo.obj";

    // 检测网络
    public static boolean checkNetworkAvailable(Context context) {
        ConnectivityManager connectivity = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity == null) {
            return false;
        } else {
            NetworkInfo[] info = connectivity.getAllNetworkInfo();
            if (info != null) {
                for (int i = 0; i < info.length; i++) {
                    if (info[i].getState() == NetworkInfo.State.CONNECTED) {
                        NetworkInfo netWorkInfo = info[i];
                        if (netWorkInfo.getType() == ConnectivityManager.TYPE_WIFI) {
                            return true;
                        } else if (netWorkInfo.getType() == ConnectivityManager.TYPE_MOBILE) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
