package com.example.retrofitapplication.presenter;

import android.content.Context;

import com.example.retrofitapplication.model.MainActivityModel;
import com.example.retrofitapplication.pojo.ItemModel;
import com.example.retrofitapplication.view.MainActivityView;

public class MainActivityPresenter implements MainActivityIPresenter {
    MainActivityModel model;
    MainActivityView myView;


    public MainActivityPresenter(MainActivityView myView) {
        this.myView = myView;
        model = new MainActivityModel((Context) myView, this);
    }

    public void updateButtonClick(){
        model.fetchDataFromServer();
    }

    @Override
    public void onSearchCompleted(ItemModel body) {
        myView.onUpdateData(body.getQuota_max());
    }

    @Override
    public void onSearchFaild(String message) {

    }
}
