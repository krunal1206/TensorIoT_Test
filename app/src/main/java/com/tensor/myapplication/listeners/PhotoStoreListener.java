package com.tensor.myapplication.listeners;

public interface PhotoStoreListener {

    void onSuccess(String download);
    void onFailure(String errorMessage);

}
