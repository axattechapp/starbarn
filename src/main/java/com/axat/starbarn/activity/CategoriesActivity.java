package com.axat.starbarn.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;

import com.axat.starbarn.R;
import com.axat.starbarn.databinding.ActivityCategoriesBinding;

public class CategoriesActivity extends AppCompatActivity {

    ActivityCategoriesBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       binding= DataBindingUtil.setContentView(this,R.layout.activity_categories);

       binding.backimg.setOnClickListener(view -> onBackPressed());

       binding.textcontinue.setOnClickListener(view -> {
           startActivity(new Intent(CategoriesActivity.this,HomeActivity.class));
       });
    }
}