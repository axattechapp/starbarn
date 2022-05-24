package com.axat.starbarn.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.axat.starbarn.LoginActivity;
import com.axat.starbarn.R;
import com.axat.starbarn.model.LogoutModel;
import com.axat.starbarn.service.Api;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
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

public class Logout extends AppCompatActivity {
    String token="";
    Api api;
    AlertDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logout);


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



        SharedPreferences preferences=getSharedPreferences("goat",MODE_PRIVATE);
        token=preferences.getString("token","");


        ViewGroup viewGroup=findViewById(R.id.content);

        Button Logout;
        Button Cancel;
        MaterialAlertDialogBuilder builder=new MaterialAlertDialogBuilder(Logout.this);
        View view= LayoutInflater.from(Logout.this).inflate(R.layout.logoutdialog_layout,viewGroup,false);

        Logout=view.findViewById(R.id.LogoutButton);
        Cancel=view.findViewById(R.id.cancelButton1);
        builder.setCancelable(false);
        builder.setView(view);

         dialog=builder.create();

       dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Log.e("token",token);
                JsonObject object=new JsonObject();
                object.addProperty("token",token);

                Call<LogoutModel> call=  api.logout(object);
                call.enqueue(new Callback<LogoutModel>() {
                    @Override
                    public void onResponse(Call<LogoutModel> call, Response<LogoutModel> response) {
                        if (response.isSuccessful())
                        {
                            LogoutModel model=response.body();
                            if (model.status==true)
                            {
                                Toast.makeText(Logout.this,model.getMessage(), Toast.LENGTH_SHORT).show();
                                SharedPreferences preferences = getSharedPreferences("goat", Context.MODE_PRIVATE);
                                SharedPreferences.Editor editor = preferences.edit();
                                editor.clear();
                                editor.commit();


                                startActivity(new Intent(Logout.this, LoginActivity.class));
                                finishAffinity();
                            }else
                                Toast.makeText(Logout.this, "request denied"+model.getMessage(), Toast.LENGTH_SHORT).show();

                        }else
                            Toast.makeText(Logout.this, "Logout error"+response.message(), Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onFailure(Call<LogoutModel> call, Throwable t) {
                        Toast.makeText(Logout.this, "Logout failed"+t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });


            }



        });
//        dialog.getWindow().setGravity(Gravity.AXIS_Y_SHIFT);
        Cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Logout.this,Account.class));
            }
        });

        dialog.show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (dialog != null) {
            dialog.dismiss();
            dialog = null;
        }
    }
}