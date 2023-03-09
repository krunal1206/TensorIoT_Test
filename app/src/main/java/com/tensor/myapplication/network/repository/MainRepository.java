package com.tensor.myapplication.network.repository;

import androidx.lifecycle.MutableLiveData;

import com.tensor.myapplication.model.ForecastData;
import com.tensor.myapplication.network.service.WeatherService;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainRepository {

    String key = "54c29f2204d2480089762033230903";

    WeatherService weatherService;
    private final MutableLiveData<ForecastData> weatherDataMutableLiveData = new MutableLiveData<>();


    @Inject
    public MainRepository(WeatherService service) {
        this.weatherService = service;
    }

    public MutableLiveData<ForecastData> getWeatherData(String city) {
        Call<ForecastData> weatherDataCall = weatherService.getCurrentWeather(key,"7", city);

        weatherDataCall.enqueue(new Callback<ForecastData>() {
            @Override
            public void onResponse(Call<ForecastData> call, Response<ForecastData> response) {
                if (response.isSuccessful()) {
                    weatherDataMutableLiveData.postValue(response.body());
                } else {
                    weatherDataMutableLiveData.postValue(null);
                }
            }

            @Override
            public void onFailure(Call<ForecastData> call, Throwable t) {
                weatherDataMutableLiveData.postValue(null);
            }
        });

        return weatherDataMutableLiveData;
    }
}
