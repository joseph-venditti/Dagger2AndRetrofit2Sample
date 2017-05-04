package com.tetraandroid.retrofitexample.network;

import android.util.Log;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by jvenditti on 2017-05-03.
 */

@Module
public class OkHttpModule {

    private static final String TAG = OkHttpModule.class.getSimpleName();

    @Provides
    @Named("ok_http_client")
    public OkHttpClient provideClient() {
        Log.d(TAG, "provideClient");
        return new OkHttpClient.Builder().build();
    }

    @Provides
    @Named("ok_http_client_logging")
    public OkHttpClient provideClientLogging() {
        Log.d(TAG, "provideClientLogging");
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return new OkHttpClient.Builder().addInterceptor(interceptor).build();
    }
}
