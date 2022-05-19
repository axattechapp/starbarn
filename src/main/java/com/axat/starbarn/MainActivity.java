package com.axat.starbarn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import com.axat.starbarn.activity.HomeActivity;
import com.axat.starbarn.activity.OnBoardActivity;
import com.axat.starbarn.model.WhoUserModel;
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

public class MainActivity extends AppCompatActivity {
    private Window mWindow;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mWindow = getWindow();
        mWindow.getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);



        new Handler().postDelayed(() -> {

            SharedPreferences preferences=getSharedPreferences("goat",MODE_PRIVATE);
            String token=preferences.getString("token","");
            Log.e("token",""+token);

            if(token=="")
            {
                startActivity(new Intent(MainActivity.this, OnBoardActivity.class));
                finish();
            }else
            {


                startActivity(new Intent(MainActivity.this, HomeActivity.class));
                finish();
            }

        },1000);
    }
}