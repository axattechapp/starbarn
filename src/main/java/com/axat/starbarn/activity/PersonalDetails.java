package com.axat.starbarn.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.axat.starbarn.R;
import com.axat.starbarn.databinding.PersonalDetailsBinding;

public class PersonalDetails extends AppCompatActivity {
    PersonalDetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.personal_details);

        binding= DataBindingUtil.setContentView(PersonalDetails.this,R.layout.personal_details);
        binding.backimg.setOnClickListener(view -> onBackPressed());
    }
}