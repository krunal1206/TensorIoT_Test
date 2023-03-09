package com.tensor.myapplication.di;

import android.content.Context;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.tensor.myapplication.helpers.PreferenceHelper;
import com.tensor.myapplication.network.service.WeatherService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
@InstallIn(SingletonComponent.class)
public class ApplicationModule {

    @Provides
    @Singleton
    Retrofit getRetrofit() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();


        return new Retrofit.Builder()
                .baseUrl("https://api.weatherapi.com")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

    }

    @Provides
    @Singleton
    WeatherService getWeatherService(Retrofit retrofit){
        return retrofit.create(WeatherService.class);
    }

    @Provides
    @Singleton
    FirebaseAuth getFirebaseAuth() {
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        return mAuth;
    }

    @Provides
    @Singleton
    FirebaseStorage getFirebaseStorage() {
        FirebaseStorage mFirebaseStorage = FirebaseStorage.getInstance();
        return mFirebaseStorage;
    }

    @Provides
    @Singleton
    FirebaseDatabase getFirebaseDatabase() {
        FirebaseDatabase mFirebaseDatabase = FirebaseDatabase.getInstance();
        return mFirebaseDatabase;
    }

    @Provides
    @Singleton
    PreferenceHelper getPreferenceHelper(@ApplicationContext Context context) {
        PreferenceHelper preferenceHelper = PreferenceHelper.getInstance(context, PreferenceHelper.PrefFiles.USER_DETAILS_PREF);
        return preferenceHelper;
    }
}
