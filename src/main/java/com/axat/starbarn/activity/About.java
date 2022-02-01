package com.axat.starbarn.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.axat.starbarn.R;
import com.axat.starbarn.databinding.ActivityAboutBinding;

public class About extends AppCompatActivity {
ActivityAboutBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_about);

        binding= DataBindingUtil.setContentView(this,R.layout.activity_about);

        binding.backimg.setOnClickListener(view -> onBackPressed());


        binding.terms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(About.this,TermsandCondition.class));
            }
        });
        binding.privacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(About.this,PrivacyPolicy.class));
            }
        });

        binding.forword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(About.this,TermsandCondition.class));
            }
        });

        binding.forword2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(About.this,PrivacyPolicy.class));

            }
        });
    }
}