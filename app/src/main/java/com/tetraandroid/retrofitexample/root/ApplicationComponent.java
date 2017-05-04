package com.tetraandroid.retrofitexample.root;

import com.tetraandroid.retrofitexample.MainActivity;
import com.tetraandroid.retrofitexample.network.OkHttpModule;
import com.tetraandroid.retrofitexample.network.OpenWeatherModule;
import com.tetraandroid.retrofitexample.network.RetrofitServiceModule;
import com.tetraandroid.retrofitexample.network.TwitchModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class, RetrofitServiceModule.class, OkHttpModule.class, TwitchModule.class, OpenWeatherModule.class})
public interface ApplicationComponent {
    void inject(MainActivity target);
}
