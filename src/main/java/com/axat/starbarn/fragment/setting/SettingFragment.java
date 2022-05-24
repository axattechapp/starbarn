package com.axat.starbarn.fragment.setting;

import static android.content.Context.MODE_PRIVATE;

import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.PorterDuff;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.axat.starbarn.R;
import com.axat.starbarn.ToastDislikeActivity;
import com.axat.starbarn.activity.Account;
import com.axat.starbarn.activity.HomeActivity;
import com.axat.starbarn.activity.Ladder.LadderActivity;
import com.axat.starbarn.activity.Rewards;
import com.axat.starbarn.activity.SavedActivity.Saved;
import com.axat.starbarn.adapter.ViewPagerAdapter;
import com.axat.starbarn.databinding.SettingFragmentBinding;
import com.axat.starbarn.model.DashboardResponse;
import com.axat.starbarn.model.ViewProfileModel;
import com.axat.starbarn.service.Api;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.picasso.Picasso;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SettingFragment extends Fragment {

    private SettingViewModel mViewModel;
    SettingFragmentBinding binding;
    Api api;
    LayoutInflater inflater;


    public static SettingFragment newInstance() {
        return new SettingFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.setting_fragment, container, false);
        return binding.getRoot();
    }

    Context context;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(SettingViewModel.class);


        binding.viewpager.setAdapter(new ViewPagerAdapter(requireActivity()));


        new TabLayoutMediator(binding.tabpost, binding.viewpager, (tab, position) -> {
            switch (position) {
                case 0:
                    tab.setText("All your videos");
                    break;
                case 1:
                    tab.setText("Liked videos");
                    break;

            }
        }).attach();


        binding.tabpost.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                binding.viewpager.setCurrentItem(tab.getPosition());

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        binding.viewpager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                binding.tabpost.selectTab(binding.tabpost.getTabAt(position));
            }
        });


        binding.profileimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), Account.class));
            }
        });


        binding.save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), Saved.class));

            }
        });

        binding.ladder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), LadderActivity.class));
            }
        });


        binding.rewrds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(v.getContext(), Rewards.class));

            }
        });

        loadDashboardRecord();

    }
    public void loadDashboardRecord(){
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
        inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        SharedPreferences sharedPreferences=getContext().getSharedPreferences("goat",MODE_PRIVATE);
        String token1=sharedPreferences.getString("token","");

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
                                .into( binding.profileimg);

                        binding.textname.setText(model.getData().get(0).getName());
                    }

                }else
                    Toast.makeText(getContext(), ""+response.message(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<ViewProfileModel> call, Throwable t) {
                Toast.makeText(getContext(), ""+t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
        Log.e("token1","token1"+token1);
        Call<DashboardResponse> call = api.Dashboard("Bearer "+token1);
        call.enqueue(new Callback<DashboardResponse>() {
            @Override
            public void onResponse(Call<DashboardResponse> call, Response<DashboardResponse> response) {
                if (response.code() == 200) {

                    binding.textvideocount.setText(String.valueOf(response.body().getVideos()));
                    binding.textchallenge.setText(String.valueOf(response.body().getChallenge_remain()));
                    binding.textfollowingcount.setText(String.valueOf(response.body().getFollowing_count()));
                    binding.textfollowercount.setText(String.valueOf(response.body().getFollwer_count()));//textfollowingcount
                    binding.textLikesCount.setText(String.valueOf(response.body().getLiked()));

                } else
                    Toast.makeText(getContext(), "error" + response.message(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<DashboardResponse> call, Throwable t) {
                Toast.makeText(getContext(), "fail" + t.getMessage(), Toast.LENGTH_SHORT).show();
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