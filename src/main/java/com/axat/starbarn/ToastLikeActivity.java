package com.axat.starbarn;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.axat.starbarn.databinding.ActivityToastLikeBinding;

public class ToastLikeActivity extends AppCompatActivity {
    ActivityToastLikeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_toast_like);
//        setContentView(R.layout.activity_toast_like);
    }
}