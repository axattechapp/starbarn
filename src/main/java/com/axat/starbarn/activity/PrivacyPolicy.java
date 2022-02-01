package com.axat.starbarn.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.axat.starbarn.R;
import com.axat.starbarn.databinding.ActivityPrivacyPolicyBinding;

public class PrivacyPolicy extends AppCompatActivity {
    ActivityPrivacyPolicyBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_privacy_policy);

        binding= DataBindingUtil.setContentView(PrivacyPolicy.this,R.layout.activity_privacy_policy);
        binding.backimg.setOnClickListener(view -> onBackPressed());
    }
}