package com.axat.starbarn.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.axat.starbarn.R;
import com.axat.starbarn.databinding.ActivityVerfiyNumberBinding;
import com.axat.starbarn.model.Register_phase1;
import com.axat.starbarn.service.Api;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.hbb20.CountryCodePicker;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class VerfiyNumberActivity extends AppCompatActivity {
    ActivityVerfiyNumberBinding binding;
    Api api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_verfiy_number);

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



        binding.countrypicker.setCcpDialogShowTitle(true);

        String countrycode = binding.countrypicker.getSelectedCountryCode();
        Intent intent=getIntent();
        String email=intent.getStringExtra("email");
        String password=intent.getStringExtra("password");


        binding.backimg.setOnClickListener(view -> {
            onBackPressed();
        });
        binding.textcontinue.setOnClickListener(view -> {

            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("email", email);
            jsonObject.addProperty("phone", binding.editphoneedittext.getText().toString());
            jsonObject.addProperty("password", password);
            jsonObject.addProperty("countrycode", countrycode);

            Log.e("email",email);
            Log.e("phone", binding.editphoneedittext.getText().toString());
            Log.e("password",password);
            Log.e("countrycode",countrycode);



            Call<Register_phase1> phase1Call=api.register_phase1(jsonObject);
            phase1Call.enqueue(new Callback<Register_phase1>() {
                @Override
                public void onResponse(Call<Register_phase1> call, Response<Register_phase1> response) {
                    if (response.code()==200)
                    {
                        Register_phase1 register_phase1= response.body();
                        Toast.makeText(VerfiyNumberActivity.this, ""+register_phase1.getMeassage(), Toast.LENGTH_SHORT).show();
//                        startActivity(new Intent(VerfiyNumberActivity.this,OTPActivity.class));
                        SharedPreferences.Editor editor = getSharedPreferences("goat", MODE_PRIVATE).edit();
                        editor.putString("token", register_phase1.getToken());
                        editor.apply();
                        Log.e("token_register",register_phase1.getToken());
                        Intent intent1=new Intent(VerfiyNumberActivity.this,OTPActivity.class);
                        startActivity(intent1);
                    }else
                        Toast.makeText(VerfiyNumberActivity.this, ""+response.message(), Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFailure(Call<Register_phase1> call, Throwable t) {
                    Toast.makeText(VerfiyNumberActivity.this, ""+t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });


        });
    }
}