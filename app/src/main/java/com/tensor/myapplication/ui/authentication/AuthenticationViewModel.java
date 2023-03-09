package com.tensor.myapplication.ui.authentication;

import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.BaseObservable;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.tensor.myapplication.R;
import com.tensor.myapplication.listeners.CreateUserListener;
import com.tensor.myapplication.listeners.LoginListener;
import com.tensor.myapplication.listeners.PhotoStoreListener;
import com.tensor.myapplication.model.User;
import com.tensor.myapplication.network.repository.AuthRepository;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class AuthenticationViewModel extends ViewModel {
    String TAG = "AuthenticationViewModel";

    AuthRepository repository;


    @Inject
    public AuthenticationViewModel(AuthRepository repository) {
        this.repository = repository;
    }

    //Login with Firebase Authentication
    public void LoginUser(String email, String password, LoginListener listener) {
        repository.login(email, password, new LoginListener() {
            @Override
            public void onSuccess(User user) {
                listener.onSuccess(user);
            }

            @Override
            public void onFailure(String message) {
                listener.onFailure(message);
            }
        });
    }

    //Create New user
    public void SignUpUser(Context context, String email, String username, Bitmap profile_pic, String bio, String password, CreateUserListener listener) {

        // Create new user in Firebase Authentication
        repository.createUser(email, password, new CreateUserListener() {
            @Override
            public void onSuccess(String uid) {
                // Storing profile pic in Firebase Storage
                repository.storeUserPhoto(uid, profile_pic, new PhotoStoreListener() {
                    @Override
                    public void onSuccess(String download) {
                        // Storing user details in Realtime database
                        repository.storeUserDetails(uid, username, email, password, bio, download, new CreateUserListener() {
                            @Override
                            public void onSuccess(String uid) {
                                listener.onSuccess(uid);
                            }

                            @Override
                            public void onFailure(String message) {
                                Log.e(TAG, message);
                                listener.onFailure(message);
                            }
                        });
                    }

                    @Override
                    public void onFailure(String errorMessage) {
                        Log.e(TAG, errorMessage);
                        listener.onFailure(errorMessage);
                    }
                });
            }

            @Override
            public void onFailure(String message) {
                Log.e(TAG, message);
                listener.onFailure(message);

            }
        });
    }
}