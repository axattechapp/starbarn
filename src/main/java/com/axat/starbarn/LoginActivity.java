package com.axat.starbarn;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.axat.starbarn.activity.EmailActivity;
import com.axat.starbarn.activity.HomeActivity;
import com.axat.starbarn.databinding.ActivityLoginBinding;
import com.axat.starbarn.model.LoginModel;
import com.axat.starbarn.service.Api;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {
    ActivityLoginBinding binding;
    Api api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_login);
//        setContentView(R.layout.activity_login);


        OkHttpClient okHttpClient=new OkHttpClient.Builder()
                .connectTimeout(8, TimeUnit.MINUTES)
                .writeTimeout(8,TimeUnit.MINUTES)
                .readTimeout(8,TimeUnit.MINUTES)
                .build();


        Gson gson=new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                .build();

        api=retrofit.create(Api.class);







        binding.textlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!binding.editemailedittext.getText().toString().isEmpty()) {
                    binding.editemailedittext.setError(null);
                    if (!binding.editpassworddittext.getText().toString().isEmpty()) {
                        binding.editpassworddittext.setError(null);


                    JsonObject jsonObject = new JsonObject();
                    jsonObject.addProperty("email", binding.editemailedittext.getText().toString());
                    jsonObject.addProperty("password", binding.editpassworddittext.getText().toString());

                    Call<LoginModel> call = api.login(jsonObject);
                    call.enqueue(new Callback<LoginModel>() {
                        @Override
                        public void onResponse(Call<LoginModel> call, Response<LoginModel> response) {
                            if (response.isSuccessful()) {
                                LoginModel model = response.body();
                                if (model.status == true) {
                                    Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                                    SharedPreferences.Editor editor = getSharedPreferences("goat", MODE_PRIVATE).edit();
                                    editor.putString("token", model.getToken());
                                    editor.apply();

                                    Log.e("token",model.getToken());
                                    startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                                    finishAffinity();
                                } else
                                    Toast.makeText(LoginActivity.this, "Incorrect credentials", Toast.LENGTH_SHORT).show();

                            } else
                                Toast.makeText(LoginActivity.this, "Login error" + response.message(), Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onFailure(Call<LoginModel> call, Throwable t) {
                            Toast.makeText(LoginActivity.this, "Login failed" + t.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
                    }else {
                        binding.editpassworddittext.setError("Enter password");
                    }
                }else {
                    binding.editemailedittext.setError("Enter email");
                }
            }
        });

        binding.signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, EmailActivity.class));
                finishAffinity();
            }
        });



    }
}