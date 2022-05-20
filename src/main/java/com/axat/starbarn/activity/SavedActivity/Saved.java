package com.axat.starbarn.activity.SavedActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.axat.starbarn.DeleteConfirmActivity;
import com.axat.starbarn.R;
import com.axat.starbarn.databinding.ActivitySavedBinding;
import com.axat.starbarn.model.GetSavedVideos;
import com.axat.starbarn.service.Api;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Saved extends AppCompatActivity {

    ActivitySavedBinding binding;
    SavedAdapter adapter;
    ArrayList<Integer> modelList;
    boolean select=false;
    Api api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_saved);

        binding= DataBindingUtil.setContentView(this,R.layout.activity_saved);

        binding.imageView3.setOnClickListener(view -> onBackPressed());
        binding.deleteIcon.setClickable(false);


        initialsRetrofitObjects();
        binding.deleteIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Saved.this, DeleteConfirmActivity.class));

            }
        });

        modelList=new ArrayList<Integer>();
//        rcv.setLayoutManager(new LinearLayoutManager(view.getContext()));


        SharedPreferences sharedPreferences=getSharedPreferences("goat",MODE_PRIVATE);
        String Token=sharedPreferences.getString("token","");
        Call<GetSavedVideos> call= api.getSavedVideos("Bearer "+Token);

        call.enqueue(new Callback<GetSavedVideos>() {
            @Override
            public void onResponse(Call<GetSavedVideos> call, Response<GetSavedVideos> response) {
                if (response.code()==200)
                {
                    GetSavedVideos model= response.body();
                    try {
                        for (int i=0;i<model.getData().size();i++)
                        {
//                            Bitmap thumb = ThumbnailUtils.createVideoThumbnail(model.getData().get(0).getMediaUrl(), MediaStore.Video.Thumbnails.MICRO_KIND);
//                            modelList.add(i, Integer.parseInt(model.getData().get(i).getMediaUrl()));

                        }




                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    Toast.makeText(Saved.this, "got your saved videos.", Toast.LENGTH_SHORT).show();
                }else
                    Toast.makeText(Saved.this, ""+response.errorBody(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<GetSavedVideos> call, Throwable t) {
                Toast.makeText(Saved.this, ""+t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.e("fail",""+t.getMessage());

            }
        });
        modelList.add(0,R.drawable.saved1);
        modelList.add(1,R.drawable.saved2);
        modelList.add(2,R.drawable.saved3);
        modelList.add(3,R.drawable.saved4);
        modelList.add(4,R.drawable.saved5);
        modelList.add(5,R.drawable.saved6);
        modelList.add(6,R.drawable.saved1);
        modelList.add(7,R.drawable.saved2);
        modelList.add(8,R.drawable.saved3);
        modelList.add(9,R.drawable.saved4);
        modelList.add(10,R.drawable.saved5);
        modelList.add(11,R.drawable.saved6);
        modelList.add(12,R.drawable.saved1);
        modelList.add(13,R.drawable.saved2);
        modelList.add(14,R.drawable.saved3);
        modelList.add(15,R.drawable.saved4);
        modelList.add(16,R.drawable.saved5);
        modelList.add(17,R.drawable.saved6);
        modelList.add(18,R.drawable.saved1);
        modelList.add(19,R.drawable.saved2);
        modelList.add(20,R.drawable.saved3);
//

        GridLayoutManager gridLayoutManager=new GridLayoutManager(Saved.this,3);
        binding.savedVideosRec.setLayoutManager(gridLayoutManager);

        adapter = new SavedAdapter(modelList,select);
        binding.savedVideosRec.setAdapter(adapter);


        binding.SelectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (binding.SelectText.getText()=="Select")
                {
                    select=true;
                    GridLayoutManager gridLayoutManager=new GridLayoutManager(Saved.this,3);
                    binding.savedVideosRec.setLayoutManager(gridLayoutManager);
                    adapter = new SavedAdapter(modelList,select);
                    binding.savedVideosRec.setAdapter(adapter);

                    binding.SelectText.setText("Cancel");
                    binding.deleteIcon.setVisibility(View.VISIBLE);
                    binding.deleteIcon.setClickable(true);

                    binding.deleteIcon.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            startActivity(new Intent(Saved.this, DeleteConfirmActivity.class));

                        }
                    });
//                    Toast.makeText(Saved.this, "Clicked", Toast.LENGTH_SHORT).show();


                }else
                {
                    select=false;
                    GridLayoutManager gridLayoutManager=new GridLayoutManager(Saved.this,3);
                    binding.savedVideosRec.setLayoutManager(gridLayoutManager);
                    adapter = new SavedAdapter(modelList,select);
                    binding.savedVideosRec.setAdapter(adapter);

                    binding.SelectText.setText("Select");
//                    Toast.makeText(Saved.this, "Clicked", Toast.LENGTH_SHORT).show();

                }

            }
        });
        if (binding.SelectText.isPressed())
        binding.savedVideosRec.post(new Runnable() {
            @Override
            public void run() {
                adapter.notifyDataSetChanged();
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