package com.example.retrofitapplication.model;

import android.content.Context;

import com.example.retrofitapplication.network.RetrofitClient;
import com.example.retrofitapplication.pojo.ItemModel;
import com.example.retrofitapplication.presenter.MainActivityIPresenter;
import com.example.retrofitapplication.presenter.MainActivityPresenter;
import com.example.retrofitapplication.view.MainActivityView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivityModel {

    Context myView;
    MainActivityIPresenter mainActivityIPresenter;


    public MainActivityModel(Context myView, MainActivityPresenter mainActivityPresenter) {
        this.myView = myView;
        this.mainActivityIPresenter = mainActivityPresenter;
    }

    public void fetchDataFromServer() {

//        Call<UserData> callLogin = RetrofitClient.getInstance(getContext()).getApi().fetchUserDetails("f9aSV4pm9229");
        Call<ItemModel> callLogin = RetrofitClient.getInstance(myView).getApi().fetchSearchData("desc","votes","android","stackoverflow");
        //    showProgress(true);
        callLogin.enqueue(new Callback<ItemModel>() {
            @Override
            public void onResponse(Call<ItemModel> call, Response<ItemModel> response) {
                try {
                    response.body();
                    mainActivityIPresenter.onSearchCompleted(response.body());
//                    bodysetProfileImage();
//                    populatRecyclerView();
                } catch (Exception e) {

                } finally {
                    try {
//                        if (dialog.isShowing()) {
//                            dialog.dismiss();
//                        }
                    } catch (Exception e) {

                    }
                }
            }

            @Override
            public void onFailure(Call<ItemModel> call, Throwable t) {
                try {
//                    if (dialog.isShowing()) {
//                        dialog.dismiss();
//                    }
                    mainActivityIPresenter.onSearchFaild(t.getMessage());
                } catch (Exception e) {

                }
            }
        });
    }

}
