package com.example.day1.text;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RetrofitFactory  {
    private static RetrofitFactory retrofitFactory = null;

    private Retrofit retrofit = null;
    private RetrofitFactory() {
    }

    public synchronized static RetrofitFactory getRetrofitFactory() {
        if(retrofitFactory == null){
            return new RetrofitFactory();
        }
        return retrofitFactory;
    }

    public synchronized  <T> T create(Class<T> apiClass){
        if(retrofit == null){
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl("http://www.qubaobei.com/")
                    .client(new OkHttpClient().newBuilder()
                            .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                            .build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(new LiveDataCallAdapterFactory())
                    .build();

        }
        return retrofit.create(apiClass);
    }
}
