package com.tensor.myapplication.ui.splash;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.tensor.myapplication.databinding.ActivityAuthenticationBinding;
import com.tensor.myapplication.databinding.ActivitySplashBinding;
import com.tensor.myapplication.ui.authentication.AcitivityAuthentication;
import com.tensor.myapplication.ui.main.MainActivity;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class ActivitySplash extends AppCompatActivity {

    ActivitySplashBinding activitySplashBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activitySplashBinding = ActivitySplashBinding.inflate(getLayoutInflater());
        View view = activitySplashBinding.getRoot();
        setContentView(view);

        FirebaseAuth mAuth=FirebaseAuth.getInstance();
        if(mAuth.getCurrentUser()!=null){
            Intent intent=new Intent(this, MainActivity.class);
            startActivity(intent);
        }else{
            Intent intent=new Intent(this, AcitivityAuthentication.class);
            startActivity(intent);
        }
    }
}
