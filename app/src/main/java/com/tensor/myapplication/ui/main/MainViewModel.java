package com.tensor.myapplication.ui.main;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.tensor.myapplication.helpers.PreferenceHelper;
import com.tensor.myapplication.model.ForecastData;
import com.tensor.myapplication.model.User;
import com.tensor.myapplication.network.repository.MainRepository;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class MainViewModel extends ViewModel {
    PreferenceHelper preferenceHelper;
    MainRepository repository;

    public MutableLiveData<User> userLive = new MutableLiveData<>();


    @Inject
    public MainViewModel(PreferenceHelper preferenceHelper, MainRepository repository) {
        this.preferenceHelper = preferenceHelper;
        this.repository = repository;
    }

    public void init() {
        userLive.postValue(preferenceHelper.getUser());
        getWeatherData("");
    }

    //Fetching details from Weather API
    public MutableLiveData<ForecastData> getWeatherData(String city) {
        if(city.isEmpty()){
            city="Kolkata";
        }
        return repository.getWeatherData(city);
    }

    public void clearPrefs(){
        preferenceHelper.clearValues();
    }

}
