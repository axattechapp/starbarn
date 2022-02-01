package com.axat.starbarn.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.axat.starbarn.R;
import com.axat.starbarn.databinding.ActivityCreatePasswordBinding;

public class CreatePasswordActivity extends AppCompatActivity {
    ActivityCreatePasswordBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_create_password);

        binding.textcontinue.setOnClickListener(view -> {
            startActivity(new Intent(CreatePasswordActivity.this, VerfiyNumberActivity.class));
        });
        binding.backimg.setOnClickListener(view -> {
            onBackPressed();
        });

    }
}