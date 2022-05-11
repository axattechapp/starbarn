package com.axat.starbarn.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;

import com.axat.starbarn.R;
import com.axat.starbarn.databinding.ActivityNameBinding;

public class NameActivity extends AppCompatActivity {
    ActivityNameBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_name);

        binding.textcontinue.setOnClickListener(view -> {
            Intent intent2=new Intent(NameActivity.this,ImageUploadActivity.class);
            intent2.putExtra("name",binding.editpassedittext.getText().toString());
            startActivity(intent2);
//            startActivity(new Intent(NameActivity.this, ImageUploadActivity.class));
        });
        binding.backimg.setOnClickListener(view -> {
            onBackPressed();
        });

    }
}