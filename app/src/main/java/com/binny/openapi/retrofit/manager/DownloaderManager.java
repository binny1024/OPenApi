package com.binny.openapi.retrofit.manager;

import com.binny.openapi.retrofit.server.IDownLoader;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

/**
 * Created by binny on 2018/6/5.
 *
 */

public class DownloaderManager {

    private Retrofit mRetrofit;

    public DownloaderManager(String baseUrl) {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public IDownLoader getRetrofit() {
        return mRetrofit.create(IDownLoader.class);
    }
}