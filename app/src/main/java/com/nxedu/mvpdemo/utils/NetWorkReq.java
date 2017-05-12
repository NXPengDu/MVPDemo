package com.nxedu.mvpdemo.utils;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * @author dupeng
 * @version 1.0.0
 * @since 2017/5/5 20:40
 */

public class NetWorkReq {
    private static final String BASE_URL_DEBUG = "http://192.168.2.208:8080/lfd/";
    private static NetWorkService service;
    OkHttpClient.Builder builder;

    public static NetWorkService getService() {
        if(service == null) {
            Retrofit requestRetrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL_DEBUG)
                    //增加返回值为String的支持
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .build();
            service = requestRetrofit.create(NetWorkService.class);
        }
        return service;
    }
}
