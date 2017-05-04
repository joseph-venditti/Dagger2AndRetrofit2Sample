package com.tetraandroid.retrofitexample.network;

import android.util.Log;

import com.tetraandroid.retrofitexample.network.twitch.TwitchAPI;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by jvenditti on 2017-05-03.
 */
@Module
public class TwitchModule {

    private static final String TAG = TwitchModule.class.getSimpleName();

    @Provides
    public TwitchAPI provideApiService(@Named("twitch_retrofit") Retrofit retrofit) {
        Log.d(TAG, "provideApiService");
        return retrofit.create(TwitchAPI.class);
    }
}
