package com.axat.starbarn.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.database.DatabaseUtils;
import android.os.Bundle;

import com.axat.starbarn.R;
import com.axat.starbarn.activity.VideoDetails.VideoDetailActivity;
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
            Intent intent1=new Intent(ImageUploadActivity.this, CategoriesActivity.class);
            intent1.putExtra("activity",2);
            startActivity(intent1);
        });
    }
}