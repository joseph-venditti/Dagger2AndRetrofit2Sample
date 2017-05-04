package com.tetraandroid.retrofitexample.network;

import android.util.Log;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class RetrofitServiceModule {

    private static final String TAG = RetrofitServiceModule.class.getSimpleName();

    private final String TWITCH_BASE_URL = "https://api.twitch.tv/kraken/";
    private final String OPEN_WEATHER_BASE_URL = "http://samples.openweathermap.org/";

    /**
     * This provides a single retrofit instance specific to Twitch. It also leverages its own
     * OkHttpClient that DOES NOT have logging enabled.
     */
    @Provides
    @Singleton
    @Named("twitch_retrofit")
    public Retrofit provideTwitchRetrofit(@Named("ok_http_client") OkHttpClient client) {
        Log.d(TAG, "provideTwitchRetrofit");
        return new Retrofit.Builder()
                .baseUrl(TWITCH_BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    /**
     * This provides a single retrofit instance specific to Open Weather. It also leverages its
     * own OkHttpClient that DOES have logging enabled.
     */
    @Provides
    @Singleton
    @Named("open_weather_retrofit")
    public Retrofit provideOpenWeatherRetrofit(@Named("ok_http_client_logging") OkHttpClient client) {
        Log.d(TAG, "provideOpenWeatherRetrofit");
        return new Retrofit.Builder()
                .baseUrl(OPEN_WEATHER_BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
