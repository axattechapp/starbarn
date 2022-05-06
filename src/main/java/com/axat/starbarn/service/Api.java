package com.axat.starbarn.service;

import com.axat.starbarn.model.LoginModel;
import com.axat.starbarn.model.LogoutModel;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Api {
  String BASE_URL = "http://3.132.0.157/starbarn/public/api/";


    @POST("login")
    Call<LoginModel> login(@Body JsonObject jsonObject);

  @POST("logout")
  Call<LogoutModel> logout(@Body JsonObject jsonObject);


}
