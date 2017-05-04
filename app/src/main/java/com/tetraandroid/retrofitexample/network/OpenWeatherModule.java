package com.tetraandroid.retrofitexample.network;

import android.util.Log;

import com.tetraandroid.retrofitexample.network.openweather.OpenWeatherAPI;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by jvenditti on 2017-05-03.
 */

@Module
public class OpenWeatherModule {

    private static final String TAG = OpenWeatherModule.class.getSimpleName();

    @Provides
    public OpenWeatherAPI provideApiService(@Named("open_weather_retrofit") Retrofit retrofit) {
        Log.d(TAG, "provideApiService");
        return retrofit.create(OpenWeatherAPI.class);
    }
}
