package com.axat.starbarn.fragment.likedvideo;

import static android.content.Context.MODE_PRIVATE;

import androidx.lifecycle.ViewModelProvider;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.axat.starbarn.R;
import com.axat.starbarn.fragment.allvideo.AllImageAdapter;
import com.axat.starbarn.model.HomeVideoResponse;
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

public class LikedVideosFragment extends Fragment {

    private LikedVideosViewModel mViewModel;
    RecyclerView rcv;
    LikeAdapter adapter;
    ArrayList<Integer> modelList;
    Api api;

    public static LikedVideosFragment newInstance() {
        return new LikedVideosFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.liked_videos_fragment, container, false);
        return view;
    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(LikedVideosViewModel.class);


        rcv = view.findViewById(R.id.allLikesRecy);
        modelList=new ArrayList<Integer>();
        initialsRetrofitObjects();
        SharedPreferences sharedPreferences=getContext().getSharedPreferences("goat",MODE_PRIVATE);
        String token1=sharedPreferences.getString("token","");

        Call<HomeVideoResponse> call=api.get_my_Posts_Likes("Bearer "+token1);
        call.enqueue(new Callback<HomeVideoResponse>() {
            @Override
            public void onResponse(Call<HomeVideoResponse> call, Response<HomeVideoResponse> response) {
                if (response.code()==200)
                {
//                    Toast.makeText(getContext(), "Successfully called my_Posts_Likes API", Toast.LENGTH_SHORT).show();
                }else
                    Toast.makeText(getContext(), "error"+response.message(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<HomeVideoResponse> call, Throwable t) {
                Toast.makeText(getContext(), "fail"+t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
//        rcv.setLayoutManager(new LinearLayoutManager(view.getContext()));
        modelList.add(0,R.drawable.allvideo1);
        modelList.add(1,R.drawable.allvideo2);
        modelList.add(2,R.drawable.allvideo1);
        modelList.add(3,R.drawable.allvideo1);
        modelList.add(4,R.drawable.allvideo2);
        modelList.add(5,R.drawable.allvideo1);
        modelList.add(6,R.drawable.allvideo1);
        modelList.add(7,R.drawable.allvideo2);
        modelList.add(8,R.drawable.allvideo1);
        modelList.add(9,R.drawable.allvideo1);
        modelList.add(10,R.drawable.allvideo2);
        modelList.add(11,R.drawable.allvideo1);
        modelList.add(12,R.drawable.allvideo1);
        modelList.add(13,R.drawable.allvideo2);
        modelList.add(14,R.drawable.allvideo1);


        GridLayoutManager gridLayoutManager=new GridLayoutManager(view.getContext(),3);
        rcv.setLayoutManager(gridLayoutManager);

        adapter = new LikeAdapter(modelList);
        rcv.setAdapter(adapter);
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