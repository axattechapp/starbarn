package com.axat.starbarn.service;

import com.axat.starbarn.model.CategoryModel;
import com.axat.starbarn.model.ChallengeModel;
import com.axat.starbarn.model.DashboardResponse;
import com.axat.starbarn.model.ForgotPassword;
import com.axat.starbarn.model.GetSavedVideos;
import com.axat.starbarn.model.HomeVideoResponse;
import com.axat.starbarn.model.LoginModel;
import com.axat.starbarn.model.LogoutModel;
import com.axat.starbarn.model.OTP_Model;
import com.axat.starbarn.model.ProfileModel;
import com.axat.starbarn.model.Register_phase1;
import com.axat.starbarn.model.SavedVideoResponse;
import com.axat.starbarn.model.ViewProfileModel;
import com.axat.starbarn.model.VoteModel;
import com.axat.starbarn.model.WhoUserModel;
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
import retrofit2.http.Query;

public interface Api {
  String BASE_URL = "http://3.132.0.157/starbarn/public/api/";
  String Img_Url = "http://3.132.0.157/starbarn/public";


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

    @Multipart
    @POST("saveprofile_second")
    Call<saveProfileModel> saveProfile2(@Header ("Authorization") String token,
                                       @Part("name") RequestBody name,
                                       @Part("category_id") RequestBody category_id,
                                       @Part MultipartBody.Part image);



 @POST("me")
 Call<WhoUserModel> getUserDetails(@Header("Authorization") String token);

    @GET("view_profile")
    Call<ViewProfileModel> viewProfile(@Query("userid") String userid);

    @POST("forgot_password")
    Call<ForgotPassword> Forgot(@Body JsonObject jsonObject);

    @POST("update_profile")
    Call<ForgotPassword> UpdateProfile(@Body JsonObject jsonObject);


    @GET("get_allpost")
    Call<HomeVideoResponse> HomeAllVideo(@Header("Authorization") String token);

    @GET("user_dashbord")
    Call<DashboardResponse> Dashboard(@Header("Authorization") String token);

    @POST("saved_video")
    Call<SavedVideoResponse> SavedVideo(@Header("Authorization") String token, @Body JsonObject jsonObject);


    @Multipart
    @POST("profile_pic")
    Call<ProfileModel> changeProfile(@Header("Authorization") String token, @Part MultipartBody.Part profileImage);


    @POST("userSaveditems")
    Call<GetSavedVideos> getSavedVideos(@Header("Authorization") String token);

    @GET("my_posts")
    Call<HomeVideoResponse> get_my_Posts(@Header("Authorization") String token);

    @GET("my_post_likes")
    Call<HomeVideoResponse> get_my_Posts_Likes(@Header("Authorization") String token);



    @FormUrlEncoded
    @POST("post_votes")
    Call<VoteModel> vote(@Header("Authorization") String token,
                         @Field("post_id") int post_id,
                         @Field("is_positive") int value);

    @FormUrlEncoded
    @POST("upload_challenge_request")
    Call<ChallengeModel> challengeVideo(@Header("Authorization") String token,
                                   @Field("post_id") int post_id,
                                   @Field("category_id") String category_id,
                                   @Field("media_type") String media_type,
                                   @Field("description") String description,
                                   @Field("status") int status);



}
