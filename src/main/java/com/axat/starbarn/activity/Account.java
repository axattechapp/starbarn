package com.axat.starbarn.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.axat.starbarn.R;
import com.axat.starbarn.databinding.AccountLayoutBinding;

public class Account extends AppCompatActivity {
    AccountLayoutBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.account_layout);

        binding= DataBindingUtil.setContentView(this,R.layout.account_layout);


        binding.backimg.setOnClickListener(view -> onBackPressed());
        binding.perIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Account.this,PersonalDetails.class));
            }
        });

        binding.abtIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Account.this,About.class));
            }
        });
        binding.lgIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Account.this,Logout.class));
            }
        });

        binding.personalCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Account.this,PersonalDetails.class));
            }
        });
        binding.aboutCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Account.this,About.class));
            }
        });

        binding.logoutCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Account.this,Logout.class));
            }
        });
    }
}