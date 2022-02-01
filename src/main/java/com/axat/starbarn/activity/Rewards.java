package com.axat.starbarn.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.axat.starbarn.R;
import com.axat.starbarn.databinding.ActivityRewardsBinding;

public class Rewards extends AppCompatActivity {
    ActivityRewardsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_rewards);

        binding= DataBindingUtil.setContentView(Rewards.this,R.layout.activity_rewards);
        binding.backimg.setOnClickListener(view -> onBackPressed());
    }
}