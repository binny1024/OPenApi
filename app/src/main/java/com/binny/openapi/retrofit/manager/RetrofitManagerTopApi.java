package com.binny.openapi.retrofit.manager;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.binny.openapi.constant.Constant.BASE_URL_Top_Api;

/**
 * author  binny
 * date 5/9
 */
public class RetrofitManagerTopApi {

    private static RetrofitManagerTopApi mRetrofitManager;
    private Retrofit mRetrofit;

    public static synchronized RetrofitManagerTopApi getInstance() {
        if (mRetrofitManager == null) {
            mRetrofitManager = new RetrofitManagerTopApi();
        }
        return mRetrofitManager;
    }

    private RetrofitManagerTopApi() {
        initRetrofit();
    }

    private void initRetrofit() {

        mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL_Top_Api)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    public <T> T createRetrofitService(Class<T> reqServer) {
        return mRetrofit.create(reqServer);
    }

}
