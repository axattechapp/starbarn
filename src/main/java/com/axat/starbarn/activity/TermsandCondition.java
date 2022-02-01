package com.axat.starbarn.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.axat.starbarn.R;
import com.axat.starbarn.databinding.ActivityTermsandConditionBinding;

public class TermsandCondition extends AppCompatActivity {
    ActivityTermsandConditionBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_termsand_condition);
        binding= DataBindingUtil.setContentView(TermsandCondition.this,R.layout.activity_termsand_condition);
        binding.backimg.setOnClickListener(view -> onBackPressed());


    }
}