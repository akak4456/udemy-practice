package com.androidtutz.anushka.tmdbclient.service;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by K. A. ANUSHKA MADUSANKA on 7/9/2018.
 */
public class RetrofitInstance {

    private static Retrofit retrofit = null;
    private static String BASE_URL="https://api.themoviedb.org/3/";

    public static MovieDataService getService(){


        if(retrofit==null){

               retrofit=new Retrofit
                       .Builder()
                       .baseUrl(BASE_URL)
                       .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                       .addConverterFactory(GsonConverterFactory.create())
                       .build();

        }

        return retrofit.create(MovieDataService.class);

    }

}
