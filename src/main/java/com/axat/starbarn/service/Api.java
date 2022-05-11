package com.axat.starbarn.service;

import com.axat.starbarn.model.CategoryModel;
import com.axat.starbarn.model.LoginModel;
import com.axat.starbarn.model.LogoutModel;
import com.axat.starbarn.model.OTP_Model;
import com.axat.starbarn.model.Register_phase1;
import com.axat.starbarn.model.saveProfileModel;
import com.google.gson.JsonObject;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface Api {
  String BASE_URL = "http://3.132.0.157/starbarn/public/api/";


    @POST("login")
    Call<LoginModel> login(@Body JsonObject jsonObject);

  @POST("logout")
  Call<LogoutModel> logout(@Body JsonObject jsonObject);

  @POST("user_register")
  Call<Register_phase1> register_phase1(@Body JsonObject jsonObject);

  @POST("varify_otp")
  Call<OTP_Model> verifyOTP(@Body JsonObject jsonObject);

  @GET("getAllcategories")
  Call<CategoryModel> getCategory();

 @Multipart
  @POST("saveprofile")
  Call<saveProfileModel> saveProfile(@Header ("Authorization") String token,
                                     @Part("name") RequestBody name,
                                     @Part("category_id[]") RequestBody category_id,
                                     @Part MultipartBody.Part image);




}