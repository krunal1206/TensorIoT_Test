package com.tensor.myapplication.listeners;

import com.tensor.myapplication.model.User;

public interface UserDetailsListener {

    void onDetailsFetched(User user);
    void onDetailFetchFailure(String message);
}
