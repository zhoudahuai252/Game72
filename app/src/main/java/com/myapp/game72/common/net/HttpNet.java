package com.myapp.game72.common.net;

import android.os.Handler;
import android.util.Log;


import com.myapp.game72.base.NetCallback;
import com.myapp.game72.common.thread.ThreadTask;
import com.orhanobut.logger.Logger;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/**
 * Created by zhouyi on 16/3/28.
 */
public class HttpNet {

    private static Handler handler = new Handler();

    public static void doHttpRequest(final String strRequestMethod,
                                     final String strUrl,
                                     final Map<String, String> params,
                                     final NetCallback netCallback) {

        ThreadTask.getInstance().executorNetThread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL(strUrl);
                    HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

                    urlConnection.setRequestMethod(strRequestMethod);
                    urlConnection.connect();

                    OutputStream outputStream = urlConnection.getOutputStream();
                    StringBuffer sbParams = new StringBuffer();
                    for (Map.Entry<String, String> entry : params.entrySet()) {
                        sbParams.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
                    }
                    outputStream.write(sbParams.substring(0, sbParams.length()).getBytes());
                    outputStream.flush();

                    InputStream inputStream = urlConnection.getInputStream();

                    final String strResult = getResultString(inputStream);

                    if (strResult != null) {
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                Log.d("print","success");
                                netCallback.success(strResult);
                            }
                        });
                    } else {
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                netCallback.fail("网络访问失败");
                            }
                        });
                    }


                } catch (Exception e) {
                    e.printStackTrace();
                    final String strMsg = e.getMessage();
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            netCallback.fail(strMsg);
                        }
                    });

                }
            }
        }, ThreadTask.ThreadPeriod.PERIOD_HIGHT);

    }

    private static String getResultString(InputStream inputStream) {
        String strResult = null;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] bytes = new byte[1024];
        int len = -1;
        try {
            while ((len = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        strResult = new String(outputStream.toByteArray());

        return strResult;
    }


}
