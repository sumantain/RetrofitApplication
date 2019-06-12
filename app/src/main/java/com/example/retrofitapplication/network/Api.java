package com.example.retrofitapplication.network;


import com.example.retrofitapplication.pojo.ItemModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface Api {

//    @FormUrlEncoded
//    @POST(NetworkUtility.LOGIN)
//    Call<ItemModel> createlogin(
//            @Field("username") String username,
//            @Field("userpassword") String userpassword
//    );

    @GET(NetworkUtility.SEARCH)
    Call<ItemModel> fetchSearchData(
            @Query("order") String order,
            @Query("sort") String sort,
            @Query("tagged") String tagged,
            @Query("site") String site
//            order=desc&sort=votes&tagged=android&site=stackoverflow
    );
}
