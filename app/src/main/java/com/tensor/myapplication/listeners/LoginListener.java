package com.tensor.myapplication.listeners;

import com.tensor.myapplication.model.User;

public interface LoginListener {

    void onSuccess(User user);
    void onFailure(String message);
}
