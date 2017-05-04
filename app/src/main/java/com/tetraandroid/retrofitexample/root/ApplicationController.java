package com.tetraandroid.retrofitexample.root;

import android.app.Application;

import com.tetraandroid.retrofitexample.network.OkHttpModule;
import com.tetraandroid.retrofitexample.network.OpenWeatherModule;
import com.tetraandroid.retrofitexample.network.RetrofitServiceModule;
import com.tetraandroid.retrofitexample.network.TwitchModule;

public class ApplicationController extends Application {

    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .retrofitServiceModule(new RetrofitServiceModule())
                .okHttpModule(new OkHttpModule())
                .twitchModule(new TwitchModule())
                .openWeatherModule(new OpenWeatherModule())
                .build();
    }

    public ApplicationComponent getComponent() {
        return component;
    }
}
