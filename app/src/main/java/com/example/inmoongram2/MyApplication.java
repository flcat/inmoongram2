package com.example.inmoongram2;

import android.app.Application;

import com.facebook.stetho.Stetho;
import com.facebook.stetho.okhttp3.StethoInterceptor;

import okhttp3.OkHttpClient;

public class MyApplication extends Application {
    public static OkHttpClient stethoInterceptingClient;
    @Override
    public void onCreate() {
        super.onCreate();
        if(BuildConfig.DEBUG) Stetho.initializeWithDefaults(this); //DEBUG 모드일때만 Stetho init
        stethoInterceptingClient = new OkHttpClient.Builder()
                .addNetworkInterceptor(new StethoInterceptor()) //Stetho Interceptor 를 추가해야 Chrome inspect tool 에서 확인 가능, 필수 아님
                .build();

    }
}
