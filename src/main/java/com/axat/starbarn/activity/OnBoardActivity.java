package com.axat.starbarn.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.splashscreen.SplashScreen;
import androidx.databinding.DataBindingUtil;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.ConditionVariable;
import android.view.View;

import com.axat.starbarn.LoginActivity;
import com.axat.starbarn.R;
import com.axat.starbarn.adapter.OnBoardAdapter;
import com.axat.starbarn.databinding.ActivityOnBoardBinding;
import com.axat.starbarn.model.OnBoarModel;

import java.util.ArrayList;
import java.util.List;

public class OnBoardActivity extends AppCompatActivity {

    ActivityOnBoardBinding binding;
    OnBoardAdapter onBoardAdapter;
    List<OnBoarModel> list = new ArrayList<>();
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_on_board);

        context = OnBoardActivity.this;

        setUpViewPager();
        initViews();

    }

    private void initViews() {
        binding.textnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (binding.viewpager.getCurrentItem() == list.size() - 1) {
                    startActivity(new Intent(OnBoardActivity.this, LoginActivity.class));
                    finish();
                } else {
                    binding.viewpager.setCurrentItem(binding.viewpager.getCurrentItem() + 1);
                }
            }
        });

        binding.textskip.setOnClickListener(view -> {
            startActivity(new Intent(OnBoardActivity.this, LoginActivity.class));
            finish();
        });


    }

    private void setUpViewPager() {

        list.add(new OnBoarModel("Judge", "You think your the best\nlet the world be the judge.", R.drawable.onboard_judge));
        list.add(new OnBoarModel("Challenge", "'To be the best you have to beat\nthe best'. Competitors upload clips\nand race to be No.1. Challenge\nother competitors along the way!", R.drawable.onboard_challenge));


        onBoardAdapter = new OnBoardAdapter(context, list);
        binding.viewpager.setAdapter(onBoardAdapter);
        binding.tabIndcator.setupWithViewPager(binding.viewpager);


        binding.viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                if (position == list.size() - 1) {
                    binding.textnext.setText("Finish");
                    binding.textskip.setVisibility(View.INVISIBLE);
                } else {
                    binding.textskip.setVisibility(View.VISIBLE);
                    binding.textnext.setText("Next");

                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }
}