package com.axat.starbarn.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.axat.starbarn.R;
import com.axat.starbarn.databinding.PersonalDetailsBinding;
import com.axat.starbarn.model.ViewProfileModel;
import com.axat.starbarn.service.Api;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PersonalDetails extends AppCompatActivity {
    PersonalDetailsBinding binding;
    Api api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.personal_details);

        binding= DataBindingUtil.setContentView(PersonalDetails.this,R.layout.personal_details);

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

        binding.backimg.setOnClickListener(view -> onBackPressed());

        SharedPreferences preferences=getSharedPreferences("goat",MODE_PRIVATE);
        String user_id=preferences.getString("user_id","");
        Log.e("user_id",user_id);



        Call<ViewProfileModel> call=api.viewProfile(user_id);
        call.enqueue(new Callback<ViewProfileModel>() {
            @Override
            public void onResponse(Call<ViewProfileModel> call, Response<ViewProfileModel> response) {
                if (response.code()==200)
                {
                    ViewProfileModel model=response.body();
                    binding.edtName.setText(model.getData().get(0).getName());
                    binding.edtEmail.setText(model.getData().get(0).getEmail());
                    binding.edtPhone.setText(model.getData().get(0).getPhone());
                }else
                    Toast.makeText(PersonalDetails.this, ""+response.message(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<ViewProfileModel> call, Throwable t) {
                Toast.makeText(PersonalDetails.this, ""+t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }
}