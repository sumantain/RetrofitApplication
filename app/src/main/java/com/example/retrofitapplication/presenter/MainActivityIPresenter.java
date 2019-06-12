package com.example.retrofitapplication.presenter;

import com.example.retrofitapplication.pojo.ItemModel;

public interface MainActivityIPresenter {

    void onSearchCompleted(ItemModel body);
    void onSearchFaild(String message);
}
