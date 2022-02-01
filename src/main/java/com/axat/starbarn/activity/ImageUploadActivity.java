package com.axat.starbarn.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.database.DatabaseUtils;
import android.os.Bundle;

import com.axat.starbarn.R;
import com.axat.starbarn.databinding.ActivityImageUploadBinding;

public class ImageUploadActivity extends AppCompatActivity {
    ActivityImageUploadBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_image_upload);

        binding.backimg.setOnClickListener(view -> {
            onBackPressed();
        });
        binding.textcontinue.setOnClickListener(view -> {
            startActivity(new Intent(ImageUploadActivity.this, CategoriesActivity.class));
        });
    }
}