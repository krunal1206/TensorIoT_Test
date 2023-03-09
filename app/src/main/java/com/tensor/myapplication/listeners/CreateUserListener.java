package com.tensor.myapplication.listeners;

import com.tensor.myapplication.model.User;

public interface CreateUserListener {

    void onSuccess(String uid);
    void onFailure(String message);

}
