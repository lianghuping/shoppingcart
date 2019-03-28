package com.bwie.shoppingcart.home.mvp.util;

import com.bwie.shoppingcart.home.mvp.api.Api;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitUtil {

    private static RetrofitUtil retrofitUtil;
    private Retrofit retrofit;


    public static RetrofitUtil getInstance(){
        if(retrofitUtil ==null){
            synchronized (RetrofitUtil.class){
                if(retrofitUtil ==null){
                    retrofitUtil = new RetrofitUtil();
                }
            }
        }
        return retrofitUtil;

    }

    private RetrofitUtil(){

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .addNetworkInterceptor(interceptor)
                .build();

        retrofit = new Retrofit.Builder()
                .baseUrl(Api.urlString)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();





    }


    public<T> T create(Class<T>  tClass){

        return retrofit.create(tClass);

    }











}
