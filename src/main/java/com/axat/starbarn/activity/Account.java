package com.axat.starbarn.activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.axat.starbarn.LoginActivity;
import com.axat.starbarn.R;
import com.axat.starbarn.RealPathUtil;
import com.axat.starbarn.databinding.AccountLayoutBinding;
import com.axat.starbarn.model.LogoutModel;
import com.axat.starbarn.model.LogoutModel;
import com.axat.starbarn.model.ProfileModel;
import com.axat.starbarn.model.ViewProfileModel;
import com.axat.starbarn.service.Api;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Account extends AppCompatActivity {
    AccountLayoutBinding binding;
    String imageurl = "";
    private static final int MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE = 1;
    private static final Integer REQUEST_SHERGIL = 1234;
    Api api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.account_layout);

        binding= DataBindingUtil.setContentView(this,R.layout.account_layout);




        binding.backimg.setOnClickListener(view -> onBackPressed());
        binding.cameraimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(binding.getRoot().getContext(),
                        Manifest.permission.READ_EXTERNAL_STORAGE)
                        != PackageManager.PERMISSION_GRANTED) {


                    ActivityCompat.requestPermissions(Account.this,
                            new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                            MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE);
                } else {
                    Intent intent = new Intent();
                    intent.setType("image/*");
                    intent.setAction(Intent.ACTION_GET_CONTENT);

                    startActivityForResult(intent, REQUEST_SHERGIL);


                }
            }
        });
        initialsRetrofitObjects();
        binding.perIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Account.this,PersonalDetails.class));
            }
        });
        Log.e("user_id",""+HomeActivity.user_id);
        Call<ViewProfileModel> call21=api.viewProfile(HomeActivity.user_id);
        call21.enqueue(new Callback<ViewProfileModel>() {
            @Override
            public void onResponse(Call<ViewProfileModel> call, Response<ViewProfileModel> response) {
                if (response.code()==200)
                {
                    ViewProfileModel model=response.body();
                    Log.e("img",""+Api.Img_Url + model.getData().get(0).getProfile());
                    if (model.getData().get(0).getProfile()!=null) {
//                        Glide.with(Account.this)
//                                .load(Api.Img_Url + model.getData().get(0).getProfile())
//                                .into(binding.profileimg1);
                        Picasso.get()
                                .load(Api.Img_Url + model.getData().get(0).getProfile())
                                .into(binding.profileimg1);
                    }

                }else
                    Toast.makeText(Account.this, ""+response.message(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<ViewProfileModel> call, Throwable t) {
                Toast.makeText(Account.this, ""+t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
        binding.abtIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Account.this,About.class));
            }
        });
        binding.lgIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Account.this,Logout.class));
            }
        });

        binding.personalCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Account.this,PersonalDetails.class));
            }
        });
        binding.aboutCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Account.this,About.class));
            }
        });

        binding.logoutCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Account.this,Logout.class));
            }
        });
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==REQUEST_SHERGIL && resultCode == Activity.RESULT_OK && data != null)
        {


            Uri uri=data.getData();
            String path = null;
            if (Build.VERSION.SDK_INT < 11)
            {
                imageurl = RealPathUtil.getRealPathFromURI_BelowAPI11(Account.this, uri);
            }
            // SDK >= 11 && SDK < 19
            else if (Build.VERSION.SDK_INT < 19)
            {
                imageurl = RealPathUtil.getRealPathFromURI_API11to18(Account.this, uri);
            }
            // SDK > 19 (Android 4.4)
            else
            {
                imageurl = RealPathUtil.getRealPathFromURI_API19(Account.this, uri);
            }

            Log.e("path", "File Path: " + imageurl);
            // Get the file instance
//            File file = new File(path);
            Log.e("imgUrlResult","i"+imageurl);

      
            Bitmap bitmap= null;
            try {
                bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(uri));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            binding.profileimg1.setImageBitmap(bitmap);

            changeProfileImg();
//



        }
    }

    public void changeProfileImg()
    {
        Log.e("profile_pic",""+imageurl);


        SharedPreferences preferences = Account.this.getSharedPreferences("goat", Context.MODE_PRIVATE);
        String retrivedToken  = preferences.getString("token",null);

        File file = new File(imageurl);
        MultipartBody.Part imagePart = MultipartBody.Part.createFormData("profile", file.getName(), RequestBody.create(MediaType.parse("image/*"), file));


        Call<ProfileModel> call= api.changeProfile("Bearer "+retrivedToken,imagePart);
        call.enqueue(new Callback<ProfileModel>() {
            @Override
            public void onResponse(Call<ProfileModel> call, Response<ProfileModel> response) {
                if (response.code()==200)
                {
                    Toast.makeText(Account.this, "Profile picture added", Toast.LENGTH_SHORT).show();
                }else
                    Toast.makeText(Account.this, "error"+response.errorBody(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<ProfileModel> call, Throwable t) {
                Toast.makeText(Account.this, "fail"+t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
    public void initialsRetrofitObjects()
    {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(8, TimeUnit.MINUTES)
                .writeTimeout(8, TimeUnit.MINUTES)
                .readTimeout(8, TimeUnit.MINUTES)
                .build();


        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                .build();

        api = retrofit.create(Api.class);
    }
}