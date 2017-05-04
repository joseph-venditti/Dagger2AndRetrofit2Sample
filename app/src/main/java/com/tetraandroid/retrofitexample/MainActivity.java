package com.tetraandroid.retrofitexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.tetraandroid.retrofitexample.network.openweather.OpenWeatherAPI;
import com.tetraandroid.retrofitexample.network.twitch.TwitchAPI;
import com.tetraandroid.retrofitexample.network.openweather.models.OpenWeather;
import com.tetraandroid.retrofitexample.network.openweather.models.Weather;
import com.tetraandroid.retrofitexample.network.twitch.models.Top;
import com.tetraandroid.retrofitexample.network.twitch.models.Twitch;
import com.tetraandroid.retrofitexample.root.ApplicationController;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Inject
    TwitchAPI twitchAPI;

    @Inject
    OpenWeatherAPI openWeatherAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((ApplicationController) getApplication()).getComponent().inject(this);

        /**
         * The following call is specific to the Twitch API. All Twitch API calls will go
         * through its own instance of Retrofit.
         */
        Call<Twitch> twitchCall = twitchAPI.getTopGames("ADD_TWITCH_CLIENT_ID_HERE");
        twitchCall.enqueue(new Callback<Twitch>() {
            @Override
            public void onResponse(Call<Twitch> call, Response<Twitch> response) {
                Log.d(TAG, "onResponse (Twitch)");
                List<Top> gameList = response.body().getTop();
                for (Top top : gameList) {
                    Log.d(TAG, "------ name: " + top.getGame().getName() + " | box: " + top.getGame().getBox().getLarge());
                }
            }

            @Override
            public void onFailure(Call<Twitch> call, Throwable t) {
                Log.d(TAG, "onFailure (Twitch): " + t.toString());
            }
        });

        /**
         * The following call is specific to the OpenWeather API. All OpenWeather calls will go
         * through its own instance of Retrofit.
         */
        Call<OpenWeather> openWeatherCall = openWeatherAPI.getWeather("35", "139", "b1b15e88fa797225412429c1c50c122a1");
        openWeatherCall.enqueue(new Callback<OpenWeather>() {
            @Override
            public void onResponse(Call<OpenWeather> call, Response<OpenWeather> response) {
                Log.d(TAG, "onResponse (OpenWeather)");
                List<Weather> weatherList = response.body().getWeather();
                for (Weather weather : weatherList) {
                    Log.d(TAG, "------ id: " + weather.getId() + " | description: " + weather.getDescription());
                }
            }

            @Override
            public void onFailure(Call<OpenWeather> call, Throwable t) {
                Log.d(TAG, "onFailure (OpenWeather): " + t.toString());
            }
        });
    }
}
