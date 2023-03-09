package com.tensor.myapplication.di;

import androidx.lifecycle.ViewModelProvider;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.tensor.myapplication.helpers.PreferenceHelper;
import com.tensor.myapplication.network.repository.AuthRepository;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityRetainedComponent;
import dagger.hilt.android.scopes.ActivityRetainedScoped;

@InstallIn(ActivityRetainedComponent.class)
@Module
public class AuthModule {

    @ActivityRetainedScoped
    @Provides
    AuthRepository provideAuthRepository(FirebaseAuth auth, FirebaseStorage storage, FirebaseDatabase database, PreferenceHelper helper) {
        return new AuthRepository(auth, storage, database, helper);
    }
}