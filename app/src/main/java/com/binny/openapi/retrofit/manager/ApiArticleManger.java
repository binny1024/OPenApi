package com.binny.openapi.retrofit.manager;

import com.binny.openapi.retrofit.server.IArticleService;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.binny.openapi.constant.Constant.ARTICLE_BASE_URL;

/**
 * author  binny
 * date 5/22
 */
public class ApiArticleManger {
    private static final ApiArticleManger ourInstance = new ApiArticleManger();
    private Retrofit mRetrofitArticleApi;

    public static ApiArticleManger getInstance() {
        return ourInstance;
    }

    private ApiArticleManger() {
        if (mRetrofitArticleApi == null) {
            mRetrofitArticleApi = new Retrofit.Builder()
                    .baseUrl(ARTICLE_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }
    }

    public IArticleService createArticleRetrofitService() {

        return mRetrofitArticleApi.create(IArticleService.class);
    }
}