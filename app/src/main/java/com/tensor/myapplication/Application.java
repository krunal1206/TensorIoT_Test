package com.tensor.myapplication;

import android.content.pm.PackageManager;
import android.os.Build;

import com.google.firebase.FirebaseApp;

import dagger.hilt.android.HiltAndroidApp;

@HiltAndroidApp
public class Application extends android.app.Application {

    @Override
    public void onCreate() {
        super.onCreate();

    }
}
