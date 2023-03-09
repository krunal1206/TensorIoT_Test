package com.tensor.myapplication.network.service;

import com.tensor.myapplication.model.ForecastData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherService {

    @GET("v1/forecast.json")
    Call<ForecastData> getCurrentWeather(
            @Query("key") String key,
            @Query("days") String days,
            @Query("q") String query
    );
}
