package com.example.zhoule.barragedemo.http;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by zhoule on 2018/7/11.
 */

public class HttpUtils {

    private static HttpUtils httpUtils;

    public static HttpUtils getInstance() {
        synchronized (HttpUtils.class) {
            if (httpUtils == null) {
                httpUtils = new HttpUtils();
            }
        }
        return httpUtils;
    }


    public HttpAPI API() {
        HttpAPI httpAPI = init().create(HttpAPI.class);
        return httpAPI;
    }


    private Retrofit init() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://198.13.40.26:8080/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;
    }
}
