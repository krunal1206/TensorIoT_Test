package com.tensor.myapplication.di;


import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.tensor.myapplication.helpers.PreferenceHelper;
import com.tensor.myapplication.network.repository.AuthRepository;
import com.tensor.myapplication.network.repository.MainRepository;
import com.tensor.myapplication.network.service.WeatherService;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityRetainedComponent;
import dagger.hilt.android.scopes.ActivityRetainedScoped;

@InstallIn(ActivityRetainedComponent.class)
@Module
public class MainModule {

    @ActivityRetainedScoped
    @Provides
    MainRepository provideMainRepository(WeatherService service) {
        return new MainRepository(service);
    }
}
