package com.tetraandroid.retrofitexample.network.openweather;

import com.tetraandroid.retrofitexample.network.openweather.models.OpenWeather;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface OpenWeatherAPI {

    /**
     * Example URL:
     * http://samples.openweathermap.org/data/2.5/weather?lat=35&lon=139&appid=b1b15e88fa797225412429c1c50c122a1
     */
    @GET("data/2.5/weather")
    Call<OpenWeather> getWeather(
            @Query("lat") String lat,
            @Query("lon") String lon,
            @Query("appid") String appid
    );
}
