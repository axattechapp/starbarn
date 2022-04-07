package com.axat.starbarn;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Binder;
import android.os.Bundle;

import com.axat.starbarn.databinding.ActivityToastDislikeBinding;

public class ToastDislikeActivity extends AppCompatActivity {
    ActivityToastDislikeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_toast_dislike);
//        setContentView(R.layout.activity_toast_dislike);
    }
}